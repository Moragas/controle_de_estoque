package com.example.estoque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EstoqueMinimo extends AppCompatActivity {

    //Declarando variáveis globais
    private TextView minEst;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque_minimo);

        //Define o titulo da pagina
        setTitle("Produtos Abaixo do Estoque");

        // Inicializa as varaiaveis
        minEst = findViewById(R.id.prodEstMin);
        btnVoltar = findViewById(R.id.btn_voltar7);

        //Botao voltar que encerra a view atual e volta a tela inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Chama o metodo que verifica os produtos que estao abaixo do estoque e atribui o valor do retorno a variavel minEst
        minEst.setText(InsereProdutos.lista.prodEstoqueMin());
        //Permite o scroll vertical caso a quantidade de produtos ultrapasse o tamanho da tela
        minEst.setMovementMethod(new ScrollingMovementMethod());
    }
}