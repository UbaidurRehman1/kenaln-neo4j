package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.*;

import java.sql.Timestamp;

@RelationshipEntity(type = "isAssigned")
public class Assignment{

    @StartNode
    private Maintenance maintenance;
    private String partName;
    @EndNode
    private Person person;
    private String personName;

    private Integer assignmentNumber;
    private Timestamp timeAssigned;
    private Timestamp timeScheduled;
    private float timeEstimate;
    private String approvedByName;

    @Id
    private Long id;


    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(Integer assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    public Timestamp getTimeAssigned() {
        return timeAssigned;
    }

    public void setTimeAssigned(Timestamp timeAssigned) {
        this.timeAssigned = timeAssigned;
    }

    public Timestamp getTimeScheduled() {
        return timeScheduled;
    }

    public void setTimeScheduled(Timestamp timeScheduled) {
        this.timeScheduled = timeScheduled;
    }

    public float getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(float timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public String getApprovedByName() {
        return approvedByName;
    }

    public void setApprovedByName(String approvedByName) {
        this.approvedByName = approvedByName;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                ", partName='" + partName + '\'' +
                ", personName='" + personName + '\'' +
                ", assignmentNumber=" + assignmentNumber +
                ", timeAssigned=" + timeAssigned +
                ", timeScheduled=" + timeScheduled +
                ", timeEstimate=" + timeEstimate +
                ", approvedByName='" + approvedByName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
