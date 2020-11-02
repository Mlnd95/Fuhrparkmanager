package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    DBHelper DB;
    EditText username,password;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB= new DBHelper(this);
        username = (EditText) findViewById(R.id.usernameLogin);
        password = (EditText) findViewById(R.id.passwordLogin);
        button = (Button) findViewById(R.id.LogInButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //openMenuActivity();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this,"Bitte geben Sie alle erforderlichen Daten ein",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkUsernamePassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(MainActivity.this,"Login erfolgreich",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Eingabedaten ungültig",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        button= (Button) findViewById(R.id.buttonToRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }


  /*  public void openMenuActivity(){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }*/
}