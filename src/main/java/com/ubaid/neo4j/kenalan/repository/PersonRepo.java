package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends Neo4jRepository<Person, Long> {
}
