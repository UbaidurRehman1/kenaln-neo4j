package com.ubaid.neo4j.kenalan.entity;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Manufacturer extends  SEKAI{

    private String erpNumber;
    private String clientId;
    private String address;
    private String phone;

    public Manufacturer(String name, String serialNumber, String UUID, String partNumber) {
        super(name, serialNumber, UUID, partNumber);
    }

    public Manufacturer() {
        super(null, null, null, null);
    }

    public String getErpNumber() {
        return erpNumber;
    }

    public void setErpNumber(String erpNumber) {
        this.erpNumber = erpNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "erpNumber='" + erpNumber + '\'' +
                ", clientId='" + clientId + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
