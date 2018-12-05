package com.example.ananyeagarwal.counterapp;

import android.content.res.Resources;
import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DebugMessage";
    private static int counterValue = 0;

    public void updateCounterDisplay(TextView counterDisplay) {
        counterDisplay.setText(Integer.toString(counterValue));
    }

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
        final TextView counterDisplay = new TextView(this);
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

        // Make a reset button
        Button resetButton = new Button(this);
        resetButton.setText("reset");
        resetButton.setId(3);

        // Layout parameters for the reset button, (place it below the increment button)
        RelativeLayout.LayoutParams resetButtonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        resetButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        resetButtonDetails.addRule(RelativeLayout.BELOW, incrementButton.getId());
        resetButtonDetails.setMargins(0, 50, 0, 0);

        // Add the button
        counterLayout.addView(resetButton, resetButtonDetails);


        Log.i(TAG, "App loaded");

        // Set a listener to the increment button
        incrementButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        counterValue++;
                        updateCounterDisplay(counterDisplay);
                    }
                }
        );

        // Set a listener to the reset button
        resetButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        counterValue = 0;
                        updateCounterDisplay(counterDisplay);
                    }
                }
        );

        // Add a text field to take the jump number
        final EditText jumpValueField = new EditText(this);
        jumpValueField.setHint("Integer jump");
        jumpValueField.setId(4);

        // Layout parameters for the text field
        RelativeLayout.LayoutParams jumpValueFieldDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        jumpValueFieldDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        jumpValueFieldDetails.addRule(RelativeLayout.BELOW, resetButton.getId());
        jumpValueFieldDetails.setMargins(0, 50, 0, 0);

        // Display the field
        counterLayout.addView(jumpValueField, jumpValueFieldDetails);

        // Add a button to submit the value
        Button jumpButton = new Button(this);
        jumpButton.setText("Jump");
        jumpButton.setId(5);

        // Layout parameters
        RelativeLayout.LayoutParams jumpButtonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        jumpButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        jumpButtonDetails.addRule(RelativeLayout.BELOW, jumpValueField.getId());
        jumpButtonDetails.setMargins(0, 50, 0, 0);

        // Display this button
        counterLayout.addView(jumpButton, jumpButtonDetails);

        // Add a event listener for the jump button
        jumpButton.setOnClickListener(
                new Button.OnClickListener() {
                    public  void onClick(View v) {
                        String jumpValue = jumpValueField.getText().toString();
                        try {
                            int integerJumpValue = Integer.parseInt(jumpValue);
                            counterValue += integerJumpValue;
                            updateCounterDisplay(counterDisplay);
                        } catch (NumberFormatException e) {
                            // do nothing
                        }
                    }
                }
        );

        // Load the layout
        setContentView(counterLayout);

    }

}
