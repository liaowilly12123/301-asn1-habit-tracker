package com.example.android.tingwei_habittracker;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class IndividualHabitInfo extends AppCompatActivity {
    private int index;
    private ArrayList<Habit> habitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_habit_info);

        HabitListManager.initManager(this.getApplicationContext());

        //gets habitLIst and index of item clicked from previous activity to current one
        habitList = (ArrayList<Habit>) getIntent().getSerializableExtra("habitList");
        index = getIntent().getIntExtra("index", 0);

        Habit habit = habitList.get(index);

        //change the habit_string_text textview to the habitMessage
        String habitMessage = habit.getName();
        TextView displayHabit = (TextView) findViewById(R.id.habit_string_text);
        displayHabit.setText(habitMessage);

        //change the date_string_text textview to the dateCreated
        String dateCreated = habit.getDate();
        TextView displayDate = (TextView) findViewById(R.id.date_string_text);
        displayDate.setText(dateCreated);

        //obtains the days selected and outputs it onto selected_days textview
        DaysSelectedSwitch getDaysToString = new DaysSelectedSwitch(habit.getDaysSelected());
        String daysChosen = getDaysToString.getDaysSelectedString();
        TextView chosenDays = (TextView) findViewById(R.id.selected_days);
        chosenDays.setText(String.valueOf(daysChosen));

        //obtains the lastCompletedDate and displays it
        String lastCompDateText = habit.getLastCompletedDate();
        TextView lastCompDate = (TextView) findViewById(R.id.date_last_completed_text);
        lastCompDate.setText(lastCompDateText);

        //obtains completionNumber and sets it into habit_completion_number_text
        Integer completionNumber = habit.getCompletionCount();
        TextView displayCompletion = (TextView) findViewById(R.id.habit_completion_number_text);
        displayCompletion.setText(String.valueOf(completionNumber));
    }
    //An alert dialog pops up to ask if user really wants to delete
    public void deleteHabit(View view){
        AlertDialog.Builder adb = new AlertDialog.Builder(IndividualHabitInfo.this);
        adb.setMessage("Delete \"" + habitList.get(index).toString() + "\"?");
        adb.setCancelable(true);
        adb.setPositiveButton("Confirm", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i){
                Habit habit = habitList.get(index);
                HabitListController.getHabitList().removeHabit(habit);
                finish();
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Do nothing
            }
        });
        adb.show();
    }

    //An alert dialog pops up to ask if user wants to confirm a completion
    public void completeHabit(View view){
        AlertDialog.Builder adb = new AlertDialog.Builder(IndividualHabitInfo.this);
        adb.setMessage("Complete habit "+habitList.get(index)+"?");
        adb.setCancelable(true);
        adb.setPositiveButton("Confirm", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i){
                HabitListController hbt = new HabitListController();

                //Updates completionCount and lastCompletedDate
                try {
                    hbt.chooseHabit(index).incrementCompletionCount();
                    hbt.chooseHabit(index).setLastCompletedDate();
                } catch (EmptyHabitListException e) {
                    e.printStackTrace();
                }

                //Obtain completionCount from habit selected
                Integer completionNumber = null;
                try {
                    completionNumber = hbt.chooseHabit(index).getCompletionCount();
                } catch (EmptyHabitListException e) {
                    e.printStackTrace();
                }

                //Obtain lastCompletedDate from habit selected
                String newCompletedDate = null;
                try {
                    newCompletedDate = hbt.chooseHabit(index).getLastCompletedDate();
                } catch (EmptyHabitListException e) {
                    e.printStackTrace();
                }

                //display completionCount on screen as it is incremented
                TextView displayCompletionCount = (TextView) findViewById(R.id.habit_completion_number_text);
                displayCompletionCount.setText(String.valueOf(completionNumber));

                //display lastCompletedDate on screen as it is updated
                TextView displayNewCompletedDate = (TextView) findViewById(R.id.date_last_completed_text);
                displayNewCompletedDate.setText(newCompletedDate);

                //save the data
                hbt.saveHabitList();
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Do nothing
            }
        });
        adb.show();
    }
}
