package com.example.stitchingapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.stitchingapp.Activity.BabySkirt_Activity;
import com.example.stitchingapp.Activity.BarbieFrock_Activity;
import com.example.stitchingapp.Activity.OnePiece_Activity;
import com.example.stitchingapp.Activity.Plaza_Activity;
import com.example.stitchingapp.Activity.Shorty_Activity;
import com.example.stitchingapp.Activity.Top_Activity;
import com.example.stitchingapp.R;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    ImageView image1, image2, image3, image4;
    ImageView img1, img2, img3, img4, img5, img6;
    TextView special_for, our_collect;
    SearchView searchView;
    ListView listView;
    private ImageView profileImageView;
    private SharedPreferences sharedPreferences;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        // Find views by ID
        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        image3 = view.findViewById(R.id.image3);
        image4 = view.findViewById(R.id.image4);

        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);
        img4 = view.findViewById(R.id.img4);
        img5 = view.findViewById(R.id.img5);
        img6 = view.findViewById(R.id.img6);

        special_for = view.findViewById(R.id.special_for);
        our_collect = view.findViewById(R.id.our_collect);
        profileImageView = view.findViewById(R.id.profile);

        searchView = view.findViewById(R.id.searchView);
        listView = view.findViewById(R.id.listview);


        list = new ArrayList<>();

        list.add("Top");
        list.add("Plaza");
        list.add("One Piece");
        list.add("Barbie Frock");
        list.add("Baby Skirt");
        list.add("Shorty");

        sharedPreferences = getActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        loadSavedData();

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                handleSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);


                if (newText.isEmpty()) {
                    showDefaultView();
                } else {
                    showListView();
                }

                return false;
            }
        });


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home_Fragment.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sj_mZRMRYPw")));
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home_Fragment.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0gD2gWxU4Lw?si=8tTXm9jUDA7oXnoF")));
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home_Fragment.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/E-Af1F8hM8g?si=egIOhqVL8FLQ4zwO")));
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home_Fragment.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Igrr0MVwKps?si=7LglL8ByKrvlArGD")));
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OnePiece_Activity.class);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BarbieFrock_Activity.class);
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BabySkirt_Activity.class);
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Shorty_Activity.class);
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Plaza_Activity.class);
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Top_Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void handleSearch(String query) {

        switch (query.toLowerCase()) {
            case "one piece":
                startActivity(new Intent(getActivity(), OnePiece_Activity.class));
                break;
            case "barbie frock":
                startActivity(new Intent(getActivity(), BarbieFrock_Activity.class));
                break;
            case "baby skirt":
                startActivity(new Intent(getActivity(), BabySkirt_Activity.class));
                break;
            case "shorty":
                startActivity(new Intent(getActivity(), Shorty_Activity.class));
                break;
            case "plaza":
                startActivity(new Intent(getActivity(), Plaza_Activity.class));
                break;
            case "top":
                startActivity(new Intent(getActivity(), Top_Activity.class));
                break;
            default:

                break;
        }
    }

    private void showDefaultView() {
        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.VISIBLE);
        image3.setVisibility(View.VISIBLE);
        image4.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        special_for.setVisibility(View.VISIBLE);
    }

    private void showListView() {
        image1.setVisibility(View.GONE);
        image2.setVisibility(View.GONE);
        image3.setVisibility(View.GONE);
        image4.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        special_for.setVisibility(View.GONE);
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
