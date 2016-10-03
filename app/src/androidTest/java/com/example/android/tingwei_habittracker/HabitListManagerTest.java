package com.example.android.tingwei_habittracker;

import android.test.AndroidTestCase;

import java.io.IOException;

/**
 * Created by willyliao on 2016-10-01.
 */

public class HabitListManagerTest extends AndroidTestCase {

    public void testHabitToString(){
        HabitList hl = new HabitList();
        Habit testHabit = new Habit("test Habit");
        hl.addHabit(testHabit);
        try {
            String str = HabitListManager.habitListToString(hl);
            assertTrue("String is too small", str.length() > 0);
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue("IOException " +e, false);
        }
    }


    public void testHabitListManager(){
        try {
            HabitList hl = new HabitList();
            Habit testHabit = new Habit("test Habit");
            hl.addHabit(testHabit);
            HabitListManager hlm = new HabitListManager(getContext());
            hlm.saveHabitList(hl);
            HabitList hl2 = hlm.loadHabitList();
            hl2.contains(testHabit);
            assertTrue("hl2 size is not consistent", hl2.size() == 1);
            assertTrue("Test habit is not in habit list 2", hl2.contains(testHabit));
            assertTrue("Test habit is in habit list", hl.contains(testHabit));
        }catch (IOException e){
            e.printStackTrace();
            assertTrue("IOException thrown" + e.toString(), false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            assertTrue("ClassNotFoundException thrown" + e.toString(), false);
        }
    }
}
