package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] branch = {"CSE-A","CSE-B","CSE-C","CSE-D"};
    String[] year = {"2019","2020","2021","2022"};
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView a1 = findViewById(R.id.dd1);
        AutoCompleteTextView a2 = findViewById(R.id.dd2);
        a1.setOnItemSelectedListener(this);
        ArrayAdapter ad1 = new ArrayAdapter(this, R.layout.dropdown,branch);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a1.setAdapter(ad1);
        a2.setOnItemSelectedListener(this);
        ArrayAdapter ad2 = new ArrayAdapter(this, R.layout.dropdown,year);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a2.setAdapter(ad2);
        ad1.getItem(2);
        b = findViewById(R.id.p1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),branch[i],Toast.LENGTH_LONG)
                .show();
        Toast.makeText(getApplicationContext(),year[i],Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}