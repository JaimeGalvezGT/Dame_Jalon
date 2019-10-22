package com.example.dame_jalon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView nombre,direccion, telefono, dia, hora;

        public MyViewHolder(View itemView){
            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
            direccion = itemView.findViewById(R.id.direccion);
            telefono = itemView.findViewById(R.id.telefono);
            dia = itemView.findViewById(R.id.dia);
            hora = itemView.findViewById(R.id.hora);
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


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ListaJalones.size();
    }



}

