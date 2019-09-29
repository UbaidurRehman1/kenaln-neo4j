package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.sql.Timestamp;

@NodeEntity
public class MaintinanceEvent extends SEKAI {

    private Long AssignmentNumber;
    private Timestamp time;
    private Long duration;
    private boolean completed;

    @Relationship(type = "relatedTo", direction = Relationship.OUTGOING)
    private Object object;

    public MaintinanceEvent(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public MaintinanceEvent() {
        super(null, null, null, null);
    }

    public Long getAssignmentNumber() {
        return AssignmentNumber;
    }

    public void setAssignmentNumber(Long assignmentNumber) {
        AssignmentNumber = assignmentNumber;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MaintinanceEvent{" +
                "AssignmentNumber=" + AssignmentNumber +
                ", time=" + time +
                ", duration=" + duration +
                ", completed=" + completed +
                ", object=" + object +
                ", name='" + name + '\'' +
                '}';
    }
}
