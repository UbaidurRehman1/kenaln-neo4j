package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.Material;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MaterialRepo extends Neo4jRepository<Material, Long> {
}
