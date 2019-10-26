package com.example.dame_jalon;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class perfil extends AppCompatActivity {

    public TextView nombre, direccion, telefono;
    Connection conexionMySql = null;
    private Statement st = null;
    private ResultSet rs = null;
    private usuario user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombre= findViewById(R.id.Nombre);
        direccion= findViewById(R.id.Direccion);
        telefono= findViewById(R.id.telefono);

        nombre.setText(usuario.getNombre()+" "+usuario.getApellido());
        direccion.setText(usuario.getDireccion());
        telefono.setText(usuario.getTelefono());

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

    /**public void CargarDatos(){
        try{
            String sql = "select * from usuario where carne="+usuario.getCarne()+"";
            st = conexionBD().createStatement();
            rs = st.executeQuery(sql);
            if(rs.first())
            {
                do
                {

                    user = new usuario(
                            rs.getInt("carne"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getInt("id_rol"),
                            rs.getInt("estado"));
                }while(rs.next());
            }

            nombre.setText(user.getNombre()+" "+user.getApellido());
            direccion.setText(user.getDireccion());
            telefono.setText(user.getTelefono());
        } catch (SQLException ex) {
            Log.d("Error", ex.getMessage());
        }
    }**/
}
