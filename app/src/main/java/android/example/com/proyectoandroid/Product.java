package android.example.com.proyectoandroid;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Product implements Serializable {

    private String id;
    private String description;
    private String price;

    public Product(String id, String description, String price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
