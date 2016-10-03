package com.example.android.tingwei_habittracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by willyliao on 2016-10-02.
 */

public class createDate {

    public String getDate(){
        // Taken from: http://stackoverflow.com/questions/15212832/how-to-save-current-date-and-time-to-database-using-java
        DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        String date = dFormat.format(today);
        return date;
    }

}
