package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.sql.Timestamp;

@NodeEntity
public class Assignment extends SEKAI{
    private int assignmentNumber;
    private Timestamp timeAssigned;
    private Timestamp timeScheduled;
    private Long timeEstimate;
    private String approvedBy;

    public  Assignment(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Assignment() {
        super(null, null, null, null);
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(int assignmentNumber) {
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

    public Long getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(Long timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentNumber=" + assignmentNumber +
                ", timeAssigned=" + timeAssigned +
                ", timeScheduled=" + timeScheduled +
                ", timeEstimate=" + timeEstimate +
                ", approvedBy='" + approvedBy + '\'' +
                ", isDoingBy=" + isDoingBy +
                ", name='" + name + '\'' +
                '}';
    }

    @Relationship(type = "isDoingBy", direction = Relationship.OUTGOING)
    private Person isDoingBy;

    public Person getIsDoingBy() {
        return isDoingBy;
    }

    public void setIsDoingBy(Person isDoingBy) {
        this.isDoingBy = isDoingBy;
    }

}
