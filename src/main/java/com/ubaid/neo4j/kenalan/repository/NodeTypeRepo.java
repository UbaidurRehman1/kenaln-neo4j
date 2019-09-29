package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.NodeType;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NodeTypeRepo extends Neo4jRepository<NodeType, Long> {
    public NodeType findByName(String name);
}
