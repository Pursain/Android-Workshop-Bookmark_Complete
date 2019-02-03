# Bookmark_Complete
This is the complete code for the Intro to Android Development for HackUCI 2019

For the Template Code:

# Table Of Contents
1. **Exploring Android and the Android Studio IDE**
2. **Let's click for Zots** (Changing text with a button onClick)
3. **It's time to move on to another activity** (Changing activities with intents)
4. **So... do I make 100 textViews?** (Interactions between listView, ArrayList, ArrayAdapters)
5. **Hardcoding is bad...** (Dynamically populating the listView)
6. **Let's launch a link!** (Setting OnClickListeners to launch links with Uri and intents) 
7. **I rotated my screen and it did what???** (Digging deeper into the activity lifecycle and saving information in the bundle)

## 1. Exploring Android and the Android Studio IDE

***TODO revise this section***

### Some Android Vocabulary

- build.Gradle: The tool that builds your application. A script that runs that automates the process of building an application. Built on top of Apache Maven and Apache Ant. 

- Manifest: Defines the entire application by its characteristics and the components that constitute it. Also where you place permissions for accessing different functionality of a phone.

- Android Activity: The activity initiates an Android program and is typically characterized by the onCreate() method, which should be nested in the Activity object

- Android Layouts: Layouts are defined in XML files. They are a bit cumbersome at first but you will see the usefulness of the clear organization when you undertake larger projects. Works similarly to HTML/CSS

- setContentView(): A method that sets the layout of the page to the XML page specified

- Bundle: Used to pass data between activities. Also used to retain data about a page when the state changes (i.e. orientation of the device, browser changes, etc.)

More can be found here: https://www.tutorialspoint.com/android/android_user_interface_layouts.htm

## 2. Let's click for Zots (Changing text with a button onClick)

Let's do something fun to start. In this section, you will create a mini-splash page that will pop up text whenever you click a button. Sounds fun enough yeah?

Here's what it should look like:

<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/splash_page.gif' title="TODO 1" width=''/>

Now lets break it down. There seems to be three elements at play here; there's the title, the "Zot"s that pop out of nowhere and 
a button that you can click that makes the Zots. To me, that sounds like I need to make 2 TextViews and a button. It seems like we also need to write a function that changes the text inside one of the TextViews and its triggered by the button click.

### Task 1: create the XML views needed for the splash screen

It's easiest to edit the XML file using Android Studio's design interface, its pretty intuitive with the drag and drop interface. 

For the sake of coherency, name your view objects as the following:
 - textView_splashQuestion for the TextView that says "What do Anteaters say?"
 - textView_splashAnswer for the TextView that will contain our Zots
 - button_splashGetAnswer for the Button that says "Click to find out!"

Below is the text solution to the XML needed to make those 3 elements. Looks really wordy right? The built-in design tool in Android Studio astracts it so you won't have to worry about every minute detail but it is good to know that this is the actual xml text that is used to draw your apps. 

    <TextView
        android:id="@+id/textView_splashQuestion"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="8dp"
        android:text="What do Anteaters say?"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView_splashAnswer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="8dp"
        android:textAlignment="center"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView_splashQuestion"
        tools:text="Zot Zot Zot" />

    <Button
        android:id="@+id/button_splashGetAnswer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="8dp"
        android:text="Click to find out!"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView_splashAnswer" />

### Task 2: modify the onClick_findAnswer function to add zots to the textView 

How are we going to change the text of a TextView? Well, there are two functions in the TextView class that we will use to change the text of the TextView: 
 - someTextView.getText().toString() will return the String inside the textView 
 - someTextView.setText("Hello World") will set the text of the textView to the String

Heres what the Puesdocode looks like if you wanted to append text to a TextView:
 - get the String from the textView and store it into a String variable 
 - append the additional text to the String variable 
 - set the String variable to the textView 
 
Implementing the Puesdocode in our application will look like this:

    public void onClick_findAnswer(View view){
      currentText = textView_splashAnswer.getText().toString();
      currentText += "Zot ";
      textView_splashAnswer.setText(currentText);
    }
 
Notice the view parameter in this function. It is a necessary signature for the onClick attribute to link to this function. What the view object is, in this case, the button itself. Again, everything in the xml file are views, including buttons.  
 
Cool, we have the function written now but clicking the button doesn't do anything. We want it to do something when you click the button. If the xml file is where all the visuals are and the java activity file is where all functions are run, how do I connect the two? There are many ways the XML files interact with the java class. For our purposes, we are interested in the onClick attribute of the button. To implement that, you will want to add this line to the button view:

    android:onClick="onClick_findAnswer"

Your splash screen should zot on now everytime you click the button.

## 3. It's time to move on to another activity (Changing activities with intents)

Applications often have different screens with each screen dedicated to a specific function. At the moment, we only have one screen/activity but let's say we another screen/activity. How do we move from one activity to another?

**Intents** are what we will use to move from one activity to another. Intents are really powerful and are used throughout Android to do many things (as we will see later), one of its capabilities is to allow us to move from one activity to another nicely. This is what intents look like in the code: 

    Intent someIntent = new Intent(this, theActivityWeWantToGoTo.class);
    startActivity(someIntent);
    
The first parameter of the Intent is the context of the application. The context is essentially background information about the app that the intent uses in the background when it does things, you don't need to worry too much about this, "this" will typically do. 
The second paramter is the name of the activity you want to go to, often the file name followed by .class. The second line startActivity will run the intent object.   

Here's what we want to do next: 

<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/intent_nextActivity.gif' title="TODO 1" width=''/>

We have a button where when you click on it, it takes us to another activity. We would need to make a new button and use this new thing called intents

### Task 3: creating a button that takes us to another activity

First thing we need to do is to create another button (lets name it button_moveToNextScreen) and link its onClick attribute to a function in the java file (lets call it onClick_goToBookmarks). We have already done it in the previous task so refer back to that if needed. 

Here's what the code should look like:

    public void onClick_goToBookmarks(View view){
        Intent intentToGoToBookmarks = new Intent(this, BookmarksActivity.class);
        startActivity(intentToGoToBookmarks);
    }
    
If class name matches up and the button is connected, clicking the button should move you to the next activity :D

## 4. So... do I make 100 textViews? (Interactions between listView, ArrayList, ArrayAdapters)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/listView.gif' title="TODO 1" width=''/>

## 5. Hardcoding is bad... (Dynamically populating the listView)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/populate_listView.gif' title="TODO 1" width=''/>

## 6. Let's launch a link! (Setting OnClickListeners to launch links with Uri and intents) 
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/launch_link.gif' title="TODO 1" width=''/>

## 7. I rotated my screen and it did what??? (Digging deeper into the activity lifecycle and saving information in the bundle)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/with_bundleSave.gif' title="TODO 1" width=''/>
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/github_media/without_bundleSave.gif' title="TODO 1" width=''/>
