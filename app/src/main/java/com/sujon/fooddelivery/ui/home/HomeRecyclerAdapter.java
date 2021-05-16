package com.sujon.fooddelivery.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.sujon.fooddelivery.R;
import com.sujon.fooddelivery.model.Restaurant;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.viewHolder> {
    List<Restaurant> allRestaurants;

    public HomeRecyclerAdapter(List<Restaurant> allRestaurants) {
        this.allRestaurants = allRestaurants;
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewHolder holder, int position) {
        Restaurant current = allRestaurants.get(position);
        holder.restaurantName.setText(current.getRestaurantName());
        holder.restaurantDescription.setText(current.getRestaurantDescription());
        Picasso.get().load(current.getRestaurantImageUrl()).fit().into(holder.restaurantImage);

    }

    @Override
    public int getItemCount() {
        if (allRestaurants==null||allRestaurants.size()==0){
            return 0;
        }else {
            return allRestaurants.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView restaurantImage;
        TextView restaurantName,restaurantDescription;


        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            restaurantImage=itemView.findViewById(R.id.restaurantImageView);
            restaurantName=itemView.findViewById(R.id.restaurantNameTextView);
            restaurantDescription=itemView.findViewById(R.id.restaurantDescriptionTextView);
        }
    }
}
