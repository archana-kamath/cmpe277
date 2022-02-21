package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context = this;
    private Button buttonDialog;
    private TextView textViewCount;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate------", "MainActivity:onCreate()");


        buttonDialog = (Button) findViewById(R.id.DialogButton);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog  dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_dialog);
                dialog.setTitle("Simple Dialog");

                Button closeDialog = (Button) dialog.findViewById(R.id.button);

                closeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
    }
    public void onClickStartB(View view) {

        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e("onStart------", "MainActivity:onStart()");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.e("onResume------", "MainActivity:onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.e("onPause------", "MainActivity:onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("onStop------", "MainActivity:onStop()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("onDestroy------", "MainActivity:onDestroy()");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        textViewCount = (TextView) findViewById(R.id.threadCounterText);
        count++;
        textViewCount.setText("Thread Counter: "+String.valueOf(count));
        Log.e("onRestart------", "MainActivity:onRestart()");
    }

    public void onCloseApp(View view) {
        MainActivity.this.finish();
    }
}