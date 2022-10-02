package com.example.neo4jdemo.domains;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * spring data neo4j 6.1.1 Repository Relationship primary_id not allowing to use UUID String where as for Node Primary_id UUID String is working
 * https://stackoverflow.com/questions/67918490/spring-data-neo4j-6-1-1-repository-relationship-primary-id-not-allowing-to-use-u
 */
@RelationshipProperties
public class AppearsOn {
    @Id
    @GeneratedValue
    private Long id;

    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String uuid;

    @Property("song_nr")
    private Integer songNr;

    @TargetNode
    private Release release;

    public Integer getSongNr() {
        return songNr;
    }

    public void setSongNr(Integer songNr) {
        this.songNr = songNr;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

}
