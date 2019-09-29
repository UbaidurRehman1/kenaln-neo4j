package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Maintenance extends SEKAI{


    public Maintenance(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Maintenance() {
        super(null, null, null, null);

    }

//    @Relationship(type = "isAssigned", direction = Relationship.OUTGOING)
//    private Assignment isAssigned;

//    public Assignment getIsAssigned() {
//        return isAssigned;
//    }

//    public void setIsAssigned(Assignment isAssigned) {
//        this.isAssigned = isAssigned;
//    }

    @Override
    public String toString() {
        return "Maintenance{" +
//                "isAssigned=" + isAssigned +
                ", name='" + name + '\'' +
                '}';
    }
}
