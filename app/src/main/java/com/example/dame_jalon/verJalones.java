package com.example.dame_jalon;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class verJalones extends AppCompatActivity {

    List<Jalon> ListaJalones;
    RecyclerView recyclerView;
    Connection conexionMySql = null;
    private Statement st = null;
    private ResultSet rs = null;
    private Jalon columnas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_jalones);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListaJalones = new ArrayList<>();

        cargarUsuarios();

    }

    public Connection conexionBD(){
        Connection conexion = null;
        String host = "172.24.5.14";
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
    private void cargarUsuarios(){

        try{
            String sql = "SELECT jalon.idJalon, usuario.carne, usuario.nombre, usuario.apellido, usuario.direccion, usuario.telefono, jalon.Dia, jalon.Hora, jalon.estado FROM jalon, usuario WHERE jalon.carneJalon = usuario.carne and jalon.estado = 1 AND usuario.carne!="+usuario.getCarne();
            st = conexionBD().createStatement();
            rs = st.executeQuery(sql);
            if(rs.first())
            {
                do
                {

                    ListaJalones.add(new Jalon(
                            rs.getInt("idJalon"),
                            rs.getInt("carne"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("Dia"),
                            rs.getString("Hora"),
                            rs.getInt("estado")));
                }while(rs.next());
            }

            AdaptadorVistaJalones adapter = new AdaptadorVistaJalones(verJalones.this, ListaJalones);
            recyclerView.setAdapter(adapter);
        } catch (SQLException ex) {
            Log.d("Error", ex.getMessage());
        }

    }
}
