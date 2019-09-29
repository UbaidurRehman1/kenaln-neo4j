package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.Assembly;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssemblyRepo extends Neo4jRepository<Assembly, Long> {
}
