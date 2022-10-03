CALL db.index.fulltext.createNodeIndex(“beanNames”, ["CoffeeBean"], ["name"]);

CALL db.index.fulltext.queryNodes("beanNames", $query) YIELD node, score
WITH node, score
RETURN node
ORDER BY score DESC, node.name

// 查询索引
CALL db.indexes();

// 《Graph Databases》P65 Indexes and Constraints
CREATE INDEX ON :Venue(name)
CREATE CONSTRAINT ON (c:Country) ASSERT c.name IS UNIQUE;