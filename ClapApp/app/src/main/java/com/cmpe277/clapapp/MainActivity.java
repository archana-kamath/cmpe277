package com.cmpe277.clapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mediaPlayer = MediaPlayer.create(this, R.raw.clap);
        mediaPlayer.setLooping(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float proximityVal = sensorEvent.values[0];

        TextView sensorReading = findViewById(R.id.reading);

        if (!mediaPlayer.isPlaying() && proximityVal<5) {
            Log.i("MainActivity","Phone is near");
            Toast.makeText(getApplicationContext(), "Phone is near", Toast.LENGTH_SHORT).show();
            sensorReading.setText("Music is playing");
            mediaPlayer.start();

        }else if(mediaPlayer.isPlaying()){
            Log.i("MainActivity","Phone is far");
            Toast.makeText(getApplicationContext(), "Phone is far", Toast.LENGTH_SHORT).show();
            sensorReading.setText("Music is paused");
            mediaPlayer.pause();

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void closeApp(View v) {
        MainActivity.this.finish();
    }
}