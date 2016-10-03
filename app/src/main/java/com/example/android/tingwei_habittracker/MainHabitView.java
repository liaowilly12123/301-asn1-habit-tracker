/*
HabitTracker: Saves and allows completion of habit added by the user
Copyright (C) 2016 Ting-Wei (Willy) Liao tingwei@ualberta.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
        */


package com.example.android.tingwei_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainHabitView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_habit_view);

        HabitListManager.initManager(this.getApplicationContext());

        //display the items in Habits List onto the listview
        final ListView theHabitsList = (ListView) findViewById(R.id.habit_list_view);
        Collection<Habit> habits = HabitListController.getHabitList().getHabits();
        final ArrayList<Habit> habitList = new ArrayList<Habit>(habits);
        final ArrayAdapter<Habit> habitAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, habitList);
        theHabitsList.setAdapter(habitAdapter);

        // Updates the listView so if something is added and deleted it has the
            // updated items
        HabitListController.getHabitList().addListener(new Listener() {
            @Override
            public void update() {
                habitList.clear();
                Collection<Habit> habits = HabitListController.getHabitList().getHabits();
                habitList.addAll(habits);
                habitAdapter.notifyDataSetChanged();
            }
        });

        // if an item in the listView is touched, it will go to a new activity and
        // send the habitList along with the index of the item touched to it
        theHabitsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainHabitView.this, IndividualHabitInfo.class);
                intent.putExtra("habitList", habitList);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
    }

    public void goToAddHabit(View view){
        Intent intent = new Intent(MainHabitView.this, addHabitPage.class);
        startActivity(intent);

    }

    public void goToHistoryLog(View view){
        Toast.makeText(MainHabitView.this, "Under Construction.", Toast.LENGTH_SHORT).show();
    }
}
