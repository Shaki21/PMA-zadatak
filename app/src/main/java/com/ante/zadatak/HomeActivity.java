package com.ante.zadatak;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ante.zadatak.models.Dogadaj;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    ArrayList<Dogadaj> dogadajModel = new ArrayList<>();
    int[] slikaSkijasa = {R.drawable.baseline_snowboarding_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    private void setDogadajModel(){

    }


}
