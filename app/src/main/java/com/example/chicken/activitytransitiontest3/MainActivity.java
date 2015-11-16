package com.example.chicken.activitytransitiontest3;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private View mShareViewLightGray;
    private View mShareViewGray;
    private View mShareViewDarkGray;
    private View mShareViewBlack;
    public static String mShareLightGray = "light_gray";
    public static String mShareGray = "gray";
    public static String mShareDarkGray = "dark_gray";
    public static String mShareBlack = "black";
    private ImageView mViewLightGray;
    private ImageView mViewGray;
    private ImageView mViewDarkGray;
    private ImageView mViewBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
//        Slide slide1 = new Slide();
//        //画面遷移アニメーション処理時間
//        slide1.setDuration(5000);
//        //画面遷移アニメーションディレイ
//        slide1.setStartDelay(50000);
//        //左方向へスライド
//        slide1.setSlideEdge(Gravity.LEFT);
//
//        Slide slide2 = new Slide();
//        slide2.setDuration(2000);
//        slide2.setSlideEdge(Gravity.TOP);
//
//        getWindow().setSharedElementEnterTransition(slide2);
//        getWindow().setSharedElementExitTransition(slide2);
//        getWindow().setExitTransition(slide1);
//        getWindow().setEnterTransition(slide1);

        mShareViewLightGray = findViewById(R.id.light_gray);
        mShareViewGray = findViewById(R.id.gray);
        mShareViewDarkGray = findViewById(R.id.dark_gray);
        mShareViewBlack = findViewById(R.id.black);

        mViewLightGray = (ImageView)mShareViewLightGray;
        mViewGray = (ImageView)mShareViewGray;
        mViewDarkGray = (ImageView)mShareViewDarkGray;
        mViewBlack = (ImageView)mShareViewBlack;
        //非表示化
        setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //表示化
                setVisibility(View.VISIBLE);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Pair<View, String> shareLightGray = Pair.create(mShareViewLightGray, mShareLightGray);
                Pair<View, String> shareGray = Pair.create(mShareViewGray, mShareGray);
                Pair<View, String> shareDarkGray = Pair.create(mShareViewDarkGray, mShareDarkGray);
                Pair<View, String> shareBlack = Pair.create(mShareViewBlack, mShareBlack);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, shareLightGray, shareGray, shareDarkGray, shareBlack).toBundle();
                startActivity(intent, bundle);
                //非表示化
                setVisibility(View.INVISIBLE);
            }
        });

    }

    private void setVisibility(int visibility){
        //非表示化
        mViewLightGray.setVisibility(visibility);
        mViewGray.setVisibility(visibility);
        mViewDarkGray.setVisibility(visibility);
        mViewBlack.setVisibility(visibility);
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
