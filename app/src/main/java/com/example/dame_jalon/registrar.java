package com.example.dame_jalon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class registrar extends AppCompatActivity {

    Button btnIngresar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnIngresar2 = findViewById(R.id.btnIngresar2);

        btnIngresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast msjError = Toast.makeText(getApplicationContext(), "Módulo en Desarrollo", Toast.LENGTH_SHORT);
                msjError.setGravity(Gravity.CENTER, 0, 0);
                msjError.show();
            }
        });
    }
}
