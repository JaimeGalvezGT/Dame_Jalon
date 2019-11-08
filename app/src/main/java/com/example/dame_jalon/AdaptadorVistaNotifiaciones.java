package com.example.dame_jalon;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdaptadorVistaNotifiaciones extends RecyclerView.Adapter<AdaptadorVistaNotifiaciones.MyViewHolder>{
    private Context mycont;
    private List<notificacion> ListaNotificaciones;



    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorVistaNotifiaciones(Context mycont, List<notificacion> ListNotificaciones) {
        this.mycont = mycont;
        this.ListaNotificaciones = ListNotificaciones;

    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView nombre, telefono, email, idNoti;
        public Button eliminar;

        //context
        Context cont;

        public MyViewHolder(View itemView) {
            super(itemView);
            cont = itemView.getContext();
            nombre = itemView.findViewById(R.id.nombre);
            telefono = itemView.findViewById(R.id.telefono);
            email = itemView.findViewById(R.id.email);
            eliminar = itemView.findViewById(R.id.eliminar);
            idNoti = itemView.findViewById(R.id.idNoti);


        }
        void setOnClickListener(){
                eliminar.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            try {
                AlertDialog.Builder alerta = new AlertDialog.Builder(cont);
                alerta.setMessage("¿Desea eliminar la notifiación?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                PreparedStatement pst = null;
                                try {
                                    pst = conexionBD().prepareStatement("UPDATE notificacion SET estado='2' WHERE idNotificacion="+Integer.parseInt(idNoti.getText().toString()));
                                    pst.executeUpdate();
                                    Toast.makeText(cont,"Notificacion Eliminada",Toast.LENGTH_SHORT).show();
                                    ((verNotificaciones)cont).finish();

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    Toast.makeText(cont,"ERROR",Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog titulo = alerta.create();
                titulo.setTitle("Eliminar Notificación");
                titulo.show();



            }catch (Exception e) {
                Toast.makeText(cont,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        view = inflater.inflate(R.layout.activity_lista_notificaciones, null);
        return new MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        notificacion noti = ListaNotificaciones.get(position);

        holder.nombre.setText(noti.getNombreCreador()+noti.getApellidoCreador());
        holder.telefono.setText(noti.getTelefono());
        holder.email.setText(noti.getEmail());
        holder.idNoti.setText(String.valueOf(noti.getIdNotificacion()));
        holder.setOnClickListener();

    }

    public static Connection conexionBD(){
        Connection conexion = null;
        String host = "192.168.1.38";       //CAMBIAR
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
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (ListaNotificaciones != null) {
            return ListaNotificaciones.size();
        } else {
            Toast.makeText(mycont, "Usuario inactivo", Toast.LENGTH_LONG).show();
        }

        return 0;
    }


}


