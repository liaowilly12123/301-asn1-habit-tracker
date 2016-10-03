package com.example.android.tingwei_habittracker;

/**
 * Created by willyliao on 2016-10-02.
 */

public class DaysSelectedSwitch {
    private int[] daysSelectedArray;
    private String daysSelectedString = "";

    public DaysSelectedSwitch(int[] daysSelectedArray) {
        this.daysSelectedArray = daysSelectedArray;
    }

    // concatenates the days selected depending on what user has selected.
    public String getDaysSelectedString() {
        for (int index = 0; index < daysSelectedArray.length; index++){
            switch (index){
                case 0: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Sun ";
                    break;
                }
                case 1: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Mon ";
                    break;
                }
                case 2: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Tue ";
                    break;
                }
                case 3: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Wed ";
                    break;
                }
                case 4: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Thu ";
                    break;
                }
                case 5: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Fri ";
                    break;
                }
                case 6: if (daysSelectedArray[index] == 1){
                    daysSelectedString = daysSelectedString + "Sat ";
                    break;
                }
            }
        }
        return daysSelectedString;
    }


}
