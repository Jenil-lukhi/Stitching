package com.example.stitchingapp.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stitchingapp.Fragment.Home_Fragment;
import com.example.stitchingapp.MainActivity;
import com.example.stitchingapp.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignIn_Activity extends AppCompatActivity {

    Button submitButton;
    private EditText numberEditText;
    private EditText passwordEditText;
    private TextView signUpTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        numberEditText = findViewById(R.id.editTextPhone);
        passwordEditText = findViewById(R.id.editTextPassword);
        signUpTextView = findViewById(R.id.don_t_have_);
        submitButton = findViewById(R.id.sign_in);

        signUpTextView.setOnClickListener(v -> handleSignUp());
        submitButton.setOnClickListener(v -> handleSubmit());

    }
    private void handleSubmit() {
        String mobileNumber = numberEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(mobileNumber)) {
            Toast.makeText(this, "Please enter your number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mobileNumber.length() != 10) {
            Toast.makeText(this, "Please enter a correct number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobileNumber,
                60,
                TimeUnit.SECONDS,
                SignIn_Activity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(SignIn_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        Intent intent = new Intent(getApplicationContext(), VerifyOtp_Activity.class);
                        intent.putExtra("mobile", mobileNumber);
                        intent.putExtra("backendotp", backendotp);
                        startActivity(intent);
                    }
                }
        );
    }
    private void handleSignUp() {
        Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SignIn_Activity.this, MainActivity.class));
    }
}