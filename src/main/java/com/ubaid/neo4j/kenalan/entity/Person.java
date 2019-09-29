package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Person extends  SEKAI{

    private Long EmployeeId;

    @Relationship(type = "isAssigned")
    private List<Maintenance> assignments;

    public Person(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Person() {
        super(null, null, null, null);

    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public void addAssignment(Maintenance maintenance) {
        if (assignments == null) {
            assignments = new ArrayList<Maintenance>();
        }
        assignments.add(maintenance);
    }

    public Maintenance removeAssignment(Long id) {
        Maintenance maintenance = null;
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(id)) {
                maintenance = assignments.get(i);
                assignments.remove(maintenance);
                break;
            }
        }
        return maintenance;
    }

    @Override
    public String toString() {
        return "Person{" +
                "EmployeeId=" + EmployeeId +
                ", assignments=" + assignments +
                ", name='" + name + '\'' +
                '}';
    }
}
