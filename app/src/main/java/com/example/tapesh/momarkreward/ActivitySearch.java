package com.example.tapesh.momarkreward;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by TAPESH on 6/1/2016.
 */
public class ActivitySearch extends Activity implements View.OnClickListener{

    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;

    Button ButtonDrawer,button3back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activitysearch);

        menu = new String[]{"Home","Search","Offers","Sign In","Register","Change Your Location","Reset Location","About App","Feedback","Report A Problem","Privacy Policy","FAQ's"};
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);

        ButtonDrawer=(Button)findViewById(R.id.button2);
        button3back=(Button)findViewById(R.id.button3);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);

        dList.setAdapter(adapter);

        ButtonDrawer.setOnClickListener(this);
        button3back.setOnClickListener(this);
    }


  @Override
    public void onClick(View view)
  {
      switch (view.getId())
      {
          case R.id.button2:
              dLayout.openDrawer(Gravity.RIGHT);
              break;

          case R.id.button3:
                         finish();

              break;



      }
  }

}
