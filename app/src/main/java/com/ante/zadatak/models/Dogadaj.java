package com.ante.zadatak.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Dogadaj {
    public String name;
    public String description;
    public String image;
    public String date;
    public String vrijeme;

    public Dogadaj() {
    }

    public Dogadaj(String name, String description, String image, String date, String vrijeme) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.date = date;
        this.vrijeme = vrijeme;
    }
}

