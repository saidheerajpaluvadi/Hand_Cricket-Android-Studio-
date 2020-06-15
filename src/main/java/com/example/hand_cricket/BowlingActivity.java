package com.example.hand_cricket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class BowlingActivity extends AppCompatActivity implements View.OnClickListener {

    int flag=0;
    int count=0;
    static int sysscore =0;

    Button btn1,btn2,btn3,btn4,btn6,after_bowlingbutton;
    TextView sysruntxt,resbowled,sysscoretxt,bowlslefttxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowling);


        Intent inte = getIntent();
        flag = inte.getIntExtra("FlagValue",0);

        if(flag==3){
            Intent interes = new Intent(BowlingActivity.this, ResultActivity.class);
            startActivity(interes);
        }
        else
        {
            sysruntxt = (TextView)findViewById(R.id.sys_run);
            //sysruntxt.setText(""+flag);
            resbowled = (TextView)findViewById(R.id.bowled);
            sysscoretxt = (TextView)findViewById(R.id.sys_score);
            bowlslefttxt =(TextView)findViewById(R.id.bowlsleft);
            btn1 = (Button)findViewById(R.id.bowl1);
            btn2 = (Button)findViewById(R.id.bowl2);
            btn3 = (Button)findViewById(R.id.bowl3);
            btn4 = (Button)findViewById(R.id.bowl4);
            btn6 = (Button)findViewById(R.id.bowl6);
            after_bowlingbutton = (Button)findViewById(R.id.afterbowling);
            after_bowlingbutton.setVisibility(View.INVISIBLE);
            after_bowlingbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intebat = new Intent(BowlingActivity.this,BattingActivity.class);
                    intebat.putExtra("FlagValue",flag+1);
                    startActivity(intebat);
                }
            });
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            btn6.setOnClickListener(this);


        }


    }
    @Override
    public void onClick(View v){
        count+=1;
        Random random = new Random();
        int sysrun = random.nextInt(5);
        sysrun+=1;
        if(sysrun ==5) {
            sysrun+=1;
            sysruntxt.setText("System run is : "+sysrun);
        }
        else
            sysruntxt.setText("System run is : "+sysrun);
        int bowlsleftint = 6-count;
        bowlslefttxt.setText("Bowls left : "+bowlsleftint);
        switch (v.getId())
        {
            case R.id.bowl1:
                if(sysrun == 1)
                    resbowled.setText("SYSTEM IS OUT");
                else
                {
                    sysscore+=sysrun;
                    sysscoretxt.setText("System score is "+sysscore);
                }

                break;
            case R.id.bowl2:
                if(sysrun == 2)
                    resbowled.setText("SYSTEM IS OUT");
                else
                {
                    sysscore+=sysrun;
                    sysscoretxt.setText("System score is "+sysscore);
                }

                break;
            case R.id.bowl3:
                if(sysrun == 3)
                    resbowled.setText("SYSTEM IS OUT");
                else
                {
                    sysscore+=sysrun;
                    sysscoretxt.setText("System score is "+sysscore);
                }

                break;
            case R.id.bowl4:
                if(sysrun == 4)
                    resbowled.setText("SYSTEM IS OUT");
                else
                {
                    sysscore+=sysrun;
                    sysscoretxt.setText("System score is "+sysscore);
                }

                break;
            case R.id.bowl6:
                if(sysrun == 6)
                    resbowled.setText("SYSTEM IS OUT");
                else
                {
                    sysscore+=sysrun;
                    sysscoretxt.setText("System score is "+sysscore);
                }

                break;
        }
        resbowled.setTextColor(Color.WHITE);
        if(count==6) {
            resbowled.setText("Over is up");
        }

        if((resbowled.getText().equals("SYSTEM IS OUT") || count==6 ))
        {
            Intent interesscore = new Intent(BowlingActivity.this,ResultActivity.class);;
            interesscore.putExtra("Sysscore",sysscore);
            after_bowlingbutton.setVisibility(View.VISIBLE);
            sysscoretxt.setTextColor(Color.WHITE);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn6.setEnabled(false);
//            Intent intebat = new Intent(BowlingActivity.this,BattingActivity.class);
//            intebat.putExtra("FlagValue",flag+1);
//            startActivity(intebat);
        }
    }
}
