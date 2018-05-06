package com.example.nuedamanuelb.exercise01.app;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.content.Intent;



public class MainActivity extends AppCompatActivity implements SensorEventListener{

    View view;
    private SeekBar seekBar1;
    private EditText EditText1;
    private SeekBar seekBar2;
    private EditText EditText2;
    private SeekBar seekBar3;
    private EditText EditText3;
    private Sensor sens;
    private SensorManager sensM;


    RelativeLayout BGC;
    TextView CLR;
    Button BUTN;
    RadioGroup RGP;
    RadioButton RBT;
    CheckBox CB;
    TextView TV;
    FloatingActionButton fab1;
    RadioButton rbgcol;
    RadioButton rbgcol1;
    RadioButton rbgcol2;
    RadioButton rbgcol3;


   @Override

    public void onSensorChanged(SensorEvent sensorEvent) {
        seekBar1.setProgress(seekBar1.getProgress());
        seekBar2.setProgress(seekBar2.getProgress());
        seekBar3.setProgress(seekBar3.getProgress());

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //eigene sensor manager
        sensM=(SensorManager)getSystemService(SENSOR_SERVICE);

        //acelemator
        sens=sensM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensM.registerListener(this, sens, SensorManager.SENSOR_DELAY_NORMAL);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information: Wipe to the Right to dismiss ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        seekBar1 = (SeekBar) findViewById(R.id.red_Seek_Bar);
        EditText1 = (EditText) findViewById(R.id.Red_Edit_Text);
        EditText1.setText("" + seekBar1.getProgress());
        BUTN = (Button) findViewById(R.id.btnn);
        RGP = (RadioGroup) findViewById(R.id.radioGruppe);
        CB = (CheckBox) findViewById(R.id.ums);
        rbgcol = (RadioButton) findViewById(R.id.bgcol);
        rbgcol1 = (RadioButton) findViewById(R.id.text_Color_RadioButton);
        rbgcol2 = (RadioButton) findViewById(R.id.button_Color);
        rbgcol3 = (RadioButton) findViewById(R.id.fabcol);
        TV=(TextView) findViewById(R.id.color_Preview_Text_View);



        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                EditText1.setText("" + progress);

                BGC = (RelativeLayout) findViewById(R.id.main_layout);
                CLR = findViewById(R.id.color_Preview_Text_View);
                CLR.setBackgroundColor(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), seekBar3.getProgress()));
                CLR.setTextColor(Color.rgb(seekBar1.getProgress()-50, seekBar2.getProgress()-255, seekBar3.getProgress()-255));

            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });


        seekBar2 = (SeekBar) findViewById(R.id.green_Seek_Bar);
        EditText2 = (EditText) findViewById(R.id.green_Edit_Text);
        EditText2.setText("" + seekBar2.getProgress());

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                EditText2.setText("" + progress);
                BGC = findViewById(R.id.main_layout);
                CLR = findViewById(R.id.color_Preview_Text_View);
                CLR.setBackgroundColor(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), seekBar3.getProgress()));
                CLR.setTextColor(Color.rgb(seekBar1.getProgress()-255, seekBar2.getProgress()-55, seekBar3.getProgress()-255));

                /*if(CLR==CLR) {
                    CLR.setTextColor(0x0000FF);
                }*/
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3 = (SeekBar) findViewById(R.id.Blue_Seek_Bar);
        EditText3 = (EditText) findViewById(R.id.Blue_Edit_Text);
        EditText3.setText("" + seekBar3.getProgress());

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                EditText3.setText("" + progress);

                BGC = findViewById(R.id.main_layout);
                CLR = findViewById(R.id.color_Preview_Text_View);
                CLR.setBackgroundColor(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), seekBar3.getProgress()));
                CLR.setTextColor(Color.rgb(seekBar2.getProgress()-255, seekBar3.getProgress()-55, seekBar1.getProgress()-255));


            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        EditText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String in = EditText1.getText().toString();
                int conv = Integer.parseInt(in);
                seekBar1.setProgress(conv);
                int limit = 0;
                if (conv > 255) {
                    EditText1.setText("" + limit);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        EditText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String in = EditText2.getText().toString();
                int conv = Integer.parseInt(in);
                seekBar2.setProgress(conv);
                int limit = 0;
                if (conv > 255) {
                    EditText2.setText("" + limit);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        EditText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String in = EditText3.getText().toString();
                int conv = Integer.parseInt(in);
                seekBar3.setProgress(conv);
                int limit = 0;
                if (conv > 255) {
                    EditText3.setText("" + limit);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
    public void check (View v) {
        BUTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int getid=RGP.getCheckedRadioButtonId();
                RBT = findViewById(getid);
                FloatingActionButton fabb = (FloatingActionButton) findViewById(R.id.fab);

                switch(RBT.getId()){
                    case R.id.bgcol:
                        BGC.setBackgroundColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        break;
                    case R.id.text_Color_RadioButton:
                        CB.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        //RBT.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        rbgcol.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        rbgcol1.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        rbgcol2.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        rbgcol3.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        //BUTN.setTextColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        //RGP.setBackgroundColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));
                        break;
                    case R.id.button_Color:
                        BUTN.setBackgroundColor(Color.rgb(seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress()));

                        break;
                    case R.id.fabcol:
                        fabb.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), seekBar3.getProgress())));
                        break;

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

                {
                    Intent intent=new Intent(MainActivity.this, About_layout.class);
                   // intent.putExtra("color",CLR.getTextColors().toString());
                    startActivity(intent);
                }


        }

        return super.onOptionsItemSelected(item);


    }




}
