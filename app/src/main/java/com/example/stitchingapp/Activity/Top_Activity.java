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

public class Top_Activity extends AppCompatActivity {

    ImageView im1, im2, im3, im4, im5, im6, im7, im8;
    ImageView like1, like2, like3, like4, like5,like6,like7,like8;
    private boolean isLiked1, isLiked2, isLiked3, isLiked4, isLiked5, isLiked6, isLiked7, isLiked8;
    private SharedPreferences sharedPreferences;
    View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);
        im5 = findViewById(R.id.im5);
        im6 = findViewById(R.id.im6);
        im7 = findViewById(R.id.im7);
        im8 = findViewById(R.id.im8);

        sharedPreferences = getSharedPreferences("liked_Images6", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked41", false);
        isLiked2 = sharedPreferences.getBoolean("isLiked42", false);
        isLiked3 = sharedPreferences.getBoolean("isLiked43", false);
        isLiked4 = sharedPreferences.getBoolean("isLiked44", false);
        isLiked5 = sharedPreferences.getBoolean("isLiked45", false);
        isLiked6 = sharedPreferences.getBoolean("isLiked46", false);
        isLiked7 = sharedPreferences.getBoolean("isLiked47", false);
        isLiked8 = sharedPreferences.getBoolean("isLiked48", false);

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
                openUrl("https://youtu.be/p2eMAwF1h4o?si=U9lxHg10Bcp872bd");
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/YRBM5I7yk08?si=JBmY0AIyaz2i-PKF");
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/vad4XSRY-Tc?si=a68I8GhEHqBNYwFs");
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/re1hiSHGZEA?si=tpJic744crW8g8YJ");
            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/sbbmKPUiJkI?si=IzqJ95LMIG5WdZfU");
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/sWPpTvElcCc?si=wHWC79pcDCbQMbO9");
            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/PCaIw2hDPzo?si=yGPYlAdKqt6HTZGP");
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://youtu.be/76BZnkJwZxE?si=dVAcWkiyqzxhUkyX");
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
                editor.putBoolean("isLiked41", isLiked1);
                like1.setImageResource(isLiked1 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/p2eMAwF1h4o?si=U9lxHg10Bcp872bd";
                isLiked = isLiked1;
                break;
            case 2:
                isLiked2 = !isLiked2;
                editor.putBoolean("isLiked42", isLiked2);
                like2.setImageResource(isLiked2 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/YRBM5I7yk08?si=JBmY0AIyaz2i-PKF";
                isLiked = isLiked2;
                break;
            case 3:
                isLiked3 = !isLiked3;
                editor.putBoolean("isLiked43", isLiked3);
                like3.setImageResource(isLiked3 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/vad4XSRY-Tc?si=a68I8GhEHqBNYwFs";
                isLiked = isLiked3;
                break;
            case 4:
                isLiked4 = !isLiked4;
                editor.putBoolean("isLiked44", isLiked4);
                like4.setImageResource(isLiked4 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/re1hiSHGZEA?si=tpJic744crW8g8YJ";
                isLiked = isLiked4;
                break;
            case 5:
                isLiked5 = !isLiked5;
                editor.putBoolean("isLiked45", isLiked5);
                like5.setImageResource(isLiked5 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/sbbmKPUiJkI?si=IzqJ95LMIG5WdZfU";
                isLiked = isLiked5;
                break;
            case 6:
                isLiked6 = !isLiked6;
                editor.putBoolean("isLiked46", isLiked6);
                like6.setImageResource(isLiked6 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/sWPpTvElcCc?si=wHWC79pcDCbQMbO9";
                isLiked = isLiked6;
                break;
            case 7:
                isLiked7 = !isLiked7;
                editor.putBoolean("isLiked47", isLiked7);
                like7.setImageResource(isLiked7 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/PCaIw2hDPzo?si=yGPYlAdKqt6HTZGP";
                isLiked = isLiked7;
                break;
            case 8:
                isLiked8 = !isLiked8;
                editor.putBoolean("isLiked48", isLiked8);
                like8.setImageResource(isLiked8 ? R.drawable.like2 : R.drawable.like1);
                imageUri = "https://youtu.be/76BZnkJwZxE?si=dVAcWkiyqzxhUkyX";
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