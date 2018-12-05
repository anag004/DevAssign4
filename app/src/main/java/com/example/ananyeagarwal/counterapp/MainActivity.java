package com.example.ananyeagarwal.counterapp;

import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DebugMessage";
    private static final int counterValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout counterLayout = new RelativeLayout(this);

        Button incrementButton = new Button(this);
        incrementButton.setText("Increment");
        incrementButton.setId(1);
        RelativeLayout.LayoutParams incrementButtonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        incrementButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        incrementButtonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        counterLayout.addView(incrementButton, incrementButtonDetails);

        TextView counterDisplay = new TextView(this);
        counterDisplay.setText(Integer.toString(counterValue));
        counterDisplay.setId(2);
        RelativeLayout.LayoutParams counterDisplayDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        counterDisplay.setTextSize(40);
        counterDisplayDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        counterDisplayDetails.addRule(RelativeLayout.ABOVE, incrementButton.getId());
        counterDisplayDetails.setMargins(0, 0, 0, 50);
        counterLayout.addView(counterDisplay, counterDisplayDetails);
        setContentView(counterLayout);
        Log.i(TAG, "App loaded");
    }


}
