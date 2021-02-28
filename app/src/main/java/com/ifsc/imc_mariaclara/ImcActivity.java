package com.ifsc.imc_mariaclara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class ImcActivity extends AppCompatActivity {
    TextView result;
    String resultado, fim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        result = findViewById(R.id.result);
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");
        Double res = bundle.getDouble("res");
        this.calc(nome, res);
    }

    public void calc (String nome, Double res){
        if (res == 0){
            resultado = "Você não informou os dados";
        } else if (res < 18.5){
            resultado = ", Você esta: Abaixo do peso, com o IMC de : ";
        } else if (res >= 18.5 && res <=24.9){
            resultado = ", Você esta: Normal, com o IMC de : ";
        } else if (res >= 25 && res <=29.9){
            resultado = ", Você esta: Com sobrepeso, com o IMC de : ";
        } else if (res >= 30 && res <=39.9){
            resultado = ", Você esta: Com obesidade, com o IMC de : ";
        } else {
            resultado = ", Você esta: Com obesidade grave, com o IMC de : ";
        }

        Log.i("test1", resultado);
        fim = "Olá " + nome.concat(resultado).concat(res.toString());
        result.setText(fim);
    }

    public void voltar(View view) {
        Intent i =new Intent(this, MainActivity.class);
        startActivity(i);
    }
}