package com.example.tapesh.momarkreward;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by TAPESH on 5/30/2016.
 */
public class Activity1 extends Activity implements View.OnClickListener{
    String sector,city;
    TextView textView3address;
    Button submitButton;
    EditText locationedittext;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity1);

        textView3address=(TextView)findViewById(R.id.textView3);
        submitButton=(Button)findViewById(R.id.button);
        locationedittext=(EditText)findViewById(R.id.editText);



        alertDialog=new AlertDialog.Builder(Activity1.this).create();
        alertDialog.setTitle("Alert Dialog");
        alertDialog.setMessage("Enter location");

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
               // Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });



        Intent intent=getIntent();
        Bundle extras=intent.getExtras();

        city=extras.getString("locality");
        sector=extras.getString("sector");

        textView3address.setText("eg :"+sector+" "+city);
        Log.i("city and sector", city + "" + sector);



        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
      String locationname=locationedittext.getText().toString();

        if(!locationname.equals("")) {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);

        }else
        {
            alertDialog.show();
        }

        }


}
