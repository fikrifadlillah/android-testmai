package com.mai.test_mai;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.mai.test_mai.Fragment.ContactFragment;
import com.mai.test_mai.Fragment.HomeFragment;
import com.mai.test_mai.Fragment.NewsFragment;
import com.mai.test_mai.Fragment.ReportFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // kita set default nya Home Fragment
        loadFragment(new HomeFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.report_menu:
                fragment = new ReportFragment();
                break;
            case R.id.contact_menu:
                fragment = new ContactFragment();
                break;
            case R.id.news_menu:
                fragment = new NewsFragment();
                break;
//            case R.id.account_menu:
//                fragment = new AccountFragment();
//                break;
        }
        return loadFragment(fragment);
    }


}
