package com.example.android.tingwei_habittracker;

import java.io.Serializable;

/**
 * Created by willyliao on 2016-09-29.
 */

public class Habit implements Serializable{

    private static final long serialVersionUID = 50L;

    protected String habitName;
    protected String dateCreated;
    protected int[] daysSelected;
    private String lastCompletedDate;
    private int completionCount = 0;

    public Habit(String habitName) {
        this.habitName = habitName;
        this.dateCreated = currentDate();
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return habitName;
    }

    public String getDate() {
        return dateCreated;
    }

    public String currentDate(){
        createDate newDate = new createDate();
        return newDate.getDate();
    }

    public void setLastCompletedDate() {
        this.lastCompletedDate = currentDate();
    }

    public String getLastCompletedDate() {
        return lastCompletedDate;
    }

    public void setDaysSelected(int[] daysSelected) {
        this.daysSelected = daysSelected;
    }

    public int[] getDaysSelected() {
        return daysSelected;
    }

    public void incrementCompletionCount(){
        this.completionCount = this.completionCount + 1;
    }

    public int getCompletionCount() {
        return completionCount;
    }

    // for test
    public boolean equals(Object compareHabit){
        if (compareHabit != null &&
                compareHabit.getClass() == this.getClass()){
            return this.equals((Habit)compareHabit);
        }else{
            return false;
        }
    }

    // for test
    public boolean equals(Habit compareHabit){
        if (compareHabit == null){
            return false;
        }
        return getName().equals(compareHabit.getName());
    }
}
