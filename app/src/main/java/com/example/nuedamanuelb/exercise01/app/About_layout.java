package com.example.nuedamanuelb.exercise01.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.R.id;
import android.widget.TextView;
import android.widget.Toast;

public class About_layout extends Activity {

    Button  BUT,OBUT;
    TextView TXV;


    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        Toast.makeText(getApplicationContext(),"Close by pressing on of the Buttons!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);

        TXV=(TextView)findViewById(R.id.CLR);
        BUT=(Button)findViewById(R.id.cancel);
        OBUT=(Button)findViewById(R.id.ok);

        String colorDataText = getIntent().getExtras().getString("color");
        TXV.setText("The selected calor value is (R,G,B)=" +colorDataText+".");

        /*
        TXV.setBackgroundColor(R.id.color_Preview_Text_View);
        TXV.setTextColor(R.id.color_Preview_Text_View-255);*/


        OBUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(About_layout.this,MainActivity.class);
                finish();
                Toast.makeText(getApplicationContext(),"About Activity was closed using Ok",Toast.LENGTH_LONG).show();
            }
        });

        BUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(About_layout.this, MainActivity.class);
                finish();
                Toast.makeText(getApplicationContext(),"About Activity was closed using cancel",Toast.LENGTH_LONG).show();
            }

        });



    }

}



