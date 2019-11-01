package com.example.dame_jalon;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class recuperar extends AppCompatActivity {

    Button BtnRecuperar;
    EditText editTextDirección2;
    EditText ediTextTelefono2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        BtnRecuperar = findViewById(R.id.btnRecuperar);
        editTextDirección2 = findViewById(R.id.editTextDirección2);
        ediTextTelefono2 = findViewById(R.id.ediTextTelefono2);
        Context cont;

        BtnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    PreparedStatement pst = conexionBD().prepareStatement("UPDATE usuario SET direccion="+editTextDirección2.getText().toString()+", telefono='"+Integer.parseInt(ediTextTelefono2.getText().toString())+"'WHERE carne="+usuario.getCarne());
                    pst.executeUpdate();
                    Toast.makeText(recuperar.this, "SI SE PUDO", Toast.LENGTH_LONG).show();


                }catch (Exception e) {

                    Toast.makeText(recuperar.this, "NO SE PUDO", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public static Connection conexionBD(){
        Connection conexion = null;
        String host = "192.168.1.38";
        String port = "3306";
        String dbName = "damejalon";
        String userName = "root";
        String password = "admon";
        try{

            StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);

        }catch (Exception e) {
            Log.d("Error", e.getMessage());
        }
        return conexion;
}}
