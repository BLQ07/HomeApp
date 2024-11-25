package com.example.home;

public class Bruder {

    private  int size;
    private String id;
    private String name;
    private Double temperature;

    public Bruder(int size, String name, Double temperature, Double humidity, String image) {
        this.size = size;
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.image = image;
    }

    public Bruder() {
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private Double humidity;
    private String image;

}
