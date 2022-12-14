package com.example.neo4jdemo.repositories;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.neo4jdemo.domains.Menu;
import com.example.neo4jdemo.domains.User;
import com.example.neo4jdemo.domains.User.Hobbies;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("""
        match p=(user:User)-[*]->(menus:Menu)<-[r:IS_SUBMENU*0..]-(subs:Menu)
        where user.id = $id
        return collect(menus)
            """)
    public List<Menu> findMenusByUserId(@Param("id") Long id);

    @Query("""
        match (user:User)
        where user.id = $id
        return user.hobbies as hobbies;
            """)
    public List<List<String>> findHobbies(@Param("id") Long id);


    @Query("""
            match (user:User)
            where user.id = $id
            return user.name;
            """)
    public String findName(@Param("id") Long id);
}
