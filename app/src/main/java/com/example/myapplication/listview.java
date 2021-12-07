package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listview extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listview;
    String [] items ={"Suprem","High octane","Disel","Car Wash","Type Shop","Mobile oil","Tuck Shop","Rider","Employee","Saturday","Saturday","Saturday","Saturday","Saturday","Saturday","Saturday","Saturday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listview=(ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);



    }
    @Override

    public void onItemClick(AdapterView<?> adapterView, View view, int i,  long l){
        TextView textView=(TextView)view;
        Toast.makeText(this,textView.getText() .toString(),Toast.LENGTH_LONG).show();

    }

}