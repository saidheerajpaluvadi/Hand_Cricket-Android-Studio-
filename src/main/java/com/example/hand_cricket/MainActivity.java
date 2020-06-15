package com.example.hand_cricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static String username="";
    EditText name;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.player_name);

        play = (Button)findViewById(R.id.play_button);
        play.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        username = name.getText().toString();
        Intent inte = new Intent(MainActivity.this,TossActivity.class);
        startActivity(inte);

    }
}
