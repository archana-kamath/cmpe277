package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Bundle bundle = getIntent().getExtras();
    }

    public void onClickFinishB(View view) {
        ActivityB.this.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart ------ ","ActivityB: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume ------ ","ActivityB: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause ------ ","ActivityB: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop ------ ","ActivityB: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy ------ ","ActivityB: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart ------ ","ActivityB: onRestart()");
    }

}