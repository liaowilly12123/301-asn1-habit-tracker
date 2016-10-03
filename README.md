# Cmput301-as1: Habit Tracker
Link to as1 HabitTracker video: https://archive.org/details/Cmput301As1

This Habit Tracker app allows the user to create a Habit and save with it the days that they want to complete it on. Habit Tracker also allows the user to complete habit which were created. The habits individual information page will include info on the specific habit.

sources used: 

    http://stackoverflow.com/questions/15212832/how-to-save-current-date-and-time-to-database-using-java
    
    Followed along with professor, Abram Hindles, Student Saga Videos: 
      https://www.youtube.com/watch?v=5PPD0ncJU1g&list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O&index=1

Collaborated with:

        Angus Abels: aabels

compileSDKVersion 23
buildToolsVersion "23.0.3"
minSdkVersion 18
targetSdkVersion 23

Dependencies:

    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:23.4.0'
    testCompile 'junit:junit:4.12'

