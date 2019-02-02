package com.example.harry.bookmark_complete;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookmarksActivity extends AppCompatActivity {
    //logging
    private static final String TAG = "BookmarksActivity";

    //member variables of view objects
    private ListView listView_bookmark;
    private ArrayList<String> arrayList_bookmark;
    private ArrayAdapter<String> arrayAdapter_bookmark;
    private EditText editText_title;
    private EditText editText_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        //checks if there is anything in the savedInstanceState
        //savedInstanceState will be null the first time the activity opens
        //savedInstanceState will contain bookmarks info when the activity is redrawn
        //refer to activity lifecycle
        if (savedInstanceState != null) {
            //logging
            Log.d(TAG, "onCreate: savedInstanceState is not null, fetching bookmarks from bundle");

            //gets the saved arraylist
            arrayList_bookmark = savedInstanceState.getStringArrayList("bookmarks");
        } else {
            //logging
            Log.d(TAG, "onCreate: savedInstanceState is null, creating new arrayList");

            //creates a new arraylist and put google in it
            arrayList_bookmark = new ArrayList<String>();
            arrayList_bookmark.add("Google" +
                    "\nhttp://www.google.com");
        }

        //initialize the arrayadapter with a built-in layout and arrayList_bookmark
        arrayAdapter_bookmark = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList_bookmark);

        //initialize the listView with the arrayAdapter
        listView_bookmark = findViewById(R.id.listView_bookmark);
        listView_bookmark.setAdapter(arrayAdapter_bookmark);

        //adding an onItemClickListener to the listView
        //side note: AdapterView is a generic that can encompass listViews
        //           It's like a template in C++ and used like duck typing in python
        //           If that made no sense, don't worry about it
        listView_bookmark.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //this function is called when an item on the listView is clicked
            //the position variable tells us which one was clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //logging
                Log.d(TAG, "onItemClick: listView item clicked, position "
                        + Integer.toString(position)
                        + ", item text: " + arrayAdapter_bookmark.getItem(position));

                //parse the item text by its name and url
                String title = arrayAdapter_bookmark.getItem(position).split("\n")[0];
                String link = arrayAdapter_bookmark.getItem(position).split("\n")[1];

                //logging
                Log.d(TAG, "onItemClick: String split into title and link: ("
                        + title + ") (" + link + ")" );

                //toast to show which item clicked
                Toast.makeText(BookmarksActivity.this,
                        "Launching: " + title, Toast.LENGTH_SHORT).show();

                //converts the URL String into an URI so the intent can use it
                Intent intentToOpenLink = new Intent(Intent.ACTION_VIEW);
                intentToOpenLink.setData(Uri.parse(link));

                //starts the intent, does not check for validity tho :/
                startActivity(intentToOpenLink);
            }
        });

        //Storing the editText in a variable for future use (instead of re-searching)
        editText_title = (EditText) findViewById(R.id.editText_title);
        editText_URL = (EditText) findViewById(R.id.editText_URL);
    }

    //android calls this before the onStop() is called
    //useful to store information so that the activity can use when the activity restarts
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //logging
        Log.d(TAG, "onSaveInstanceState: saving the instance state");

        //store the arraylist data into the bundle key-value pair
        outState.putStringArrayList("bookmarks", arrayList_bookmark);
        super.onSaveInstanceState(outState);
    }

    //called when the add button is clicked
    //takes the text from editText and adds them to the arrayAdapter
    public void onClick_addNewBookmark(View view) {
        //logging
        Log.d(TAG, "onClick_addNewBookmark: add button clicked");

        //get the text from the editTexts
        String title = editText_title.getText().toString();
        String URL = editText_URL.getText().toString();

        //a little bit of validation
        //adds to the bookmark list only if both aren't empty strings
        if (!title.equals("") && !URL.equals("")) {
            //logging
            Log.d(TAG, "onClick_addNewBookmark: input valid");

            arrayAdapter_bookmark.add(title + "\n" + URL);
            Toast.makeText(this, "New Bookmark added", Toast.LENGTH_SHORT).show();
        } else {
            //logging
            Log.d(TAG, "onClick_addNewBookmark: input invalid");
            
            Toast.makeText(this, "Please fill out the Title and URL boxes", Toast.LENGTH_LONG).show();
        }

        //reset the EditText fields after adding to the list
        editText_title.setText("");
        editText_URL.setText("");
    }
}
