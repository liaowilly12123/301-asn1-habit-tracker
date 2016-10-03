package com.example.android.tingwei_habittracker;

import android.test.ActivityInstrumentationTestCase2;


import java.util.Collection;

/**
 * Created by willyliao on 2016-09-29.
 */

public class HabitListTest extends ActivityInstrumentationTestCase2 {

    public HabitListTest(){
        super(com.example.android.tingwei_habittracker.HabitList.class);
    }
    public void testEmptyHabitList(){
        HabitList habitList = new HabitList();
        assertTrue("Empty Habit List", habitList.size() == 0);
    }

    public void testAddHabitList(){
        HabitList habitList = new HabitList();
        String habitName = "A Habit";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);

        assertTrue("Empty Habit List Size", habitList.size() == 1);
        assertTrue("Test Student Not Contained", habitList.contains(testHabit));
    }

    public void testGetHabits(){
        HabitList habitList = new HabitList();
        String habitName = "A Habit";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("Empty Habit List Size", habits.size() == 1);
        assertTrue("Test Student Not Contained", habits.contains(testHabit));
    }

    public void testRemoveHabit(){
        HabitList habitList = new HabitList();
        String habitName = "A Habit";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        assertTrue("Empty Habit List Size Isn't Big Enough", habitList.size() == 1);
        assertTrue("", habitList.contains(testHabit));
        habitList.removeHabit(testHabit);
        assertTrue("Empty Habit List Size Isn't Small Enough", habitList.size() == 0);
        assertFalse("Test Student Still Contained", habitList.contains(testHabit));
    }

    boolean updated = false;
    public void testNotifyListeners(){
        HabitList habitList = new HabitList();
        updated = false;
        Listener l = new Listener(){
            public void update(){
                HabitListTest.this.updated = true;
            }
        };

        habitList.addListener(l);
        Habit testHabit = new Habit("hello");
        habitList.addHabit(testHabit);
        assertTrue("HabitList didn't fire an update off", this.updated);
        updated = false;
        habitList.removeHabit(testHabit);
        assertTrue("Removing a habit from the HabitList didn't fire an update off", this.updated);

    }

    public void testRemoveListeners(){
        HabitList habitList = new HabitList();
        updated = false;
        Listener l = new Listener(){
            public void update(){
                HabitListTest.this.updated = true;
            }
        };
        habitList.addListener(l);
        habitList.removeListener(l);
        habitList.addHabit(new Habit("Eat food"));
        assertFalse("HabitList didn't fire an update off", this.updated);
    }
}

