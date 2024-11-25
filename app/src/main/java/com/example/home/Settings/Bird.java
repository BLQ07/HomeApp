package com.example.home.Settings;
public class Bird {
    private String name;
    private String objectId;
    private Double maxTemp;
    private Double maxHum;
    private int day;

    public Bird(String name, String objectId, Double maxTemp, Double maxHum, int day) {
        this.name = name;
        this.objectId = objectId;
        this.maxTemp = maxTemp;
        this.maxHum = maxHum;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getMaxHum() {
        return maxHum;
    }

    public void setMaxHum(Double maxHum) {
        this.maxHum = maxHum;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

