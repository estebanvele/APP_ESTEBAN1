package com.app_esteban;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Tag = "Prueba";
    EditText user;
    EditText clave;
    Button btn1,btn2,btn3,btn4;


    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Tag, "ESTOY EN onResume");
        setContentView(R.layout.activity_main);

        titulo = findViewById(R.id.titulo);
        user = findViewById(R.id.user);
        clave = findViewById(R.id.clave);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);



        btn1.setOnClickListener(view -> {
                    String Usuario = user.getText().toString();
                    String Contrasena = clave.getText().toString();

                    if (Usuario.isEmpty() || Contrasena.isEmpty()) {
                        Toast.makeText(MainActivity.this, "user o clave vacíos", Toast.LENGTH_SHORT).show();
                    } else {
                        if (Usuario.equals("Admin") && Contrasena.equals("123")) {
                            Intent intent = new Intent(MainActivity.this, PantallaDos.class);
                            intent.putExtra("user", Usuario);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "user o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                titulo.setText("PRESIONASTE EL BOTON REGISTRAR");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarm("WAKE UP ", 8 ,30);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarm("WAKE UP ", 8 ,30);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeEmail("pedro@gmail.com", "help");

            }
        });
    }
    protected void onResume() {
        super.onResume();
        titulo.setText("BIENVENIDO AL LOGIN");
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void composeEmail(String addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}