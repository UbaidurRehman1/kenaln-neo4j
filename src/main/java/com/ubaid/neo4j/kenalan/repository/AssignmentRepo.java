package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.Assignment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends Neo4jRepository<Assignment, Long> {
}
