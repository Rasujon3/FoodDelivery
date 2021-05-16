package com.sujon.fooddelivery.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sujon.fooddelivery.R;
import com.sujon.fooddelivery.model.DataController;
import com.sujon.fooddelivery.model.MenuItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    View root;
    RecyclerView recyclerView;
    MenuAdapter adapter;
    List<MenuItem> myMenus = new ArrayList<>();

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_menu,container,false);
        recyclerView=root.findViewById(R.id.menuRecycler);
        myMenus = DataController.instance.getCurrentMenuItemList();


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MenuAdapter(myMenus);
        recyclerView.setAdapter(adapter);
        return root;
    }
}
