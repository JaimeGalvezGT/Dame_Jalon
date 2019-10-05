package com.example.dame_jalon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class viajar extends AppCompatActivity {

    TextView textView11;
    TextView textView13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajar);

        textView11 = findViewById(R.id.textView11);
        textView13 = findViewById(R.id.textView13);


        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast msjError = Toast.makeText(getApplicationContext(), "Módulo en Desarrollo", Toast.LENGTH_SHORT);
                msjError.setGravity(Gravity.CENTER, 0, 0);
                msjError.show();
            }
        });

        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast msjError = Toast.makeText(getApplicationContext(), "Módulo en Desarrollo", Toast.LENGTH_SHORT);
                msjError.setGravity(Gravity.CENTER, 0, 0);
                msjError.show();
            }
        });
    }
}
