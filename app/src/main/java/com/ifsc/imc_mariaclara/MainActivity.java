package com.ifsc.imc_mariaclara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nome, peso, altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.Nome);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
    }

    public void calcular(View view){
        double p1 = Double.parseDouble(peso.getText().toString()), a1  = Double.parseDouble(altura.getText().toString()), calc1, calc2, res = 0;
        String Nome  = nome.getText().toString();
        Log.i("test1", "Teste1");
        if (p1 != 0 && a1 != 0) {
            Log.i("test","TesteIF");
            calc1 = a1 / 100;
            calc2 = calc1 * calc1;
            res = p1 / calc2;
        }
        Log.i("test", "Teste depois dp if");
        Intent i =new Intent(this, ImcActivity.class);
        Log.i("test", "Antes do put");
        i.putExtra("nome", Nome);
        i.putExtra("res", res);
        Log.i("test", "Start");
        startActivity(i);
        Log.i("test", "dps start");
    }

    public void clean(View view){
        nome.setText(" ");
        peso.setText("00,00");
        altura.setText("0");
    }
}