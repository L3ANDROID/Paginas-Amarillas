package com.lmorocho.paginasamarillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lmorocho.paginasamarillas.Adaptador.EmpresasAdapter;
import com.lmorocho.paginasamarillas.Modelo.Empresa;
import com.lmorocho.paginasamarillas.Repositorio.RepositorioEmpresa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.empresas_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.categoria = getIntent().getExtras().getString("category");
        List<Empresa> empresas = RepositorioEmpresa.filtrarEmpresas(categoria);
//        List<Empresa> contacts = RepositorioEmpresa.getEmpresas();

        EmpresasAdapter adapter = new EmpresasAdapter(this);

        adapter.setEmpresas(empresas);

        recyclerView.setAdapter(adapter);
    }
}
