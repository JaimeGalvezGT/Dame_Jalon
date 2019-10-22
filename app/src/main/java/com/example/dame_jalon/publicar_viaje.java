package com.example.dame_jalon;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class publicar_viaje extends AppCompatActivity {

    Button btnIngresar3;
    EditText Dia, Hora;
    private Connection conn;
    private Statement st = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_viaje);

        btnIngresar3 = findViewById(R.id.btnIngresar3);
        Dia= findViewById(R.id.dia);
        Hora = findViewById(R.id.hora);

        btnIngresar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarJalon();
                Dia.setText("");
                Hora.setText("");
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

    public void GuardarJalon(){
        try {

            PreparedStatement pst = conexionBD().prepareStatement("insert into jalon(carneJalon, dia, hora) values(" + usuario.getCarne() + ", '" + Dia.getText().toString()+ "', '" + Hora.getText().toString() + "')");
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"PEDISTE JALÓN EXITOSAMENTE",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
