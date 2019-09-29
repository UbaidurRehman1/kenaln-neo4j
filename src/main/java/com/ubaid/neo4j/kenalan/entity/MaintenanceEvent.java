package com.ubaid.neo4j.kenalan.entity;

import com.ubaid.neo4j.kenalan.util.Labels;
import org.neo4j.ogm.annotation.*;

import java.sql.Timestamp;

@RelationshipEntity(type = Labels.IS_DOING_MAINTENANCE_EVENT)
public class MaintenanceEvent {

    @StartNode
    private Person person;

    @EndNode
    private Object object;

    @Id
    private Long id;

    private Long assignmentNumber;
    private Timestamp time;
    private Long duration;
    private boolean completed;
    private String type;
    private String personName;
    private String objectName;


    public MaintenanceEvent(Long assignmentNumber, Timestamp time, Long duration, boolean completed) {
        this.assignmentNumber = assignmentNumber;
        this.time = time;
        this.duration = duration;
        this.completed = completed;
    }

    public MaintenanceEvent(Person person, Object object, Long assignmentNumber, Timestamp time, Long duration, boolean completed) {
        this.person = person;
        this.object = object;
        this.assignmentNumber = assignmentNumber;
        this.time = time;
        this.duration = duration;
        this.completed = completed;
    }

    public MaintenanceEvent() {
    }

    public Long getAssignmentNumber() {
        return this.assignmentNumber;
    }

    public void setAssignmentNumber(Long assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MaintenanceEvent{" +
                "person=" + person +
                ", object=" + object +
                ", AssignmentNumber=" + assignmentNumber +
                ", time=" + time +
                ", duration=" + duration +
                ", completed=" + completed +
                '}';
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
