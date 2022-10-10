package com.example.neo4jdemo.domains;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class Menu {
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String id;

    private String name;

    private String description;

    @Relationship(type = "IS_SUBMENU", direction = Relationship.Direction.INCOMING)
    List<Menu> subMenus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
