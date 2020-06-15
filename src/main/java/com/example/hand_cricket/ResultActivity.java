package com.example.hand_cricket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String username = MainActivity.username;
        int sysscore = BowlingActivity.sysscore;
        int userscore = BattingActivity.myscore;
        TextView gamerestxt = (TextView)findViewById(R.id.game_res);
        TextView sysscoretxt = (TextView)findViewById(R.id.sys_scored_runs);
        TextView userscoretxt = (TextView)findViewById(R.id.user_scored_runs);
        Button playagainbutton = (Button)findViewById(R.id.playagain);
        playagainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this,TossActivity.class));
            }
        });

        sysscoretxt.setText("System score is : "+sysscore);
        userscoretxt.setText("Your score is : "+userscore);
        if(sysscore > userscore) {
            gamerestxt.setTextColor(Color.RED);
            gamerestxt.setText("" + username + " lost the game");
        }
        else if(sysscore == userscore) {
            gamerestxt.setTextColor(Color.WHITE);
            gamerestxt.setText("GAME IS DRAW");
        }
        else {
            gamerestxt.setTextColor(Color.GREEN);
            gamerestxt.setText("" + username + " won the game");
        }

        BowlingActivity.sysscore =0;
        BattingActivity.myscore=0;
    }
}
