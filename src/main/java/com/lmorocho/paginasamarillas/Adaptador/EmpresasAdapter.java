package com.lmorocho.paginasamarillas.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lmorocho.paginasamarillas.Modelo.Empresa;
import com.lmorocho.paginasamarillas.R;
import com.lmorocho.paginasamarillas.activities.detailEmpresaActivity;

import java.util.ArrayList;
import java.util.List;

public class EmpresasAdapter extends RecyclerView.Adapter<EmpresasAdapter.ViewHolder>  {

    private static final String TAG = EmpresasAdapter.class.getSimpleName();

    private AppCompatActivity activity;
    private List<Empresa> empresas;

    public EmpresasAdapter(AppCompatActivity activity){
        this.activity = activity;
        empresas = new ArrayList<>();
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empresa, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Empresa empresa = this.empresas.get(position);

        viewHolder.nombre.setText(empresa.getNombre());
        viewHolder.direccion.setText(empresa.getDireccion());
        viewHolder.telefono.setText(empresa.getTelefono().toString());

        Context context = viewHolder.itemView.getContext();
        int resourceid = context.getResources().getIdentifier(
                empresa.getPicture(),
                "drawable",
                context.getPackageName()
        );
        viewHolder.picture.setImageResource(resourceid);

        // Definiendo el evento onclick
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + empresa);

                Intent intent = new Intent(v.getContext(), detailEmpresaActivity.class);
                intent.putExtra("id", empresa.getId());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.empresas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView picture;
        TextView nombre;
        TextView direccion;
        TextView telefono;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.picture_image);
            nombre = itemView.findViewById(R.id.empresa_text);
            direccion = itemView.findViewById(R.id.direccion_text);
            telefono = itemView.findViewById(R.id.telefono_text);
        }
    }

}
