package com.sujon.fooddelivery.model;

import com.sujon.fooddelivery.RestaurantInterface;

public class DataController  {
    public static DataController instance;
    public static DataController getInstance() {
        if (instance == null)
            instance = new DataController();

        return instance;
    }

    RestaurantInterface restaurantInterface;

    public RestaurantInterface getRestaurantInterface() {
        return restaurantInterface;
    }

    public void setRestaurantInterface(RestaurantInterface restaurantInterface) {
        this.restaurantInterface = restaurantInterface;
    }
}
