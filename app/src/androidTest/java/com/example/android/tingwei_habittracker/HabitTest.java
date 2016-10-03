package com.example.android.tingwei_habittracker;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by willyliao on 2016-09-29.
 */

public class HabitTest extends ActivityInstrumentationTestCase2 {
    public HabitTest(){
        super(com.example.android.tingwei_habittracker.Habit.class);
    }

    public void testHabit(){
        String habitName = "A Habit";
        Habit habit = new Habit(habitName);
        assertTrue("Habit Name is not equal", habitName.equals(habit.getName()));
    }

    public void testDateCreated(){
        String dateString = "2016/10/02";
        String habitName = "A Habit";
        Habit habit = new Habit(habitName);
        assertTrue("Habit Name is not equal", habitName.equals(habit.getName()));
        assertTrue("The date is not the same", dateString.equals(habit.getDate()));
    }

    public void testLastCompletedDate(){
        String dateString = "2016/10/02";
        String habitName = "A Habit";
        Habit habit = new Habit(habitName);
        assertTrue("Habit Name is not equal", habitName.equals(habit.getName()));
        habit.setLastCompletedDate();
        //since I'm testing right now
        assertTrue("The date is not the same", dateString.equals(habit.getDate()));
        assertTrue("Date Last created is todays date", (habit.getDate()).equals(habit.getLastCompletedDate()));
    }

    public void testHabitToString(){
        String habitName = "A habit";
        Habit habit = new Habit(habitName);
        assertTrue("Habit Name.toString is not equal", habitName.toString().equals(habit.getName()));
    }

    public void testHabitEquals(){
        String habitName = "A Habit";
        String habitNameC = "C Habit";
        Habit habitA = new Habit(habitName);
        Habit habitB = new Habit(habitName);
        Habit habitC = new Habit(habitNameC);
        assertTrue("A!=B", habitA.equals(habitB));
        assertTrue("B=A", habitB.equals(habitA));
        assertFalse("A==C", habitA.equals(habitC));
        assertFalse("B==C", habitB.equals(habitC));
        assertFalse("C==A", habitC.equals(habitA));
        assertTrue("A==A", habitA.equals(habitA));
        assertTrue("B==B", habitB.equals(habitB));
        assertTrue("C==C", habitC.equals(habitC));

        assertTrue("A==(Object)B", habitA.equals((Object)habitB));
    }

    public void testDays(){
        String habitName = "A Habit";
        Habit habit = new Habit(habitName);
        int thing = 2;
        assertTrue("not equal", habit.getDaysSelected(2) == thing);
    }
}

