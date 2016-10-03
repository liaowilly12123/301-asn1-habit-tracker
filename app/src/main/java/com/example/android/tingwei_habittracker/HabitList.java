package com.example.android.tingwei_habittracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by willyliao on 2016-09-29.
 */

public class HabitList implements Serializable {

    private static final long serialVersionUID = 25L;
    protected ArrayList<Habit> habitList = null;

    //transient so it's not saved by HabitListManager
    protected transient ArrayList<Listener> listeners = null;

    public HabitList() {
        habitList = new ArrayList<Habit>();
        listeners = new ArrayList<Listener>();
    }


    private ArrayList<Listener> getListeners(){
        if (listeners == null){
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    // returns habitList
    public Collection<Habit> getHabits() {
        return habitList;
    }

    public void addHabit(Habit habit) {
        habitList.add(habit);
        notifyListeners();
    }

    //to notify that something has changed and should be updated
    public void notifyListeners(){
        //TO DO
        for (Listener listener : getListeners()){
            listener.update();
        }
    }

    public void removeHabit(Habit habit) {
        habitList.remove(habit);
        notifyListeners();
    }

    public Habit chooseHabit(int index) throws EmptyHabitListException {
        int size = habitList.size();
        if (size <=0){
            throw new EmptyHabitListException();
        }
        return habitList.get(index);
    }

    public int size() {
        return habitList.size();
    }

    public boolean contains(Habit habit) {
        return habitList.contains(habit);
    }

    public void addListener(Listener l) {
        getListeners().add(l);
    }

    public void removeListener(Listener l) {
        getListeners().remove(l);
    }
}
