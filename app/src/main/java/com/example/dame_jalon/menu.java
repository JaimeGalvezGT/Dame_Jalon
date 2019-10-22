package com.example.dame_jalon;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    ImageButton btnViaja;
    ImageButton btnContactar;
    ImageButton btnperfil;
    ImageButton btnayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnViaja = findViewById(R.id.btnViaja);
        btnContactar = findViewById(R.id.btnContactar);
        btnperfil = findViewById(R.id.perfil);
        btnayuda = findViewById(R.id.ayuda);

        btnViaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegacion1 = new Intent(menu.this, publicar_viaje.class);
                startActivity(navegacion1);

            }
        });

        btnContactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegacion2 = new Intent(menu.this, verJalones.class);
                startActivity(navegacion2);

            }
        });

        btnperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegacion3 = new Intent(menu.this, perfil.class);
                startActivity(navegacion3);

            }
        });

        btnayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegacion4 = new Intent(menu.this, contactar.class);
                startActivity(navegacion4);

            }
        });
    }
}
