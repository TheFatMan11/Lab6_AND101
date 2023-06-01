package com.thuydev.lab5;

public class modle_location {
    private String name;
    private int Icon;

    public modle_location() {
    }

    public modle_location(String name, int icon) {
        this.name = name;
        this.Icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }
}
