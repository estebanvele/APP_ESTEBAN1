package com.app_esteban;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PantallaDos extends AppCompatActivity {

    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        tvSaludo = findViewById(R.id.tvSaludo);

        String user = getIntent().getStringExtra("user");

        tvSaludo.setText("¡Hola " + user + "!");
    }


}