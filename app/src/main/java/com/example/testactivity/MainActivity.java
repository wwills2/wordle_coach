package com.example.testactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userInput_00 = findViewById(R.id.gridInput_00);
        final Button button1 = findViewById(R.id.gridColor_00);
        int button1ColorVal = 0;
        final Button button2 = findViewById(R.id.gridColor_01);
        final Button button3 = findViewById(R.id.gridColor_02);
        final Button button4 = findViewById(R.id.gridColor_03);
        final Button button5 = findViewById(R.id.gridColor_04);



        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //this.turn = 2;
            }
        });
    }
}
