package com.example.hand_cricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class TossActivity extends AppCompatActivity implements View.OnClickListener {

    String player_name;
    Button head_button,tail_button,next_button;
    TextView sys,res;
    Intent inte2=null;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);


         sys = (TextView)findViewById(R.id.sys_choose);
         res =  (TextView)findViewById(R.id.toss_result);

         head_button = (Button)findViewById(R.id.heads);
         head_button.setOnClickListener(this);

        tail_button = (Button)findViewById(R.id.tails);
        tail_button.setOnClickListener(this);

        next_button =(Button)findViewById(R.id.next_choose);
        next_button.setVisibility(View.INVISIBLE);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(res.getText().equals("You WON the toss")){
                    inte2 = new Intent(TossActivity.this,ChooseActivity.class);
                    inte2.putExtra("player_name",player_name);
                    inte2.putExtra("FlagValue",flag);
                    startActivity(inte2);
                }
                else
                {
                    inte2 =new Intent(TossActivity.this,BattingActivity.class);
                    inte2.putExtra("FlagValue",flag+1);
                    startActivity(inte2);

                }
            }
        });




    }

    @Override
    public void onClick(View v) {
        Random obj = new Random();
        int rand = obj.nextInt(2);
        int toss_val=0;

        if(rand==0)
            sys.setText("It is Heads");
        else
            sys.setText("It is Tails");

        switch (v.getId())
        {
            case R.id.heads :
                toss_val = 0;
                break;
            case R.id.tails:
                toss_val = 1;
                break;
        }

        if(toss_val==rand)
            res.setText("You WON the toss");
        else
            res.setText("You LOST the toss");

        head_button.setEnabled(false);
        tail_button.setEnabled(false);
        next_button.setVisibility(View.VISIBLE);
    }
}
