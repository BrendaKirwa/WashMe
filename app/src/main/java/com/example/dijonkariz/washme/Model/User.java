package com.example.dijonkariz.washme.Model;

/**
 * Created by Brenda.
 */

public class User {

    private int id;
    private String name;
    private String user_type;

    public User(int id, String name, String user_type) {
        this.id = id;
        this.name = name;
        this.user_type = user_type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUser_type() {
        return user_type;
    }
}
