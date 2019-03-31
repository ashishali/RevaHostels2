package com.example.test.reva_hostels;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        drawer = findViewById( R.id.drawer_layout );
        NavigationView navigationView = findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new ArevaFragment() ).commit();
            navigationView.setCheckedItem( R.id.areva );
        }



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.areva:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new ArevaFragment() ).commit();
                break;

            case R.id.hreva:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new HrevaFragment() ).commit();
                break;

            case R.id.rooms:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new RoomsFragment() ).commit();
                break;

            case R.id.facilities:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new FacilitiesFragment() ).commit();
                break;

            case R.id.food:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new FoodFragment() ).commit();
                break;

            case R.id.security:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new SecurityFragment() ).commit();
                break;

            case R.id.gallery:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new GalleryFragment() ).commit();
                break;

            case R.id.location:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new LocationFragment() ).commit();
                break;

            case R.id.call:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new CallFragment() ).commit();
                break;

            case R.id.dev:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,new DeveloperFragment() ).commit();
                break;
        }

        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}
