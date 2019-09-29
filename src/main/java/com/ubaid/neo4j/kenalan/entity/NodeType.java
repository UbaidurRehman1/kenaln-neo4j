package com.ubaid.neo4j.kenalan.entity;

import java.util.Objects;

public class NodeType extends  SEKAI{

    public NodeType(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeType)) return false;
        NodeType that = (NodeType) o;
        return name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
