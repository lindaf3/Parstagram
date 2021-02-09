package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateActivity extends AppCompatActivity {
    public static final String TAG = "CreateActivity";
    private EditText etNewUsername;
    private EditText etNewPassword;
    private EditText etEmail;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPassword = findViewById(R.id.etNewPassword);
        etEmail = findViewById(R.id.etEmail);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the ParseUser
                ParseUser user = new ParseUser();
                // Set core properties
                String username = etNewUsername.getText().toString();
                String password = etNewPassword.getText().toString();
                String email = etEmail.getText().toString();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                Log.i(TAG, username+" "+password+" "+email);

                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "Issue with account creation", e);
                            Toast.makeText(CreateActivity.this, "Issue with account creation", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            goMainActivity();
                            Toast.makeText(CreateActivity.this, "Successful Creation!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
