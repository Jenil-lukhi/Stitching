package com.example.stitchingapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.stitchingapp.Activity.Save_Activity;
import com.example.stitchingapp.LoginActivity.SignIn_Activity;
import com.example.stitchingapp.Person_Activity.EditProfile_Activity;
import com.example.stitchingapp.R;

public class Person_Fragment extends Fragment {

    private TextView editText;
    private ImageView profileImageView;
    private SharedPreferences sharedPreferences;

    LinearLayout editProfile,save;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person_, container, false);



        View logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(v -> handleLogout());

        editText = view.findViewById(R.id.edit_profil);
        profileImageView = view.findViewById(R.id.ellipse_20);
        editProfile = view.findViewById(R.id.edit);
        save = view.findViewById(R.id.your_favorite);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Save_Activity.class);
                startActivity(intent);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfile_Activity.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        loadSavedData();

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfile_Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void handleLogout() {
        Intent intent = new Intent(getActivity(), SignIn_Activity.class);
        startActivity(intent);
    }

    private void loadSavedData() {
        String encodedImage = sharedPreferences.getString("profile_image", "");
        if (!encodedImage.isEmpty()) {
            byte[] decodedByte = Base64.decode(encodedImage, 0);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
            profileImageView.setImageBitmap(bitmap);
        }
    }
}
