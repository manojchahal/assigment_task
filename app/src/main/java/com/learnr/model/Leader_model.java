package com.learnr.model;

public class Leader_model {
    private String id;
    private String name;
    private int image;
    private String point;

    public Leader_model(String id, String name, int image, String point) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.point = point;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
