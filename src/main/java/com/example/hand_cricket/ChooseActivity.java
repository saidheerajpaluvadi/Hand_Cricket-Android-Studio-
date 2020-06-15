package com.example.hand_cricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button bat,bowl;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Intent inte = getIntent();
         flag = inte.getIntExtra("FlagValue",0);
        bat = (Button)findViewById(R.id.Batting);
        bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(ChooseActivity.this,BattingActivity.class);
                flag+=1;
                inte.putExtra("FlagValue",flag);
                startActivity(inte);
            }
        });

        bowl = (Button)findViewById(R.id.Bowling);
        bowl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(ChooseActivity.this,BowlingActivity.class);
                flag+=1;
                inte.putExtra("FlagValue",flag);
                startActivity(inte);
            }
        });
    }
}
