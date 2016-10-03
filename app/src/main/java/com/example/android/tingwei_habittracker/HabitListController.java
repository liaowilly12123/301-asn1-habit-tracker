package com.example.android.tingwei_habittracker;

import java.io.IOException;

/**
 * Created by willyliao on 2016-09-30.
 */

public class HabitListController {

    // Lazy Singleton
    private static HabitList habitListSingleton = null;

    // gets the habitList; if it doesn't exist it creates one
    static public HabitList getHabitList(){
        if (habitListSingleton == null){
            try {
                habitListSingleton = HabitListManager.getManager().loadHabitList();
                habitListSingleton.addListener(new Listener() {
                    @Override
                    public void update() {
                        saveHabitList();
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize habitlist from habitlistmanager");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize habitlist from habitlistmanager");
            }
        }
        return habitListSingleton;
    }

    // saves the HabitList
    static public void saveHabitList(){
        try {
            HabitListManager.getManager().saveHabitList(getHabitList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not deserialize habitlist from habitlistmanager");
        }
    }

    public Habit chooseHabit(int index) throws EmptyHabitListException {
        return getHabitList().chooseHabit(index);
    }

    public void addHabit(Habit habit) {
        getHabitList().addHabit(habit);
    }

}
