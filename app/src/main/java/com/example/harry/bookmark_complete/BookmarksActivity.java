package com.example.harry.bookmark_complete;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookmarksActivity extends AppCompatActivity {
    private ListView listView_bookmark;
    private ArrayList<String> arrayList_bookmark;
    private ArrayAdapter<String> arrayAdapter_bookmark;

    private EditText editText_title;
    private EditText editText_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        //checks if a previous state with bookmark arraylist is available
        //savedInstanceState will be null the first time the activity opens
        //savedInstanceState will contain bookmarks anytime this activity is re-put in foreground
        //refer to activity lifecycle
        if (savedInstanceState != null){
            arrayList_bookmark = savedInstanceState.getStringArrayList("bookmarks");
        }else{
            arrayList_bookmark = new ArrayList<String>();
            arrayList_bookmark.add("Google" +
                    "\nhttp://www.google.com");
        }

        //initilize the arrayadapter with a built-in layout and arrayList_bookmark
        arrayAdapter_bookmark = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList_bookmark);

        //initilize the listView with the arrayAdapter and add a onClickListener
        listView_bookmark = (ListView)findViewById(R.id.listView_bookmark);
        listView_bookmark.setAdapter(arrayAdapter_bookmark);
        listView_bookmark.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //this function is called when an item on the listView is clicked
            //the position variable tells us which one was clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //parse the item text by its name and url
                String title = arrayAdapter_bookmark.getItem(position).split("\n")[0];
                String link = arrayAdapter_bookmark.getItem(position).split("\n")[1];

                //toast to show which item clicked
                Toast.makeText(BookmarksActivity.this,
                        "Launching website: " + title, Toast.LENGTH_SHORT).show();

                //converts the URL String into an URI so the intent can use it
                Intent intentToOpenLink = new Intent(Intent.ACTION_VIEW);
                intentToOpenLink.setData(Uri.parse(link));

                //starts the intent, does not check for validity tho :/
                startActivity(intentToOpenLink);
            }
        });

        //Storing the editText in a variable for future use (instead of re-searching)
        editText_title = (EditText)findViewById(R.id.editText_title);
        editText_URL = (EditText)findViewById(R.id.editText_URL);
    }

    //android calls this before the onStop() is called
    //useful to store information so that the activity can use when the activity restarts
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //store the arraylist data into the bundle key-value pair
        outState.putStringArrayList("bookmarks", arrayList_bookmark);
        super.onSaveInstanceState(outState);
    }

    //called when the add button is clicked
    //takes the text from editText and adds them to the arrayAdapter
    public void onClick_addNewBookmark(View view){
        //get the text from the editTexts
        String title = editText_title.getText().toString();
        String URL = editText_URL.getText().toString();

        //adds to the bookmark list only if both aren't empty strings
        if (!title.equals("") && !URL.equals("")){
            arrayAdapter_bookmark.add(title + "\n" + URL);
            Toast.makeText(this, "New Bookmark added", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please fill out the Title and URL boxes", Toast.LENGTH_LONG).show();
        }

        //reset the EditText fields after adding to the list
        editText_title.setText("");
        editText_URL.setText("");
    }
}
