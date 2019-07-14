package com.example.event;

public class Model {
    private int image;
    private  String title;
    private  String descrip;

    public Model(int image, String title, String descrip) {
        this.image = image;
        this.title = title;
        this.descrip = descrip;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
