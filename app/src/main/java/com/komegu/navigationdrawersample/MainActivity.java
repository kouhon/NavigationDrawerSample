package com.komegu.navigationdrawersample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements DrawerListener
{
    private DrawerLayout mDrawerLayout;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        this.mDrawerLayout.setDrawerListener(this);
        this.mButton = (Button)findViewById(R.id.button);
        this.mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity.this.mDrawerLayout.openDrawer(Gravity.START);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset)
    {
        Log.d(this.getClass().getName(), new StringBuffer()
                .append("onDrawerSlide slideOffset:").append(slideOffset).toString());
    }
    @Override
    public void onDrawerOpened(View drawerView)
    {
        Log.d(this.getClass().getName(), "onDrawerOpened");
    }
    @Override
    public void onDrawerClosed(View drawerView)
    {
        Log.d(this.getClass().getName(), "onDrawerClosed");
    }
    @Override
    public void onDrawerStateChanged(int newState)
    {
        Log.d(this.getClass().getName(), new StringBuffer()
                .append("onDrawerStateChanged newState:").append(newState).toString());
    }
}
