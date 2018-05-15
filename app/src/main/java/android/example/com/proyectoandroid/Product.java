package android.example.com.proyectoandroid;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String description;
    private String price;

    public Product(int id, String description, String price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
