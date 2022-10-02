package com.example.neo4jdemo.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.neo4jdemo.domains.Song;

public interface SongRepository extends Neo4jRepository<Song, String> {
}