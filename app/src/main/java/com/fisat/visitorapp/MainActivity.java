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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
        b1=(Button)findViewById(R.id.btn_submit);
        b2=(Button)findViewById(R.id.btn_menu);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=edt1.getText().toString();
                s2=edt2.getText().toString();
                s3=edt3.getText().toString();
                s4=edt4.getText().toString();
                if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()){
                    Toast.makeText(getApplicationContext(),"FILL ALL OF THEM",Toast.LENGTH_LONG).show();
                }
                else{
                    callApi();
                }


                //Toast.makeText(getApplicationContext(),s1+""+s2+""+s3+""+s4+""+s5+"",Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob=new Intent(getApplicationContext(), Menu.class);
                startActivity(ob);
            }
        });


        


    }

    private void callApi() {
        String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
        JSONObject data=new JSONObject();
        try {
            data.put("firstname",s1);
            data.put("lastname",s2);
            data.put("purpose",s3);
            data.put("whomToMeet",s4);
        }
        catch (JSONException e){
            throw new RuntimeException(e);
        }

        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.POST,
                apiUrl,
                data,
                response -> Toast.makeText(getApplicationContext(),"SUCCESSFULLY ADDED",Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show()
        );

        RequestQueue Queue= Volley.newRequestQueue(this);
        Queue.add(req);

    }
}