package com.example.dame_jalon;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Integer.parseInt;

public class registrar extends AppCompatActivity {

    Button btnIngresar2;
    EditText ediTextCarne;
    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        ediTextCarne = findViewById(R.id.ediTextCarne);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnIngresar2 = findViewById(R.id.btnIngresar2);

        btnIngresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ediTextCarne.getText().toString().isEmpty() && editTextNombre.getText().toString().isEmpty() && editTextApellido.getText().toString().isEmpty() && editTextEmail.getText().toString().isEmpty() && editTextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Todos los campos vacÃ­os, por favor ingrese los datos requeridos", Toast.LENGTH_LONG).show();
                } else {
                    AgregarRegistro();
                    ediTextCarne.setText("");
                    editTextNombre.setText("");
                    editTextApellido.setText("");
                    editTextEmail.setText("");
                    editTextPassword.setText("");


                }


            }
        });

    }


        public void AgregarRegistro(){
            try {
                Conexion conexion = new Conexion();
                PreparedStatement pst = conexion.connect().prepareStatement("insert into usuario(carne,nombre,apellido,email.password) values(?,?,?,?,?)");
                pst.setInt(1, parseInt(ediTextCarne.getText().toString()));
                pst.setString(2, editTextNombre.getText().toString());
                pst.setString(3, editTextApellido.getText().toString());
                pst.setString(4, editTextEmail.getText().toString());
                pst.setString(5, editTextPassword.getText().toString());
                pst.executeUpdate();

                Toast.makeText(getApplicationContext(),"REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
            }catch (Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }



    }



