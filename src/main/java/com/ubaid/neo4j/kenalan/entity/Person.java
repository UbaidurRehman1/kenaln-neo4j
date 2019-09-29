package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person extends  SEKAI{

    private Long EmployeeId;

    @Relationship(type = "isDoingMaintinanceEvent", direction = Relationship.OUTGOING)
    private MaintinanceEvent maintinanceEvent;

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

    public MaintinanceEvent getMaintinanceEvent() {
        return maintinanceEvent;
    }

    public void setMaintinanceEvent(MaintinanceEvent maintinanceEvent) {
        this.maintinanceEvent = maintinanceEvent;
    }

    @Override
    public String toString() {
        return "Person{" +
                "EmployeeId=" + EmployeeId +
                ", maintinanceEvent=" + maintinanceEvent +
                ", name='" + name + '\'' +
                '}';
    }
}
