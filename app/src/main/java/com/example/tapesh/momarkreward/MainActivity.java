package com.example.tapesh.momarkreward;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements LocationListener {

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String provider;
    double longitude1, lattitude;
    protected boolean gps_enabled,network_enabled;
    Location locatiion1;
    String locality,sector;
    TextView headtextView,changedtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);













        headtextView=(TextView)findViewById(R.id.textView);
        changedtextView=(TextView)findViewById(R.id.textView2);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Log.i("PERMISSION_EXCEPTION", "main");



//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
//                PackageManager.PERMISSION_GRANTED &&
//                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
//                        PackageManager.PERMISSION_GRANTED) {
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
//            locatiion1=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        } else {
//            Log.i("permission ","not granted");
//        }


        try {

          locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            locatiion1=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Log.i("PERMISSION_EXCEPTION", "try");
        } catch (SecurityException e) {
            Log.i("PERMISSION_EXCEPTION", e.toString());
        }


        if(locatiion1!=null) {
            longitude1 = locatiion1.getLongitude();
            lattitude = locatiion1.getLatitude();
        }
        Log.i("long",longitude1+"");
        Log.i("lat",lattitude+"");
       try {
           Geocoder gcd = new Geocoder(MainActivity.this, Locale.getDefault());
           List<Address> addresses = gcd.getFromLocation(lattitude, longitude1, 1);

           String name=addresses.get(0).getCountryName();
            locality=addresses.get(0).getLocality();
            sector=addresses.get(0).getSubLocality();
           Log.i("locality", locality);
           Log.i("name", name);
           Log.i("subloaclity", sector);







            //changed text after 2 second
           Handler handler1=new Handler();
           handler1.postDelayed(new Runnable() {
               @Override
               public void run() {
                   function1();

               }
           }, 2000);






            // start intent after 3 seconds
           Handler handler=new Handler();
           handler.postDelayed(new Runnable() {
                              @Override
                              public void run()
                              {
                                 function();

                              }
           },3000);




                              }catch(Exception e)
       {
           Log.i("error",e.toString());
       }



       }

      void function()
      {
          Intent intent = new Intent(this, Activity1.class);
          Bundle extras = new Bundle();
          extras.putString("locality", locality);
          extras.putString("sector", sector);
          intent.putExtras(extras);



          startActivity(intent);
          finish();
      }



    void  function1()
    {
        changedtextView.setText("Please stand by as we check updates");

    }









    @Override
    public void onLocationChanged(Location location) {
        longitude1=location.getLongitude();
         lattitude=location.getLatitude();

        Log.i("long.....",longitude1+"");


    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }








}
