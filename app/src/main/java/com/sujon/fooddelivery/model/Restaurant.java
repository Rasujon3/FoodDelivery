package com.sujon.fooddelivery.model;

import java.util.List;

public class Restaurant {
    String restaurantName;
    String restaurantDescription;
    String restaurantImageUrl;
    String restaurantLocation;
    List<MenuItem> restaurantMenuList;

    public Restaurant() {
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public String getRestaurantImageUrl() {
        return restaurantImageUrl;
    }

    public void setRestaurantImageUrl(String restaurantImageUrl) {
        this.restaurantImageUrl = restaurantImageUrl;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<MenuItem> getRestaurantMenuList() {
        return restaurantMenuList;
    }

    public void setRestaurantMenuList(List<MenuItem> restaurantMenuList) {
        this.restaurantMenuList = restaurantMenuList;
    }
}
