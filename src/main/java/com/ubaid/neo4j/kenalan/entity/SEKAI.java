package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@NodeEntity
class SEKAI {

    @Id
    private Long id;
    public String name;
    private String serialNumber;
    private String UUID;
    private String partNumber;

    SEKAI(String name, String serialNumber, String UUID, String partNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.UUID = UUID;
        this.partNumber = partNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public String toString() {
        return "SEKAI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", UUID='" + UUID + '\'' +
                ", partNumber='" + partNumber + '\'' +
                '}';
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SEKAI sekai = (SEKAI) o;
        return Objects.equals(id, sekai.id) &&
                Objects.equals(name, sekai.name) &&
                Objects.equals(serialNumber, sekai.serialNumber) &&
                Objects.equals(UUID, sekai.UUID) &&
                Objects.equals(partNumber, sekai.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, UUID, partNumber);
    }
}
