package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class HostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host); // Ensure this layout file has a container for the fragment.

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("TITLE");
            String description = intent.getStringExtra("DESCRIPTION");
            int imageResource = intent.getIntExtra("IMAGE_RESOURCE", 0);

            Detailed_destination detailFragment = Detailed_destination.newInstance(title, description, imageResource);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .commit();
        }
    }
}
