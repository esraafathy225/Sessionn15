package com.esraa.hp.session15;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button goToSecondActivity,showCustomToast,openMap,openBrowser;

private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToSecondActivity=findViewById(R.id.gotosecondactivity);
        showCustomToast=findViewById(R.id.showcustomtoast);
        openMap=findViewById(R.id.openmap);
        openBrowser=findViewById(R.id.openbrowser);

        Log.d(TAG,"onCreate");

        goToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });


        showCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=getLayoutInflater();
                View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.linear));
                Toast toast=new Toast(MainActivity.this);
                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("geo:45.652,-42.554");
                Intent i= new Intent(Intent.ACTION_VIEW,uri);
                if(i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            }
        });

        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("http://www.google.com");
                Intent i= new Intent(Intent.ACTION_VIEW,uri);
                if(i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");

    }
}
