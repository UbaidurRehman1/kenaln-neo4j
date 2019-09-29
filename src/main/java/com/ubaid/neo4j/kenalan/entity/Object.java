package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Object extends SEKAI{

    @Relationship(type = "isDoingMaintenanceEvent")
    private List<Person> isDoingMaintenanceEvents;

    public Object(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Object() {
        super(null, null, null, null);
    }

    @Relationship(type = "isPartOf", direction = Relationship.OUTGOING)
    private Object isPartOf;

    @Relationship(type = "is", direction = Relationship.OUTGOING)
    private NodeType nodeType;


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

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public String toString() {
        return "Object{" +
                "isPartOf=" + isPartOf +
//                ", isPart=" + isPart +
//                ", isAssembly=" + isAssembly +
                ", isMadeOf=" + isMadeOf +
                ", isMadeBy=" + isMadeBy +
                ", name='" + name + '\'' +
                '}';
    }

    public void addPerson(Person person) {
        if (isDoingMaintenanceEvents == null) {
            isDoingMaintenanceEvents = new ArrayList<Person>();
        }
        isDoingMaintenanceEvents.add(person);
    }

    public Person removePerson(Long id) {
        Person person = null;
        for (int i = 0; i < isDoingMaintenanceEvents.size(); i++) {
            person = isDoingMaintenanceEvents.get(i);
            if (person.getId().equals(id)) {
                isDoingMaintenanceEvents.remove(person);
            }
        }
        return  person;
    }

    //------------------------------to store in name -------------------------//
    private String manufacturerName;
    private String materialName;
    private String nodeTypeName;

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getNodeTypeName() {
        return nodeTypeName;
    }

    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }

    public List<Person> getIsDoingMaintenanceEvents() {
        return isDoingMaintenanceEvents;
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
