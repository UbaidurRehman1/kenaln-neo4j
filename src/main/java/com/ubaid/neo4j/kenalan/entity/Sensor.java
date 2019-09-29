package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Sensor extends SEKAI{

    public Sensor(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    @Relationship(type = "isPartOf", direction = Relationship.OUTGOING)
    private Object isPartOf;

    public Object getIsPartOf() {
        return isPartOf;
    }

    public void setIsPartOf(Object isPartOf) {
        this.isPartOf = isPartOf;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "isPartOf=" + isPartOf +
                ", name='" + name + '\'' +
                '}';
    }
}
