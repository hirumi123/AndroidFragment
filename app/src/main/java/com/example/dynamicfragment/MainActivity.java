package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Boolean isDisplay = false;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_lihat);
        Fragment2 fragment2 = Fragment2.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.frag1, fragment2).addToBackStack(null).commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isDisplay){
                    displayFragment();
                }
                else {
                    closeFragment();
                }
            }
        });

    }
    public void displayFragment(){
        Fragment1 fragment1 = Fragment1.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frag1, fragment1).addToBackStack(null).commit();
        button.setText("Tutup Kelebihan");
        isDisplay = true;

    }
    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment1 fragment1 = (Fragment1) fragmentManager.findFragmentById(R.id.frag1);
        Fragment2 fragment2 = Fragment2.newInstance();

        if (fragment1 != null) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frag1, fragment2).addToBackStack(null).commit();
        }
        button.setText("Lihat Kelebihan");
        isDisplay = false;
    }
}