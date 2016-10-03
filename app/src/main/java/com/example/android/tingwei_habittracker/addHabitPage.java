package com.example.android.tingwei_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class addHabitPage extends AppCompatActivity {
    final int[] daysSelected = new int[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit_page);
        HabitListManager.initManager(this.getApplicationContext());

        TextView dateText = (TextView) findViewById(R.id.current_date_text);
        createDate newDate = new createDate();
        String currentDate = newDate.getDate();
        dateText.setText(currentDate);
    }

    public void addHabit(View view){
        HabitListController hbt = new HabitListController();
        EditText habitText= (EditText) findViewById(R.id.add_habit_edittext);

        /**get habitName and create a new Habit with it*/
        Habit newHabit = new Habit(habitText.getText().toString());

        /**set the Days selected in habit to the daysSelected array from this class*/
        newHabit.setDaysSelected(daysSelected);
        hbt.addHabit(newHabit);
        finish();
    }

    /**
    // All toggles below each handles a day of the week
     */
    public void sunToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[0] = 1;
        }
        else {
            daysSelected[0] = 0;
        }
    }

    public void monToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[1] = 1;
        }
        else {
            daysSelected[1] = 0;
        }
    }

    public void tueToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[2] = 1;
        }
        else {
            daysSelected[2] = 0;
        }
    }

    public void wedToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[3] = 1;
        }
        else {
            daysSelected[3] = 0;
        }
    }

    public void thuToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[4] = 1;
        }
        else {
            daysSelected[4] = 0;
        }
    }

    public void friToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[5] = 1;
        }
        else {
            daysSelected[5] = 0;
        }
    }

    public void satToggle(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            daysSelected[6] = 1;
        }
        else {
            daysSelected[6] = 0;
        }
    }

}
