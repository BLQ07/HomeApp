package com.example.home.First;

public class Incubator {
    private  int size;
    private String id;
    private String name;
    private Double temperature;
    private Double humidity;
    private String image;

    public Incubator( String name,int size, Double temperature, Double humidity, String image) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.temperature = temperature;
        this.humidity = humidity;
        this.image = image;
    }

    public Incubator() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public String getImage() {
        return image;
    }
    public void setObjectId(String id){
        this.id = id;
    }

    public int getSize() {
        return size;
    }
}
