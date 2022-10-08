package com.example.neo4jdemo.domains;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.GeneratedValue.InternalIdGenerator;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class User {
    @Id
    @GeneratedValue
    private Long id;

    // @Property("id")
    // @GeneratedValue
    // private Long uid;

    // public Long getUid() {
        // return uid;
    // }

    // public void setUid(Long uid) {
        // this.uid = uid;
    // }

    private String name;

    private List<String> hobbies;

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public interface Hobbies {
        public String[] getHobbies();
    }

}
