package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.MaintinanceEvent;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintinanceEventRepo extends Neo4jRepository<MaintinanceEvent, Long> {
}
