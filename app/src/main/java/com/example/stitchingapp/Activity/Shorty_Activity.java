package com.example.stitchingapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stitchingapp.R;

import java.util.HashSet;
import java.util.Set;

public class Shorty_Activity extends AppCompatActivity {

    ImageView im1, im2, im3, im4, im5, im6, im7, im8;
    ImageView like1, like2, like3, like4, like5,like6,like7,like8;
    private boolean isLiked1, isLiked2, isLiked3, isLiked4, isLiked5, isLiked6, isLiked7, isLiked8;
    private SharedPreferences sharedPreferences;
    View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shorty);

        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);
        im5 = findViewById(R.id.im5);
        im6 = findViewById(R.id.im6);
        im7 = findViewById(R.id.im7);
        im8 = findViewById(R.id.im8);

        sharedPreferences = getSharedPreferences("liked_Images4", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked25", false);
        isLiked2 = sharedPreferences.getBoolean("isLiked26", false);
        isLiked3 = sharedPreferences.getBoolean("isLiked27", false);
        isLiked4 = sharedPreferences.getBoolean("isLiked28", false);
        isLiked5 = sharedPreferences.getBoolean("isLiked29", false);
        isLiked6 = sharedPreferences.getBoolean("isLiked30", false);
        isLiked7 = sharedPreferences.getBoolean("isLiked31", false);
        isLiked8 = sharedPreferences.getBoolean("isLiked32", false);

        like1 = findViewById(R.id.like1);
        like2 = findViewById(R.id.like2);
        like3 = findViewById(R.id.like3);
        like4 = findViewById(R.id.like4);
        like5 = findViewById(R.id.like5);
        like6 = findViewById(R.id.like6);
        like7 = findViewById(R.id.like7);
        like8 = findViewById(R.id.like8);

        like1.setImageResource(isLiked1 ? R.drawable.like2 : R.drawable.like1);
        like2.setImageResource(isLiked2 ? R.drawable.like2 : R.drawable.like1);
        like3.setImageResource(isLiked3 ? R.drawable.like2 : R.drawable.like1);
        like4.setImageResource(isLiked4 ? R.drawable.like2 : R.drawable.like1);
        like5.setImageResource(isLiked5 ? R.drawable.like2 : R.drawable.like1);
        like6.setImageResource(isLiked6 ? R.drawable.like2 : R.drawable.like1);
        like7.setImageResource(isLiked7 ? R.drawable.like2 : R.drawable.like1);
        like8.setImageResource(isLiked8 ? R.drawable.like2 : R.drawable.like1);

        like1.setOnClickListener(v -> toggleLike(1));
        like2.setOnClickListener(v -> toggleLike(2));
        like3.setOnClickListener(v -> toggleLike(3));
        like4.setOnClickListener(v -> toggleLike(4));
        like5.setOnClickListener(v -> toggleLike(5));
        like6.setOnClickListener(v -> toggleLike(6));
        like7.setOnClickListener(v -> toggleLike(7));
        like8.setOnClickListener(v -> toggleLike(8));

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/EONbpM0iDfs?si=qgnRJqOJtuOr6j_C");
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/bk-IrOaDhVY?si=uiJEuQFJRJGaoXgS");
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/cz0CAM-fRpA?si=aCCCqYDIzygfmkwO");
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/3pTwzitPTsk?si=mqD4jl85yTheKmn6");
            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/S2thSeazPWc?si=TAadLbziPTYTEYSE");
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/FMA9cOlgRwQ?si=v687z-J8cx9f4-ZR");
            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/1sfJoht8GlM?si=0C_EfDTq2i4McVMC");
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/rnanhIYvEVk?si=3s-JX9eWbofoxedP");
            }
        });
    }

    private void openUrl(String url) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    private void toggleLike(int imageIndex) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean isLiked = false;
        String imageUri = "";

        switch (imageIndex) {
            case 1:
                isLiked1 = !isLiked1;
                editor.putBoolean("isLiked25", isLiked1);
                like1.setImageResource(isLiked1 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/EONbpM0iDfs?si=qgnRJqOJtuOr6j_C";
                isLiked = isLiked1;
                break;
            case 2:
                isLiked2 = !isLiked2;
                editor.putBoolean("isLiked26", isLiked2);
                like2.setImageResource(isLiked2 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/bk-IrOaDhVY?si=uiJEuQFJRJGaoXgS";
                isLiked = isLiked2;
                break;
            case 3:
                isLiked3 = !isLiked3;
                editor.putBoolean("isLiked27", isLiked3);
                like3.setImageResource(isLiked3 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/cz0CAM-fRpA?si=aCCCqYDIzygfmkwO";
                isLiked = isLiked3;
                break;
            case 4:
                isLiked4 = !isLiked4;
                editor.putBoolean("isLiked28", isLiked4);
                like4.setImageResource(isLiked4 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/3pTwzitPTsk?si=mqD4jl85yTheKmn6";
                isLiked = isLiked4;
                break;
            case 5:
                isLiked5 = !isLiked5;
                editor.putBoolean("isLiked29", isLiked5);
                like5.setImageResource(isLiked5 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/S2thSeazPWc?si=TAadLbziPTYTEYSE";
                isLiked = isLiked5;
                break;
            case 6:
                isLiked6 = !isLiked6;
                editor.putBoolean("isLiked30", isLiked6);
                like6.setImageResource(isLiked6 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/FMA9cOlgRwQ?si=v687z-J8cx9f4-ZR";
                isLiked = isLiked6;
                break;
            case 7:
                isLiked7 = !isLiked7;
                editor.putBoolean("isLiked31", isLiked7);
                like7.setImageResource(isLiked7 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/1sfJoht8GlM?si=0C_EfDTq2i4McVMC";
                isLiked = isLiked7;
                break;
            case 8:
                isLiked8 = !isLiked8;
                editor.putBoolean("isLiked32", isLiked8);
                like8.setImageResource(isLiked8 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/rnanhIYvEVk?si=3s-JX9eWbofoxedP";
                isLiked = isLiked8;
                break;

            default:
                return;
        }
        editor.apply();
        showFeedback(isLiked);

        if (isLiked) {
            addLikedImage(imageUri);
        } else {
            removeLikedImage(imageUri);
        }
    }
    private void addLikedImage(String uri) {
        Set<String> likedImages = new HashSet<>(sharedPreferences.getStringSet("likedImages", new HashSet<>()));
        likedImages.add(uri);
        sharedPreferences.edit().putStringSet("likedImages", likedImages).apply();
    }

    private void removeLikedImage(String uri) {
        Set<String> likedImages = new HashSet<>(sharedPreferences.getStringSet("likedImages", new HashSet<>()));
        likedImages.remove(uri);
        sharedPreferences.edit().putStringSet("likedImages", likedImages).apply();
    }

    private void showFeedback(boolean isLiked) {
        String message = isLiked ? "Image Liked!" : "Image Unliked!";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}