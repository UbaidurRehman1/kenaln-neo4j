package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

@NodeEntity
public class Object extends SEKAI{

    public Object(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Object() {
        super(null, null, null, null);
    }

    @Relationship(type = "isPartOf", direction = Relationship.OUTGOING)
    private Object isPartOf;

    @Relationship(type = "is", direction = Relationship.OUTGOING)
    private Part isPart;

    @Relationship(type = "is", direction = Relationship.OUTGOING)
    private Assembly isAssembly;

    @Relationship(type = "isMadeOf", direction = Relationship.INCOMING)
    private Material isMadeOf;

    @Relationship(type = "isMadeBy", direction = Relationship.INCOMING)
    private Manufacturer isMadeBy;

    public Object getIsPartOf() {
        return isPartOf;
    }

    public void setIsPartOf(Object isPartOf) {
        this.isPartOf = isPartOf;
    }

    public Part getIsPart() {
        return isPart;
    }

    public void setIsPart(Part isPart) {
        this.isPart = isPart;
    }

    public Assembly getIsAssembly() {
        return isAssembly;
    }

    public void setIsAssembly(Assembly isAssembly) {
        this.isAssembly = isAssembly;
    }

    public Material getIsMadeOf() {
        return isMadeOf;
    }

    public void setIsMadeOf(Material isMadeOf) {
        this.isMadeOf = isMadeOf;
    }

    public Manufacturer getIsMadeBy() {
        return isMadeBy;
    }

    public void setIsMadeBy(Manufacturer isMadeBy) {
        this.isMadeBy = isMadeBy;
    }

    @Override
    public String toString() {
        return "Object{" +
                "isPartOf=" + isPartOf +
                ", isPart=" + isPart +
                ", isAssembly=" + isAssembly +
                ", isMadeOf=" + isMadeOf +
                ", isMadeBy=" + isMadeBy +
                ", name='" + name + '\'' +
                '}';
    }
}
