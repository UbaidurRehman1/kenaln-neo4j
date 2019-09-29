package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Maintenance extends SEKAI{


    public Maintenance(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Maintenance() {
        super(null, null, null, null);

    }

    @Override
    public String toString() {
        return "Maintenance{" +
                ", name='" + name + '\'' +
                '}';
    }
}
