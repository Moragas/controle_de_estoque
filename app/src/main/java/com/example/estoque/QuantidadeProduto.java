package com.example.estoque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuantidadeProduto extends AppCompatActivity {

    // Declara as variaveis globais
    private TextView qtdeProd;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_produto);

        //Define o titulo da pagina
        setTitle("Quantidade de Produtos");

        // Inicializa as varaiaveis
        qtdeProd = findViewById(R.id.qtde_produtos);
        btnVoltar = findViewById(R.id.btn_voltar5);

        //Botao voltar que encerra a view atual e volta a tela inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Passando o valor de quantidade (int) para String e mostrando na tela
        qtdeProd.setText(String.valueOf(InsereProdutos.lista.getQuantidade()));
    }
}