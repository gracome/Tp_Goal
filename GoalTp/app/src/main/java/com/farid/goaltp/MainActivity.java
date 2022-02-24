package com.farid.goaltp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UnGoal> GoalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GoalList.add(new UnGoal("Jour 1", "Pompes",
                "push"));
        GoalList.add(new UnGoal("Jour 2", "Dips",
                "dips"));
        GoalList.add(new UnGoal("Jour 3", "Kickback",
                "kick"));
        GoalList.add(new UnGoal("Jour 4", "Fentes avec halteres",
                "fentealtere"));
        GoalList.add(new UnGoal("Jour 5", "Soulever de terre jambes tendues",
                "soulevehaltere"));
        GoalList.add(new UnGoal("Jour 6", "Elevation des mollets",
                "elevationmollet"));
        GoalList.add(new UnGoal("Jour 7", "Curl concentré",
                "curlconcentre"));
        GoalList.add(new UnGoal("Jour 8", "Curl alterné",
                "curlalterner"));
        GoalList.add(new UnGoal("Jour 9", "pullover",
                "pullover"));
        GoalList.add(new UnGoal("Jour 10", "Elevation latérales",
                "elevationlat"));
        GoalList.add(new UnGoal("Jour 11", "Shrugs",
                "shrugs"));
        GoalList.add(new UnGoal("Jour 12", "Rowing haltère",
                "rowing"));
        GoalList.add(new UnGoal("Jour 13", "crunch",
                "crunch"));

        ListView shopList = findViewById(R.id.maListePoints);
        shopList.setAdapter(new UnGoalAdapter(this,GoalList));
    }
}