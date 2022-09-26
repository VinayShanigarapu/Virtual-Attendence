package com.example.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {
    public int[] ch = {R.id.c5h3,R.id.c5h8,R.id.c5g5,R.id.c5h2};
    public String[] roll = {"5H3","5H8","5G5","5H2"};
    private CheckBox[] box ;
    private CheckBox c;
    private Button b;
    private TextView tv;
    private Set<String> present = new HashSet<String>();
    private Set<String> absent = new HashSet<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        box = new CheckBox[ch.length];
        for (int i = 0; i < ch.length; i++) {
            box[i] = findViewById(ch[i]);
        }
        c = findViewById(R.id.c);
        b = findViewById(R.id.b);
        tv = findViewById(R.id.res);
        for(int i=0;i<roll.length;i++)
            absent.add(roll[i]);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.isChecked()) {
                    for (int i = 0; i < box.length; i++) {
                        box[i].setChecked(true);
                        if(present.size()<roll.length)
                            present.add(roll[i]);
                        absent.remove(roll[i]);
                    }
                }
                else{
                    for (int i = 0; i < box.length; i++) {
                        box[i].setChecked(false);
                        if(absent.size()<roll.length)
                            absent.add(roll[i]);
                        present.remove(roll[i]);
                    }
                }
            }
        });
        for(int i = 0; i<ch.length; i++) {
            box[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected(view);
                }
            });
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result(view);
            }
        });
    }
    public void selected(View v){
        boolean checked = ((CheckBox) v).isChecked();
        for(int i=0;i<ch.length;i++){
            if(v.getId()==ch[i]){
                if(checked){present.add(roll[i]); absent.remove(roll[i]);}
                else{ absent.add(roll[i]); present.remove(roll[i]);}break;
            }
        }
    }
    public void Result(View v){
        String s = "";
        if(present.size()>=absent.size()) {
            s+="Absentees are \n";
            if(absent.size()==0)
                tv.setText(s+"0");
            else{
                for (String i : absent)
                    s += i + "\n";
                tv.setText(s);
            }
        }
        else {
            s+="Presentees are \n";
            if(present.size()==0)
                tv.setText(s+"0");
            else{
                for (String i : present)
                    s += i + "\n";
                tv.setText(s);
            }
        }
        tv.setEnabled(true);
    }
}