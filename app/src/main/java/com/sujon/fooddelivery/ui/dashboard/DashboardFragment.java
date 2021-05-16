package com.sujon.fooddelivery.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;
import com.sujon.fooddelivery.R;

public class DashboardFragment extends Fragment {
    FirebaseUser user;
    ImageView userProfile;
    TextView emailText,nameText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        userProfile=root.findViewById(R.id.imageView);
        emailText=root.findViewById(R.id.textView2);
        nameText=root.findViewById(R.id.textView);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            emailText.setText("Email : "+user.getEmail());
            nameText.setText("Name : "+user.getDisplayName());
            Picasso.get().load(user.getPhotoUrl()).fit().into(userProfile);
        }

        return root;
    }
}