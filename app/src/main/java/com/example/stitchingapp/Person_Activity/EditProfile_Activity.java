package com.example.stitchingapp.Person_Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.stitchingapp.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EditProfile_Activity extends AppCompatActivity {

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 1;
    private static final int REQUEST_CODE_SELECT_IMAGE = 2;
    private static final int REQUEST_CODE_CAMERA_PERMISSION = 3;
    private static final int REQUEST_CODE_CAPTURE_IMAGE = 4;

    private ImageView profileImageView;
    private EditText editTextUsername, editTextEmail, editTextPhone, editTextPassword;
    private SharedPreferences sharedPreferences;
    View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());

        profileImageView = findViewById(R.id.ellipse_20);

        Button saveButton = findViewById(R.id.button2);
        TextView captureImageButton = findViewById(R.id.change_picture);

        editTextUsername = findViewById(R.id.textView);
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPhone = findViewById(R.id.editTextNumber);
        editTextPassword = findViewById(R.id.editTextPassword);

        sharedPreferences = getSharedPreferences("UserProfile", Context.MODE_PRIVATE);

        loadSavedData();

        captureImageButton.setOnClickListener(view -> showImagePickerDialog());

        saveButton.setOnClickListener(view -> saveData());
    }

    private void showImagePickerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Image Source")
                .setItems(new CharSequence[]{"Camera", "Gallery"}, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            if (ContextCompat.checkSelfPermission(
                                    EditProfile_Activity.this,
                                    Manifest.permission.CAMERA
                            ) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(
                                        EditProfile_Activity.this,
                                        new String[]{Manifest.permission.CAMERA},
                                        REQUEST_CODE_CAMERA_PERMISSION
                                );
                            } else {
                                captureImage();
                            }
                            break;
                        case 1:
                            if (ContextCompat.checkSelfPermission(
                                    EditProfile_Activity.this,
                                    Manifest.permission.READ_EXTERNAL_STORAGE
                            ) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(
                                        EditProfile_Activity.this,
                                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                        REQUEST_CODE_STORAGE_PERMISSION
                                );
                            } else {
                                selectImage();
                            }
                            break;
                    }
                })
                .show();
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE);
        }
    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE_CAPTURE_IMAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectImage();
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_CODE_CAMERA_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                captureImage();
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        Bitmap resizedBitmap = getResizedBitmap(bitmap, 500, 500); // Resize to 500x500 pixels
                        profileImageView.setImageBitmap(resizedBitmap);
                        saveProfileImage(resizedBitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("EditProfile_Activity", "Error setting image: ", e);
                    }
                } else {
                    Log.e("EditProfile_Activity", "Selected image URI is null");
                }
            } else {
                Log.e("EditProfile_Activity", "Intent data is null");
            }
        } else if (requestCode == REQUEST_CODE_CAPTURE_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap bitmap = (Bitmap) extras.get("data");
                if (bitmap != null) {
                    Bitmap resizedBitmap = getResizedBitmap(bitmap, 500, 500);
                    profileImageView.setImageBitmap(resizedBitmap);
                    saveProfileImage(resizedBitmap);
                } else {
                    Log.e("EditProfile_Activity", "Captured image is null");
                }
            } else {
                Log.e("EditProfile_Activity", "Extras are null");
            }
        }
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int width, int height) {
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    private void saveProfileImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profile_image", encodedImage);
        editor.apply();
    }

    private void saveData() {
        String username = editTextUsername.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show();
    }

    private void loadSavedData() {
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");
        String password = sharedPreferences.getString("password", "");

        editTextUsername.setText(username);
        editTextEmail.setText(email);
        editTextPhone.setText(phone);
        editTextPassword.setText(password);

        String encodedImage = sharedPreferences.getString("profile_image", "");
        if (!encodedImage.isEmpty()) {
            byte[] decodedByte = Base64.decode(encodedImage, 0);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
            profileImageView.setImageBitmap(bitmap);
        }
    }
}
