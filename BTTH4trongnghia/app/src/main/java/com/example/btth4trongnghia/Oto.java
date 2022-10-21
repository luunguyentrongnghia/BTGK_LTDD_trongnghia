package com.example.btth4trongnghia;

public class Oto {
    private int image;
    private String name;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Oto(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
