package com.example.android.sailingscorekeeper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreKeeping extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    TextView textViewA;
    TextView textViewB;
    TextView teamAScore;
    TextView teamBScore;

    /**
     * Places team names in the right TextViews and "Tie with " Buttons
     * @param savedInstanceState Bundle containing team names
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_keeping);

        textViewA = (TextView) findViewById(R.id.team_a_name);
        textViewB = (TextView) findViewById(R.id.team_b_name);
        teamAScore = (TextView) findViewById(R.id.team_a_score);
        teamBScore = (TextView) findViewById(R.id.team_b_score);

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

    /**
     * This method adds 1 point to the score of the team that called this method,
     * and 2 points to the score of the other team. Then the scores are displayed.
     * @param view The view that called this method
     */
    public void firstPlace(View view){
        switch(view.getId()){
            case R.id.team_a_first:
                scoreTeamA += 1;
                scoreTeamB += 2;
                break;
            case R.id.team_b_first:
                scoreTeamA += 2;
                scoreTeamB += 1;
                break;
        }
        displayScore();
    }

    /**
     * This method adds 2 points to the score of the team that called this method,
     * and 1 point to the score of the other team. Then the scores are displayed.
     * @param view The view that called this method
     */
    public void secondPlace(View view){
        switch(view.getId()){
            case R.id.team_a_second:
                scoreTeamA += 2;
                scoreTeamB += 1;
                break;
            case R.id.team_b_second:
                scoreTeamA += 1;
                scoreTeamB += 2;
                break;
        }
        displayScore();
    }

    /**
     * This method adds 1 point to the score of both teams.
     * Then the scores are displayed.
     * @param view The view that called this method
     */
    public void tied(View view){
        scoreTeamA += 1;
        scoreTeamB += 1;
        displayScore();
    }

    /**
     * Displays the score for both teams.
     */
    public void displayScore(){
        teamAScore.setText(String.valueOf(scoreTeamA));
        teamBScore.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Sets the scores of the current teams to 0.
     */
    public void resetGame(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        textViewA.setTextColor(Color.parseColor("#616161"));
        teamAScore.setTextColor(Color.parseColor("#616161"));
        textViewB.setTextColor(Color.parseColor("#616161"));
        teamBScore.setTextColor(Color.parseColor("#616161"));
        displayScore();
    }

    /**
     * The current winner's name and score are shown in blue text.
     */
    public void showWinner(View view){
        if (scoreTeamA < scoreTeamB){
            textViewA.setTextColor(Color.parseColor("#0645AD"));
            teamAScore.setTextColor(Color.parseColor("#0645AD"));
            textViewB.setTextColor(Color.parseColor("#616161"));
            teamBScore.setTextColor(Color.parseColor("#616161"));
        }
        else if(scoreTeamB < scoreTeamA){
            textViewB.setTextColor(Color.parseColor("#0645AD"));
            teamBScore.setTextColor(Color.parseColor("#0645AD"));
            textViewA.setTextColor(Color.parseColor("#616161"));
            teamAScore.setTextColor(Color.parseColor("#616161"));
        }
        else {
            textViewA.setTextColor(Color.parseColor("#0645AD"));
            teamAScore.setTextColor(Color.parseColor("#0645AD"));
            textViewB.setTextColor(Color.parseColor("#0645AD"));
            teamBScore.setTextColor(Color.parseColor("#0645AD"));
        }
    }
}
