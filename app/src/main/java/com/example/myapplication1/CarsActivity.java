package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CarsActivity extends AppCompatActivity {
    GridView gridView;

    String[] numberWord = {"1","2","3","4","5","6"};

    int[] numberImage = {R.drawable.bmweinser,R.drawable.bmwdreier,R.drawable.bmwfuenfer,R.drawable.vwgolf,R.drawable.vwpassat,R.drawable.vwup};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        gridView= findViewById(R.id.grid_View);

        CarAdapter adapter = new CarAdapter(CarsActivity.this,numberWord,numberImage);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You Clicked"+numberWord[+position],Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DisplayCar.class);
                startActivity(intent);
            }
        });
    }
}