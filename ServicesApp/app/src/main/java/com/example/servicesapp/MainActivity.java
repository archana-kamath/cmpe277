package com.example.servicesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView filenameText;

    String filename ="";

    String[] links = {"https://static.googleusercontent.com/media/research.google.com/en//pubs/archive/45530.pdf",
            "https://hadoop.apache.org/docs/r1.2.1/hdfs_design.pdf",
            "https://pages.databricks.com/rs/094-YMS-629/images/LearningSpark2.0.pdf",
            "https://docs.aws.amazon.com/wellarchitected/latest/machine-learning-lens/wellarchitected-machine-learning-lens.pdf",
            "https://developers.snowflake.com/wp-content/uploads/2020/09/SNO-eBook-7-Reference-Architectures-for-Application-Builders-MachineLearning-DataScience.pdf"};

    Button downloadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filenameText = findViewById(R.id.filenames);
        downloadButton = findViewById(R.id.downloadButton);
        filenameText.setText("/storage/emulated/0/Download/");

        downloadButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(permission,100);
                }else{
                    Log.i("MainActivity","Pressed on Download Button");
                    DownloadFile downloadFile = new DownloadFile();
                    downloadFile.execute(links);

                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.i("MainActivity","Pressed on Download Button");
            DownloadFile downloadFile = new DownloadFile();
            downloadFile.execute(links);
        }
    }
}

