package com.lmorocho.paginasamarillas.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lmorocho.paginasamarillas.Modelo.Empresa;
import com.lmorocho.paginasamarillas.R;
import com.lmorocho.paginasamarillas.Repositorio.RepositorioEmpresa;

public class detailEmpresaActivity extends AppCompatActivity {

    private static final int CALL_PERMISSION_REQUEST=100;

    private Integer id;

    private ImageView pictureImage;
    private TextView empresaText;
    private TextView direccionText;
    private TextView telefonoText;
    private TextView correoText;
    private TextView infoText;

    private Button button_call;
    private Button button_web;
    private Button button_share;
    private Button button_message;
    private Button button_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_empresa);

        pictureImage = findViewById(R.id.picture_image);
        empresaText = findViewById(R.id.empresa_txt);
        direccionText = findViewById(R.id.direccion_txt);
        correoText = findViewById(R.id.correo_txt);
        telefonoText = findViewById(R.id.numero_txt);
        infoText = findViewById(R.id.info_txt);

        this.id = getIntent().getExtras().getInt("id");

        Empresa empresa = RepositorioEmpresa.getEmpresaById(id);

        if(empresa != null) {
            int resourceid = getResources().getIdentifier(
                    empresa.getPicture(),
                    "drawable",
                    getPackageName()
            );
            pictureImage.setImageResource(resourceid);
            empresaText.setText(empresa.getNombre());
            direccionText.setText(empresa.getDireccion());
            correoText.setText("correo: "+empresa.getCorreo());
            telefonoText.setText("telefono: "+empresa.getTelefono().toString());
            infoText.setText(empresa.getInfo());
        }

        button_call = findViewById(R.id.call_buttton);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarcontacto();
            }
        });
//
//        button_web = findViewById(R.id.web_button);
//        button_web.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buscar();
//            }
//        });
//
        button_share = findViewById(R.id.share_button);
        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        button_message=findViewById(R.id.message_button);
        button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message();
            }
        });

        button_email = findViewById(R.id.email_button);
        button_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email();
            }
        });

    }
    private void email(){
        String email_text = correoText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email_text);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private void message(){
        String number_message = telefonoText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", number_message);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    private void share(){

        String information= infoText.getText().toString();
        String nameshare = empresaText.getText().toString();
        String direction = direccionText.getText().toString();
        String cellphone = telefonoText.getText().toString();
//        String webpage = webtext.getText().toString();
        String emailtext = correoText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,
                "Name : "+nameshare+
                        " Direction : "+direction+
                        " Phone : "+cellphone+
                        " Email : " +emailtext+
                        " Information : "+information);

        startActivity(intent);
    }

    private void llamarcontacto(){
        //Verificar si tengo permiso

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST);
            return;
        }

        String phonenumber=telefonoText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: "+ phonenumber));

        startActivity(intent);
    }
}
