package com.example.expensemanagerpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE =0.7f;
    ImageView drawerIcon;
    LinearLayout contentView;


    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);


        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        drawerIcon = findViewById(R.id.drawer_icon);
        contentView= findViewById(R.id.content);


        navigationDrawer();

    }

    //Navigation Drawer
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_dashboard);

        drawerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        animateNavigatinDrawer();
    }

    private void animateNavigatinDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.dashboard));
       drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
           @Override
           public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
               final float diffScaledOffset = slideOffset * (1 - END_SCALE);
               final float offsetScale = 1 - diffScaledOffset;
               contentView.setScaleX(offsetScale);
               contentView.setScaleY(offsetScale);

               final float xOffset = drawerView.getWidth() * slideOffset;
               final float xOffsetDiff = contentView.getWidth()*diffScaledOffset/2;
               final float xTranslation = xOffset -  xOffsetDiff;
               contentView.setTranslationX(xTranslation);
           }

           @Override
           public void onDrawerOpened(@NonNull View drawerView) {

           }

           @Override
           public void onDrawerClosed(@NonNull View drawerView) {

           }

           @Override
           public void onDrawerStateChanged(int newState) {

           }
       });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.nav_dashboard:
                Intent i = new Intent(Dashboard.this,Dashboard.class);
                startActivity(i);
                break;

            case R.id.nav_income:
                Intent m = new Intent(Dashboard.this, incomeActivity.class);
                startActivity(m);
                break;
            case R.id.nav_cost:
                Intent n = new Intent(Dashboard.this, costActivity.class);
                startActivity(n);
                break;
            case R.id.nav_profile:
                Intent o = new Intent(Dashboard.this, UserProfile.class);
                startActivity(o);
                break;
            case R.id.nav_logout:
                Intent p = new Intent(Dashboard.this, Login.class);
                startActivity(p);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }


}