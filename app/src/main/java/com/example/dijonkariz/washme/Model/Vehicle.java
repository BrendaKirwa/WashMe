package com.example.dijonkariz.washme.Model;

/**
 * Created by Brenda.
 */

public class Vehicle {

    String vehicleName;
    int vehicleId;
    String vehicleImage;

    public Vehicle(String vehicleName, int vehicleId, String vehicleImage) {
        this.vehicleName = vehicleName;
        this.vehicleId = vehicleId;
        this.vehicleImage = vehicleImage;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }
}
