package com.example.epicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private ImageButton ImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.nav_home){
                    Intent intent = new Intent(Home.this,MainActivity3.class);
                    startActivity(intent);
                    return true;
                }
                else if(id == R.id.nav_help){
                    Toast.makeText(Home.this, "help", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(id == R.id.settings) {
                    Toast.makeText(Home.this, "settings", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Home.this,Settingspage.class));
                    return true;
                }
                else if(id == R.id.nav_healthReport){
                    Intent intent = new Intent(Home.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(id == R.id.nav_logout){
                    Intent intent = new Intent(Home.this,dashboard.class);
                    startActivity(intent);
                    return true;
                }
                return true;
            }
        });
        ImageButton = findViewById(R.id.imageButton);
        ImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9111111111"));
                startActivity(intent);

        }
    });
}
}