package com.thuydev.lab5;

import java.io.Serializable;

public class modle_sinhvien  implements Serializable {
private String name;
private String location;
private String coSo;

    public modle_sinhvien() {
    }

    public modle_sinhvien(String name, String location, String coSo) {
        this.name = name;
        this.location = location;
        this.coSo = coSo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }
}
