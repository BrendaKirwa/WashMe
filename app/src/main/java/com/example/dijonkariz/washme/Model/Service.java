package com.example.dijonkariz.washme.Model;

public class Service {

    private int id;
    private  String serviceName;
    private String duration;
    private String price;
    private  String details;

    public Service(int id, String serviceName, String duration, String price, String details) {
        this.id = id;
        this.serviceName = serviceName;
        this.duration = duration;
        this.price = price;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDuration() {
        return duration;
    }

    public String getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }
}
