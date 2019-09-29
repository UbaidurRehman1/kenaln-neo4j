package com.ubaid.neo4j.kenalan.repository;

import com.ubaid.neo4j.kenalan.entity.Manufacturer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ManufacturerRepo extends Neo4jRepository<Manufacturer, Long> {
}
