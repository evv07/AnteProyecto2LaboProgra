package com.example.simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class YouLostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lost);

        TextView pointsTextView = (TextView) findViewById(R.id.pointsTextView);

        //Para extraer los puntos de la PlayScreen activity
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            pointsTextView.setText(String.valueOf(extras.getInt("puntos")));


        }







    }
}
