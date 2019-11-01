package com.example.dame_jalon;

import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;

public class publicar_viaje extends AppCompatActivity {

    Button btnIngresar3;
    Spinner spinner;
    TextView txtmHora;
    Button btnHora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_viaje);

        btnIngresar3 = findViewById(R.id.btnIngresar3);
        spinner = findViewById(R.id.spinner1);
        btnHora = findViewById(R.id.btnhora);
        txtmHora = findViewById(R.id.txtmhora);

        String [] opciones = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_equipos,R.layout.spinner_item_modificar);

        spinner.setAdapter(adapter);

        btnIngresar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarJalon();
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int Hora = c.get(Calendar.HOUR_OF_DAY);
                int minuto = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(publicar_viaje.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        txtmHora.setText(hourOfDay+":"+minute+" "+"HORAS");


                    }
                },Hora,minuto, false);
                timePickerDialog.show();


                timePickerDialog.show();
            }
        });

    }

    public Connection conexionBD(){
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
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public void GuardarJalon(){
        try {

            PreparedStatement pst = conexionBD().prepareStatement("insert into jalon(carneJalon, dia, hora) values(" + usuario.getCarne() + ", '" + spinner.getSelectedItem().toString()+ "', '" + txtmHora.getText().toString() + "')");
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"PEDISTE JALÓN EXITOSAMENTE",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
