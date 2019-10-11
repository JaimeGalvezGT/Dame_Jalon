package com.example.dame_jalon;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends AsyncTask<usuario, Void, usuario> {
    //Connection conexionMySql = null;
    private Connection conn;
    private Statement st = null;
    private ResultSet rs = null;
    private usuario columnas = null;

    @Override
    protected usuario doInBackground(usuario... datos) {
        String sql = "select carne, nombre, apellido, email, password, id_rol, estado from usuario where email = '"+datos[0].getEmail()+"' and password = '"+datos[0].getPassword() + "'";
        /*String host = "192.168.1.3";
        String port = "3306";
        String dbName = "damejalon";
        String userName = "root";
        String password = "admon";

         */
        try{
            //conexionMySql = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);

            //st = conexionMySql.createStatement();
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.first())
            {
                do
                {

                    columnas = new usuario(rs.getInt("carne"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("password"), rs.getInt("id_rol"), rs.getInt("estado"));
                }while(rs.next());
            }
        } catch (SQLException ex) {
            Log.d("Error", ex.getMessage());
        }
        finally
        {
            try
            {
                if (conn!=null) {
                    st.close();
                    rs.close();
                    conn.close();
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return columnas;
    }
}
