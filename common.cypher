CALL db.index.fulltext.createNodeIndex(“beanNames”, ["CoffeeBean"], ["name"]);

CALL db.index.fulltext.queryNodes("beanNames", $query) YIELD node, score
WITH node, score
RETURN node
ORDER BY score DESC, node.name