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

public class verNotificaciones extends AppCompatActivity {

    List<notificacion> ListaNotificaciones;
    RecyclerView recyclerView;
    Connection conexionMySql = null;
    private Statement st = null;
    private ResultSet rs = null;
    private notificacion columnas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notificaciones);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListaNotificaciones = new ArrayList<>();

        cargarNotificaciones();

    }

    public Connection conexionBD(){
        Connection conexion = null;
        String host = "172.24.5.71";
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
    private void cargarNotificaciones(){

        try{
            String sql = "SELECT notificacion.idNotificacion, notificacion.carneReceptor, usuario.nombre, usuario.apellido, usuario.email, usuario.telefono, notificacion.carneCreador, notificacion.estado FROM notificacion, usuario WHERE  notificacion.carneCreador = usuario.carne AND notificacion.estado = 1 AND notificacion.carneReceptor ="+usuario.getCarne();
            st = conexionBD().createStatement();
            rs = st.executeQuery(sql);
            if(rs.first())
            {
                do
                {

                    ListaNotificaciones.add(new notificacion(
                            rs.getInt("idNotificacion"),
                            usuario.getCarne(),
                            rs.getInt("carneCreador"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("email"),
                            rs.getString("telefono"),
                            rs.getInt("estado")));
                }while(rs.next());
            }

            AdaptadorVistaNotifiaciones adapter = new AdaptadorVistaNotifiaciones(verNotificaciones.this, ListaNotificaciones);
            recyclerView.setAdapter(adapter);
        } catch (SQLException ex) {
            Log.d("Error", ex.getMessage());
        }

    }
}
