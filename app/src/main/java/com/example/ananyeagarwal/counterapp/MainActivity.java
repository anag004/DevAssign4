package com.example.ananyeagarwal.counterapp;

import android.content.res.Resources;
import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DebugMessage";
    private static final int counterValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the layout variable
        RelativeLayout counterLayout = new RelativeLayout(this);

        // Create a new button and set the text and ID attributes
        Button incrementButton = new Button(this);
        incrementButton.setText("Increment");
        incrementButton.setId(1);

        // Set the Layout Parameters for the button to place it
        RelativeLayout.LayoutParams incrementButtonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        incrementButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        incrementButtonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        // Place the button
        counterLayout.addView(incrementButton, incrementButtonDetails);

        // Create the static text field which will display the counterValue variable
        TextView counterDisplay = new TextView(this);
        counterDisplay.setText(Integer.toString(counterValue));
        counterDisplay.setId(2);

        // let the text field be above the button
        RelativeLayout.LayoutParams counterDisplayDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        counterDisplay.setTextSize(40);
        counterDisplayDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        counterDisplayDetails.addRule(RelativeLayout.ABOVE, incrementButton.getId());
        counterDisplayDetails.setMargins(0, 0, 0, 50);

        // Add the text field
        counterLayout.addView(counterDisplay, counterDisplayDetails);

        // Load the layout
        setContentView(counterLayout);

        Log.i(TAG, "App loaded");
    }

}
