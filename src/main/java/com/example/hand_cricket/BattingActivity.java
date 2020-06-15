package com.example.hand_cricket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class BattingActivity extends AppCompatActivity implements View.OnClickListener {
    String name = MainActivity.username;
    int flag=0,count=0;
    static int myscore=0;
    Button btn1,btn2,btn3,btn4,btn6,after_batting_buuton;
    TextView sysbowltxt,myscoretxt,userbowledtxt,bowlsleftforbattingtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batting);

        Intent inte = getIntent();
        flag = inte.getIntExtra("FlagValue",0);

        if(flag==3)
        {
            Intent interes = new Intent(BattingActivity.this, ResultActivity.class);
            startActivity(interes);
        }
        else
        {

            sysbowltxt = (TextView)findViewById(R.id.sys_bowl);
            myscoretxt = (TextView)findViewById(R.id.my_score);
            myscoretxt.setText(""+name+" score is 0");
            userbowledtxt = (TextView)findViewById(R.id.userbowled);
            bowlsleftforbattingtxt =(TextView)findViewById(R.id.bowlsleftforbatting);
            btn1 = (Button)findViewById(R.id.bat1);
            btn2 = (Button)findViewById(R.id.bat2);
            btn3 = (Button)findViewById(R.id.bat3);
            btn4 = (Button)findViewById(R.id.bat4);
            btn6 = (Button)findViewById(R.id.bat6);
            after_batting_buuton = (Button)findViewById(R.id.afterbatting);
            after_batting_buuton.setVisibility(View.INVISIBLE);
            after_batting_buuton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intebowl = new Intent(BattingActivity.this,BowlingActivity.class);
                    intebowl.putExtra("FlagValue",flag+1);
                    startActivity(intebowl);
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
        Random r= new Random();
        int sysbowlrun = r.nextInt(5);
        sysbowlrun+=1;
        if(sysbowlrun==5)
        {
            sysbowlrun+=1;
            sysbowltxt.setText("System bowled : "+sysbowlrun);
        }
        else
            sysbowltxt.setText("System bowled : "+sysbowlrun);

        int bowlsleftint=6-count;
        bowlsleftforbattingtxt.setText("Bowls left : "+bowlsleftint);

        switch (v.getId()){
            case R.id.bat1:
                if(sysbowlrun==1)
                {
                    userbowledtxt.setText("YOU ARE OUT");
                }
                else
                {
                  myscore+=1;
                  myscoretxt.setText(""+name+" score is "+myscore);
                }
                break;
            case R.id.bat2:
                if(sysbowlrun==2)
                {
                    userbowledtxt.setText("YOU ARE OUT");
                }
                else
                {
                    myscore+=2;
                    myscoretxt.setText(""+name+" score is "+myscore);
                }
                break;
            case R.id.bat3:
                if(sysbowlrun==3)
                {
                    userbowledtxt.setText("YOU ARE OUT");
                }
                else
                {
                    myscore+=3;
                    myscoretxt.setText("Your score is "+myscore);
                }
                break;
            case R.id.bat4:
                if(sysbowlrun==4)
                {
                    userbowledtxt.setText("YOU ARE OUT");
                }
                else
                {
                    myscore+=4;
                    myscoretxt.setText(""+name+" score is "+myscore);
                }
                break;
            case R.id.bat6:
                if(sysbowlrun==6)
                {
                    userbowledtxt.setText("YOU ARE OUT");
                }
                else
                {
                    myscore+=6;
                    myscoretxt.setText(""+name+" score is "+myscore);
                }
                break;


        }
        userbowledtxt.setTextColor(Color.WHITE);
        if(count==6)
            userbowledtxt.setText("Over is up");
        if(count==6 || userbowledtxt.getText().equals("YOU ARE OUT"))
        {
            Intent interesscore = new Intent(BattingActivity.this,ResultActivity.class);;
            interesscore.putExtra("Myscore",myscore);
            after_batting_buuton.setVisibility(View.VISIBLE);
            myscoretxt.setTextColor(Color.WHITE);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn6.setEnabled(false);
//
//            Intent intebowl = new Intent(BattingActivity.this,BowlingActivity.class);
//            intebowl.putExtra("FlagValue",flag+1);
//            startActivity(intebowl);
        }
    }
}
