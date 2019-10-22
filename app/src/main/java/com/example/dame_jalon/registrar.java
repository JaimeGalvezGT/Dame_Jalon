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
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Integer.parseInt;

public class registrar extends AppCompatActivity {

    Button btnIngresar2;
    EditText editTextCarne;
    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextDireccion;
    EditText editTextTelefono;
    private Connection conn;
    private Statement st = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        editTextCarne = findViewById(R.id.ediTextCarne);
        editTextNombre = findViewById(R.id.editTextNombre2);
        editTextApellido = findViewById(R.id.editTextApellido2);
        editTextEmail = findViewById(R.id.editTextEmail2);
        editTextPassword = findViewById(R.id.txtPassword4);
        editTextDireccion = findViewById(R.id.editTextDirección);
        editTextTelefono = findViewById(R.id.ediTextTelefono);
        btnIngresar2 = findViewById(R.id.btnIngresar2);

        btnIngresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextCarne.getText().toString().isEmpty() && editTextNombre.getText().toString().isEmpty() && editTextApellido.getText().toString().isEmpty() && editTextEmail.getText().toString().isEmpty() && editTextPassword.getText().toString().isEmpty() && editTextDireccion.getText().toString().isEmpty() && editTextDireccion.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Todos los campos vacÃ­os, por favor ingrese los datos requeridos", Toast.LENGTH_LONG).show();
                } else {
                    AgregarRegistro();
                    editTextCarne.setText("");
                    editTextNombre.setText("");
                    editTextApellido.setText("");
                    editTextEmail.setText("");
                    editTextPassword.setText("");
                    editTextDireccion.setText("");
                    editTextTelefono.setText("");


                }


            }
        });

    }
    public Connection conexionBD(){
        Connection conexion = null;
        String host = "192.168.1.27";
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
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }


    public void AgregarRegistro(){
        try {

            PreparedStatement pst = conexionBD().prepareStatement("insert into usuario(carne, nombre, apellido, email, password, direccion, telefono, id_rol, estado ) values(" + Integer.parseInt(editTextCarne.getText().toString()) + ", '" + editTextNombre.getText().toString()+ "', '" + editTextApellido.getText().toString() + "', '" +  editTextEmail.getText().toString() + "', '" +  editTextPassword.getText().toString()+ "', '" +  editTextDireccion.getText().toString()+ "', " +  Integer.parseInt(editTextTelefono.getText().toString()) + ", 1, 1)");
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }




}



