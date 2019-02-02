package com.example.harry.bookmark_complete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    //for logging
    private static final String TAG = "SplashScreen";

    //storing the views in variables is typically a good idea if you are going to use them a lot
    private TextView textView_splashAnswer;
    private String currentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //android does a whole bunch of things in the background
        super.onCreate(savedInstanceState);

        //selects which xml file this activity will use
        setContentView(R.layout.activity_splash_screen);

        //calling findViewById every time you need a view object can be costly
        textView_splashAnswer = findViewById(R.id.textView_splashAnswer);
    }

    //called when the button "click to find out" is clicked
    //it is connected in the xml file by:  android:onClick="onClick_findAnswer"
    public void onClick_findAnswer(View view){
        //logging
        Log.d(TAG, "onClick_findAnswer: the current text is: " + currentText);

        //will grab the text from the textview and add "ZOT " behind it and display it
        currentText = textView_splashAnswer.getText().toString();
        currentText += "Zot ";
        textView_splashAnswer.setText(currentText);

        //logging
        Log.d(TAG, "onClick_findAnswer: the new text is: " + currentText);
    }

    //called when the button "next" is clicked
    //it is connected in the xml file by:  android:onClick="onClick_goToBookmarks"
    //creates an intent to go to a different activity (class)
    public void onClick_goToBookmarks(View view){
        //logging
        Log.d(TAG, "onClick_goToBookmarks: Moving to the next Activity");

        Intent intentToGoToBookmarks = new Intent(this, BookmarksActivity.class);
        startActivity(intentToGoToBookmarks);
    }
}
