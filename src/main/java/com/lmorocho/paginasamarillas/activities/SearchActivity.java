package com.lmorocho.paginasamarillas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lmorocho.paginasamarillas.MainActivity;
import com.lmorocho.paginasamarillas.R;

public class SearchActivity extends AppCompatActivity {

    private EditText buscador;
    private Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        buscador = findViewById(R.id.text_search);
        buscar = findViewById(R.id.button_search);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    private void search(){
        String category = buscador.getText().toString().trim();

        if(!category.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);

            intent.putExtra("category", category);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Ingrese una categoria", Toast.LENGTH_SHORT).show();
        }
    }
}
