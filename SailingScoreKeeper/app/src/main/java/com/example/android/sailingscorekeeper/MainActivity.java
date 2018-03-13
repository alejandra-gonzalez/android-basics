package com.example.android.sailingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method stores the teams' names and moves on to the next activity.
     */
    public void getTeamsNames(View view){
        EditText teamA = (EditText) findViewById(R.id.teamAname);
        EditText teamB = (EditText) findViewById(R.id.teamBname);
        String teamAName = teamA.getText().toString();
        String teamBName = teamB.getText().toString();

        if(teamAName.isEmpty()){
            teamAName = "Team A";
        }
        if(teamBName.isEmpty()){
            teamBName = "Team B";
        }

        Intent intent = new Intent(MainActivity.this, ScoreKeeping.class);
        intent.putExtra("teamA", teamAName);
        intent.putExtra("teamB", teamBName);
        startActivity(intent);
    }
}
