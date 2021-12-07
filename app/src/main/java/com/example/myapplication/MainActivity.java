package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText email, password, repassword;
    Button btnreg;
    Button btnlv;
    Button btnlv1;
    Button btnlv2;
    TextView textView;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        email = (EditText) findViewById(R.id.edemail);
        password = (EditText) findViewById(R.id.edpassword);
        repassword = (EditText) findViewById(R.id.repassword);
        btnreg = (Button) findViewById(R.id.btn);
        btnlv = (Button) findViewById(R.id.btnlv);
        btnlv1 = (Button) findViewById(R.id.btnlv1);
        btnlv2 = (Button) findViewById(R.id.btnlv2);
        textView = (TextView) findViewById(R.id.tv);
        DB = new DBHelper(this);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(getBaseContext(), "Please Enter all the Fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) ;
                        Boolean insert = DB.insertData(user, pass);
                        if (insert == true) {

                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Register.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Registration Fail", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "User Already Exist Please Sign in", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        btnlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);


            }


        });

        btnlv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, listview.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "Successfully Register", Toast.LENGTH_SHORT).show();


            }


        });
        btnlv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, aboutus.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "Contact us here", Toast.LENGTH_SHORT).show();


            }


        });

    }
}
