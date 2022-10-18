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
        final TextView output = findViewById(R.id.OutputBottom);
        final Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                output.setText(userInput_00.getText());
            }
        });
    }
}