package com.example.chicken.activitytransitiontest3;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private View mShareViewLightGray;
    private View mShareViewGray;
    private View mShareViewDarkGray;
    public static String mShareLightGray = "light_gray";
    public static String mShareGray = "gray";
    public static String mShareDarkGray = "dark_gray";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        Slide slide1 = new Slide();
        slide1.setDuration(500);
        //左方向へスライド
        slide1.setSlideEdge(Gravity.LEFT);

        Slide slide2 = new Slide();
        slide2.setDuration(200);

        getWindow().setSharedElementEnterTransition(slide2);
        getWindow().setSharedElementExitTransition(slide2);
        getWindow().setExitTransition(slide1);
        getWindow().setEnterTransition(slide1);

        mShareViewLightGray = findViewById(R.id.light_gray);
        mShareViewGray = findViewById(R.id.gray);
        mShareViewDarkGray = findViewById(R.id.dark_gray);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                
                Pair<View, String> shareLightGray = Pair.create(mShareViewLightGray, mShareLightGray);
                Pair<View, String> shareGray = Pair.create(mShareViewGray, mShareGray);
                Pair<View, String> shareDarkGray = Pair.create(mShareViewDarkGray, mShareDarkGray);
                
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, shareLightGray, shareGray, shareDarkGray).toBundle();
                startActivity(intent, bundle);

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
}
