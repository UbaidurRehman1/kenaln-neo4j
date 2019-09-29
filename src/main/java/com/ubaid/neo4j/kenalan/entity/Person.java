package com.ubaid.neo4j.kenalan.entity;

import com.ubaid.neo4j.kenalan.util.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
public class Person extends  SEKAI{

    private Long EmployeeId;

    @Relationship(type = Labels.IS_ASSIGNED)
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}
