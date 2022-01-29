package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button btnVoltar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        associarElementos();
        lerNumero();
        btnVoltar.setOnClickListener(click -> voltar());
    }

    private void associarElementos() {
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    private void lerNumero() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int num = bundle.getInt("num");
        txtResultado.setText(getString(R.string.res) + " " + num);
    }

    private void voltar() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}