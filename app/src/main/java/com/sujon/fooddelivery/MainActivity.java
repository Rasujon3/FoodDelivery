package com.sujon.fooddelivery;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.firebase.firestore.*;
import com.sujon.fooddelivery.model.DataController;
import com.sujon.fooddelivery.model.MenuItem;
import com.sujon.fooddelivery.model.Restaurant;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RestaurantInterface {
    private static final String TAG = "MainActivity";
    RestaurantInterface restaurantInterface;
    DataController controller;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        restaurantInterface=this;

        controller = DataController.getInstance();
        controller.setRestaurantInterface(restaurantInterface);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

       // SendDataToFirestore();


       // GetDataFromFirestore();

    }



    private void SendDataToFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference reference = db.collection("Restaurants");
        Restaurant myRestaurant = new Restaurant();
        myRestaurant.setRestaurantName("Sujon Restaurants");
        myRestaurant.setRestaurantDescription("Best restaurant in Gaibandha");
        myRestaurant.setRestaurantLocation("Bonarpara, Gaibandha");
        myRestaurant.setRestaurantImageUrl("https://img.freepik.com/free-photo/assorted-indian-recipes-food-various_79295-7226.jpg?size=626&ext=jpg");

        List<MenuItem> myMenus = new ArrayList<>();
        for (int i =0; i<15;i++){
            myMenus.add(new MenuItem("Mutton Kacchi","Best one",450));

        }
        myRestaurant.setRestaurantMenuList(myMenus);

        reference.add(myRestaurant).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Restaurant Uploaded Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Restaurant not Uploaded", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRestaurantClick(Restaurant restaurant) {
        controller.setCurrentMenuItemList(restaurant.getRestaurantMenuList());
        navController.navigate(R.id.action_navigation_home_to_navigation_menu);

    }
}