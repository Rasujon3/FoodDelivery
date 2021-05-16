package com.sujon.fooddelivery.ui.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sujon.fooddelivery.R;
import com.sujon.fooddelivery.model.MenuItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.viewHolder> {

    List<MenuItem> allmenuItem;

    public MenuAdapter(List<MenuItem> allRestaurants) {
        this.allmenuItem = allRestaurants;
    }

    @NonNull
    @NotNull
    @Override
    public MenuAdapter.viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);

        return new MenuAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MenuAdapter.viewHolder holder, int position) {
        MenuItem current = allmenuItem.get(position);

    }

    @Override
    public int getItemCount() {
        if (allmenuItem ==null|| allmenuItem.size()==0){
            return 0;
        }else {
            return allmenuItem.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView menuItemName, menuDescription,priceTextview;


        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            menuItemName =itemView.findViewById(R.id.itemNametextview);
            menuDescription =itemView.findViewById(R.id.itemDescriptiontextview);
            priceTextview = itemView.findViewById(R.id.itemPricetextview);

        }
    }

}
