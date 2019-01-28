package com.example.harry.bookmark_complete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG = "SplashScreen";
    private TextView textView_splashAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView_splashAnswer = findViewById(R.id.textView_splashAnswer);
    }

    //called when the button "click to find out" is clicked
    //it is connected in the xml file by:  android:onClick="onClick_findAnswer"
    public void onClick_findAnswer(View view){
        String previousText = textView_splashAnswer.getText().toString();
        previousText += "Zot ";
        textView_splashAnswer.setText(previousText);
    }

    //called when the button "next" is clicked
    //creates an intent to go to a different activity (class)
    public void onClick_goToBookmarks(View view){
        Intent intentToGoToBookmarks = new Intent(this, BookmarksActivity.class);
        startActivity(intentToGoToBookmarks);
    }
}
