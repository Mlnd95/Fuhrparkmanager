package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        button = (Button) findViewById(R.id.carOverviewButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityCar();
            }
        });
        button = (Button) findViewById(R.id.addCarButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAddCar();
            }
        });
        button = (Button) findViewById(R.id.calenderButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCalender();
            }
        });
    }

    public void openActivityCalender(){
        Intent intent = new Intent(this, CalenderActivity.class);
        startActivity(intent);
    }
    public void openActivityAddCar(){
        Intent intent = new Intent(this, DisplayCar.class);
        startActivity(intent);
    }

    public void openActivityCar(){
        Intent intent = new Intent(this, CarsActivity.class);
        startActivity(intent);
    }


}