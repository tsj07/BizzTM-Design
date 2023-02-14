package com.example.bizztmdesign;

import android.widget.ImageView;

public class Model {
    String name, discountedPrice, originalPrice;
    ImageView productImage;

    public Model(String name, String discountedPrice, String originalPrice, ImageView productImage) {
        this.name = name;
        this.discountedPrice = discountedPrice;
        this.originalPrice = originalPrice;
        this.productImage = productImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public ImageView getProductImage() {
        return productImage;
    }

    public void setProductImage(ImageView productImage) {
        this.productImage = productImage;
    }
}
