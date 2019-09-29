package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Assembly extends  NodeType {
    Assembly(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Assembly() {
        super(null, null, null, null);
    }

    @Override
    public String toString() {
        return "Assembly{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(java.lang.Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
