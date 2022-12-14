package com.example.neo4jdemo.repositories;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Result;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.neo4jdemo.domains.Menu;
import com.example.neo4jdemo.domains.MenuProjection;

public interface MenuRepository extends Neo4jRepository<Menu, String> {
    @Query("""
            MATCH (m:Menu) <- [r:IS_SUBMENU] - (subs)
            WHERE id(m) = $id
            RETURN m, collect(r), collect(subs)
            """)
    Menu findDepthOne(@Param("id") Long id);

    @Query("""
        MATCH (m:Menu) <- [r:IS_SUBMENU*] - (subs)
        WHERE id(m) = $id
        RETURN m, collect(r), collect(subs);
            """)
    Menu findNested(@Param("id") Long id);

    @Query("""
        MATCH (m:Menu)
        RETURN m;
            """)
    List<Menu> findMenus();

    @Query("""
        match p=(user:User)-[*]->(menus:Menu)<-[r:IS_SUBMENU*0..]-(subs:Menu)
        where id(user) = $id
        return menus, collect(r), collect(subs);
            """)
    public List<Menu> findMenusByUserId(@Param("id") Long id);

    @Query("""
            match (menu)
            where id(menu) IN $ids
            return menu;
            """)
    public List<Menu> findByIds(List<Long> ids);

    /**
     * 如何返回多个属性
     * 可以在Cypher中返回map，然后用POJO类接收
     * https://stackoverflow.com/questions/30326384/neo4j-cypher-return-structured-map
     */
    @Query("""
            MATCH (m:Menu)
            WITH id(m) AS id, m.name AS name
            RETURN {name: name} AS menu;
            """)
    public List<MenuProjection> findMenuNames();

    public List<MenuProjection> findByName(String name);

    @Query("""
            match (m:Menu)
            return m.name
            """)
    public Result findResult();


    @Query("""
                match (m:Menu)
                return m.name as name
                    """)
    List<String> findIterable();

}