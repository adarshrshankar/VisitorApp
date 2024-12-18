package com.fisat.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5;
    Button b1,b2;

    String s1,s2,s3,s4,s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        edt1=(EditText)findViewById(R.id.et_firstname);
        edt2=(EditText)findViewById(R.id.et_lastname);
        edt3=(EditText)findViewById(R.id.et_purpose);
        edt4=(EditText)findViewById(R.id.et_whom_to_meet);
        edt5=(EditText)findViewById(R.id.et_date);
        b1=(Button)findViewById(R.id.btn_submit);
        b2=(Button)findViewById(R.id.btn_menu);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=edt1.getText().toString();
                s2=edt2.getText().toString();
                s3=edt3.getText().toString();
                s4=edt4.getText().toString();
                s5=edt5.getText().toString();
                Toast.makeText(getApplicationContext(),s1+""+s2+""+s3+""+s4+""+s5+"",Toast.LENGTH_LONG).show();
            }
        });


    }
}