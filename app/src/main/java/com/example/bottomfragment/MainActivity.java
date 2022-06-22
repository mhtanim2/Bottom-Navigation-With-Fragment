package com.example.bottomfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.example.bottomfragment.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new FragmentTwo()).commit();

       binding.botNavFrag.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @SuppressLint("NonConstantResourceId")
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment frag=null;
               switch (item.getItemId()){
                   case R.id.inc: frag=new FragmentOne();
                   break;
                   case R.id.dash: frag=new FragmentTwo();
                   break;
                   case R.id.exp: frag=new FragmentThree();
               }
               getSupportFragmentManager().beginTransaction().replace(R.id.frame,frag).commit();
               return true;
           }
       });
    }
}