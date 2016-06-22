package com.example.tapesh.momarkreward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TAPESH on 5/30/2016.
 */
public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;



    Button button2scrollslider,button4search,button5checkin,button6Events,offerbutton7,rewardszonebutton8,registrationbutton10,signinbutton9;
    int random1=8;
    Timer t;
    ImageView imageViewchange;




    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity2);


        imageViewchange=(ImageView)findViewById(R.id.imageView);


        imageViewchange.setImageResource(R.drawable.micon);
        button4search=(Button)findViewById(R.id.button4);
        button5checkin=(Button)findViewById(R.id.button5);
        registrationbutton10=(Button)findViewById(R.id.button10);

        button2scrollslider=(Button)findViewById(R.id.button2);
        button6Events=(Button)findViewById(R.id.button6);
        offerbutton7=(Button)findViewById(R.id.button7);
        rewardszonebutton8=(Button)findViewById(R.id.button8);
        signinbutton9=(Button)findViewById(R.id.button9);


        menu = new String[]{"Home","Search","Offers","Sign In","Register","Change Your Location","Reset Location","About App","Feedback","Report A Problem","Privacy Policy","FAQ's"};
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);

        dList.setAdapter(adapter);



        t=new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() {


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random randomGenerator = new Random();
                        int random = randomGenerator.nextInt(5);

                        Log.i("function1", random + "");

                        if (random != random1) {
                            function1(random);
                        }
                        random1 = random;
                    }
                });


            }
        }, 1000, 3000);


        button2scrollslider.setOnClickListener(this);
        button4search.setOnClickListener(this);
        button5checkin.setOnClickListener(this);
        button6Events.setOnClickListener(this);
        offerbutton7.setOnClickListener(this);
        rewardszonebutton8.setOnClickListener(this);
        registrationbutton10.setOnClickListener(this);
        signinbutton9.setOnClickListener(this);

    }




    void function1( int random)
    {

        switch(random)
        {
            case 0: imageViewchange.setImageResource(R.drawable.image0);
                break;

            case 1: imageViewchange.setImageResource(R.drawable.image1);
                break;

            case 2: imageViewchange.setImageResource(R.drawable.image2);
                break;

            case 3: imageViewchange.setImageResource(R.drawable.image3);
                break;

            case 4: imageViewchange.setImageResource(R.drawable.image4);



        }

    }








    @Override
    public void onClick(View view)
    {

       switch (view.getId()) {


           case R.id.button2:   dLayout.openDrawer(Gravity.RIGHT);
                 break;


           case R.id.button4:
               Intent intent=new Intent(this,ActivitySearch.class);
               startActivity(intent);
                break;

           case R.id.button5:
               Intent intent1=new Intent(this,CheckInActivity.class);
               startActivity(intent1);
               break;


           case R.id.button6:
               Intent intent2=new Intent(this,EventActivity.class);
               startActivity(intent2);
               break;

           case R.id.button7:
               Intent intent3=new Intent(this,OffersActivity.class);
               startActivity(intent3);
               break;


           case R.id.button8:
               Intent intent4=new Intent(this,RewardsZoneActivity.class);
               startActivity(intent4);
               break;



           case R.id.button10:
                Intent intent5=new Intent(this,Registration.class);
               startActivity(intent5);
               break;


           case R.id.button9:
                Intent intent6=new Intent(this,SignInActivity.class);
               startActivity(intent6);


       }

       }


}
