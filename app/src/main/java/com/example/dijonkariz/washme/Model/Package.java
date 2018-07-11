package com.example.dijonkariz.washme.Model;

public class Package {

    public int id;
    public  String package_name;
    public String price;
    public String timePeriod;
    public String details;

    public Package(int id, String package_name, String price, String timePeriod, String details) {
        this.id = id;
        this.package_name = package_name;
        this.price = price;
        this.timePeriod = timePeriod;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getPrice() {
        return price;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public String getDetails() {
        return details;
    }
}
