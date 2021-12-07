package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username, password;
    Button btnsi;
    Button btnsi1;

    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username =(EditText)  findViewById(R.id.username);
        password =(EditText)  findViewById(R.id.textpassword);
        btnsi = (Button) findViewById(R.id.btnsi);
        btnsi1 = (Button) findViewById(R.id.btnsi1);
        DB =new DBHelper(this);

        btnsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusername(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(Register.this, "Sign in Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Register.this, "Invelid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Register.this, map.class);
                startActivity(i);


            }


        });
    }
}

