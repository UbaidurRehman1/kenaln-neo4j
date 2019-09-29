package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Material extends SEKAI{

    private String materialID;

    public Material(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Material() {
        super(null, null, null, null);
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialID='" + materialID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
