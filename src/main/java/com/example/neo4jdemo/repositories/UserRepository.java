package com.example.neo4jdemo.repositories;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.neo4jdemo.domains.Menu;
import com.example.neo4jdemo.domains.User;

public interface UserRepository extends Neo4jRepository<User, String> {

    @Query("""
        match p=(user:User)-[*]->(menus:Menu)<-[r:IS_SUBMENU*0..]-(subs:Menu)
        where user.id = $id
        return collect(menus)
            """)
    public List<Menu> findMenusByUserId(@Param("id") String id);
}
