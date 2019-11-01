package com.example.dame_jalon;

import android.app.IntentService;
import android.content.Context;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

class AdaptadorVistaJalones extends RecyclerView.Adapter<AdaptadorVistaJalones.MyViewHolder> {

    private Context mycont;
    private List<Jalon> ListaJalones;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorVistaJalones(Context mycont, List<Jalon> listaJalones) {
        this.mycont = mycont;
        this.ListaJalones = listaJalones;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case

        public TextView nombre,direccion, telefono, dia, hora, carne;
        public Button darjalon;
        //context
        Context cont;

        public MyViewHolder(View itemView){
            super(itemView);
            cont = itemView.getContext();
            nombre = itemView.findViewById(R.id.nombre);
            direccion = itemView.findViewById(R.id.direccion);
            telefono = itemView.findViewById(R.id.telefono);
            dia = itemView.findViewById(R.id.email);
            hora = itemView.findViewById(R.id.hora);
            darjalon = itemView.findViewById(R.id.btndarjalon);
            carne = itemView.findViewById(R.id.carne);
        }
        void setOnClickListener(){
            darjalon.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            try {

                PreparedStatement pst = conexionBD().prepareStatement("INSERT INTO notificacion (carneReceptor, carneCreador) VALUES ("+ Integer.parseInt(carne.getText().toString())+", "+usuario.getCarne()+")");
                pst.executeUpdate();

                Toast.makeText(cont,"Se le notificara a tu amigo",Toast.LENGTH_SHORT).show();
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
            view = inflater.inflate(R.layout.activity_lista_jalones, null);

            return new MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Jalon jalon = ListaJalones.get(position);


        holder.nombre.setText(""+jalon.getNombre()+" "+jalon.getApellido());
        holder.direccion.setText(jalon.getDireccion());
        holder.telefono.setText(jalon.getTelefono());
        holder.dia.setText(jalon.getDia());
        holder.hora.setText(jalon.getHora());
        holder.carne.setText(String.valueOf(jalon.getCarne()));
        holder.setOnClickListener();

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
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ListaJalones.size();
    }



}

