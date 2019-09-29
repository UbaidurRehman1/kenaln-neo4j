package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.Maintenance;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintinanceRepo extends Neo4jRepository<Maintenance, Long> {
    public Maintenance findByName(String name);
}
