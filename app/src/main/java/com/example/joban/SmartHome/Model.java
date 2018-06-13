package com.example.joban.SmartHome;

/**
 * Created by joban on 03/03/2018.
 */

public class Model {

    private String name;
    private String place;
    private boolean selected;

    public Model(String name) {
        this.name = name;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}