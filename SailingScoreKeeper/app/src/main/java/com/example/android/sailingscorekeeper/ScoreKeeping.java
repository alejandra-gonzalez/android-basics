package com.example.android.sailingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ScoreKeeping extends AppCompatActivity {

    /**
     * Places team names in the right TextViews and Buttons
     * @param savedInstanceState Bundle containing team names
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_keeping);

        TextView textViewA = (TextView) findViewById(R.id.team_a_name);
        TextView textViewB = (TextView) findViewById(R.id.team_b_name);

        Button aTieButton = (Button) findViewById(R.id.team_a_tie);
        Button bTieButton = (Button) findViewById(R.id.team_b_tie);

        Intent intent = getIntent();
        String textViewALabel = intent.getStringExtra("teamA");
        String textViewBLabel = intent.getStringExtra("teamB");
        textViewA.setText(textViewALabel);
        textViewB.setText(textViewBLabel);

        aTieButton.setText("Tie with "+textViewALabel);
        bTieButton.setText("Tie with "+textViewBLabel);
    }
}
