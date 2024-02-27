package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    // Predefined dictionary of username-password pairs
    private HashMap<String, String> validCredentials = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populate the credentials dictionary
        validCredentials.put("Husein", "1234");
        validCredentials.put("Hasan", "1234");
        validCredentials.put("Wael", "1234");
        validCredentials.put("Ali", "1234");

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateCredentials(username, password)) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Login successful, start HomePage activity
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                    finish(); // Optional: Finish MainActivity so the user cannot go back to it with the back button
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Details.class);
                startActivity(intent);
            }
        });
    }


    private boolean validateCredentials(String username, String password) {
        return validCredentials.containsKey(username) && validCredentials.get(username).equals(password);
    }
}

