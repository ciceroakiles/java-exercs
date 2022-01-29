package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numeroAlvo = (int) ((Math.random() * 50) + 1);
    private EditText edtNumero;
    private Button btnAdivinhar;
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associarElementos();
        btnAdivinhar.setOnClickListener(click -> jogar());
    }

    private void associarElementos() {
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        btnAdivinhar = (Button) findViewById(R.id.btnAdivinhar);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
    }

    private void jogar() {
        int numeroJogado = Integer.parseInt(edtNumero.getText().toString());
        if (numeroJogado > numeroAlvo) txtMessage.setText(R.string.vl_menor);
        if (numeroJogado < numeroAlvo) txtMessage.setText(R.string.vl_maior);
        if (numeroJogado == numeroAlvo) finalizar();
    }

    private void finalizar() {
        Bundle bundle = new Bundle();
        bundle.putInt("num", numeroAlvo);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}