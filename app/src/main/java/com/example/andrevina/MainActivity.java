package com.example.andrevina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        Integer number = random.nextInt(99)+1;

        final Button button = findViewById(R.id.buttonTry);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Context context = getApplicationContext();
                final EditText textNumber = findViewById(R.id.editText);
                CharSequence text = "";
                if (number == Integer.parseInt(textNumber.getText().toString())){
                    text = "You Win";
                }else if (number > Integer.parseInt(textNumber.getText().toString())){
                    text = "Te has quedado corto!!";
                } else{
                    text = "Has pasado de largo!!";
                }
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}