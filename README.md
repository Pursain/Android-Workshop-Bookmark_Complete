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

### Some Android Vocabulary

- build.Gradle: The tool that builds your application. A script that runs that automates the process of building an application. Built on top of Apache Maven and Apache Ant. 

- Manifest: Defines the entire application by its characteristics and the components that constitute it. Also where you place permissions for accessing different functionality of a phone.

- Android Activity: The activity initiates an Android program and is typically characterized by the onCreate() method, which should be nested in the Activity object

- Android Layouts: Layouts are defined in XML files. They are a bit cumbersome at first but you will see the usefulness of the clear organization when you undertake larger projects. Works similarly to HTML/CSS

- setContentView(): A method that sets the layout of the page to the XML page specified

- Bundle: Used to pass data between activities. Also used to retain data about a page when the state changes (i.e. orientation of the device, browser changes, etc.)



More can be found here: https://www.tutorialspoint.com/android/android_user_interface_layouts.htm




## 2. Let's click for Zots (Changing text with a button onClick)
In this section, you will create a mini-splash page that will change whenever you click a button. Sounds fun enough yeah?

Here's what we want:

<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/splash_page.gif' title="TODO 1" width=''/>

Now lets break it down. There seems to be three elements at play here; there's the title, the "Zot"s that pop out of nowhere and 
a button that you can click that makes the Zots.

## 3. It's time to move on to another activity (Changing activities with intents)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/intent_nextActivity.gif' title="TODO 1" width=''/>

## 4. So... do I make 100 textViews? (Interactions between listView, ArrayList, ArrayAdapters)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/listView.gif' title="TODO 1" width=''/>

## 5. Hardcoding is bad... (Dynamically populating the listView)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/populate_listView.gif' title="TODO 1" width=''/>

## 6. Let's launch a link! (Setting OnClickListeners to launch links with Uri and intents) 
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/launch_link.gif' title="TODO 1" width=''/>

## 7. I rotated my screen and it did what??? (Digging deeper into the activity lifecycle and saving information in the bundle)
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/with_bundleSave.gif' title="TODO 1" width=''/>
<img src='https://github.com/Pursain/Bookmark_Complete/blob/master/gif/without_bundleSave.gif' title="TODO 1" width=''/>
