package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Locale;

public class Recommendations extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TravelAdapter.OnDestinationClickListener {

    private DrawerLayout drawerLayout;
    private RecyclerView travelsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set up the RecyclerView for travel destinations
        travelsRecyclerView = findViewById(R.id.travels_recycler_view);
        travelsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of travel destinations
        ArrayList<TravelDestination> travelDestinations = new ArrayList<>();
        // Example destinations - replace these with actual data
        travelDestinations.add(new TravelDestination(R.drawable.mrocco, getResources().getString(R.string.destination_marrakech_title), 600.00, getResources().getString(R.string.destination_marrakech_description)));
        travelDestinations.add(new TravelDestination(R.drawable.grece, getResources().getString(R.string.destination_santorini_title), 900.00, getResources().getString(R.string.destination_santorini_description)));
        travelDestinations.add(new TravelDestination(R.drawable.kenia, getResources().getString(R.string.destination_kenya_title), 350.00, getResources().getString(R.string.destination_kenya_description)));
        travelDestinations.add(new TravelDestination(R.drawable.iceeland, getResources().getString(R.string.destination_iceland_title), 650.00, getResources().getString(R.string.destination_iceland_description)));

        // Add more destinations as needed

        // Set the adapter for the RecyclerView and pass 'this' to handle click events
        travelsRecyclerView.setAdapter(new TravelAdapter(travelDestinations, this, this));
    }

    @Override
    public void onDestinationClicked(TravelDestination destination) {
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("TITLE");
            String description = intent.getStringExtra("DESCRIPTION");
            int imageResource = intent.getIntExtra("IMAGE_RESOURCE", 0);
            // Use these values to update your UI in Detailed_destination
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here
        int id = item.getItemId();

        if (id == R.id.nav_recommendations) {
            // Handle click for Favorites
        } else if (id == R.id.nav_spanish) {
            // Handle click for Spanish language option
            setLocale("es"); // Call setLocale with "es" for Spanish
            recreate(); // Refresh the current activity to apply changes
        } else if (id == R.id.nav_english) {
            // Change language to English
            setLocale("en");
            recreate(); // Refresh the current activity to apply changes
        }else if (id == R.id.nav_home) {
            Intent intent = new Intent(Recommendations.this, HomePage.class);
            startActivity(intent);
            finish(); // Ensure you call finish() to remove the activity from the stack
        }
        else if (id == R.id.nav_sign_out) {
            Intent intent = new Intent(Recommendations.this, MainActivity.class);
            startActivity(intent);
            finish(); // Ensure you call finish() to remove the activity from the stack
        }

        drawerLayout.closeDrawers();
        return true;
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        // Save the current language preference
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", languageCode);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Load language saved in SharedPreferences
        SharedPreferences prefs = getSharedPreferences("Settings", HomePage.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }


}
