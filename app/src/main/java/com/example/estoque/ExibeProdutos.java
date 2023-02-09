package com.example.estoque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class ExibeProdutos extends AppCompatActivity {

    //Declarando variáveis globais
    public TextView listProd;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_produtos);

        //Define o titulo da pagina
        setTitle("Lista de Produtos");

        // Inicializa as varaiaveis
        btnVoltar = findViewById(R.id.btn_voltar2);
        listProd = findViewById(R.id.list_prod);

        //Botao voltar que encerra a view atual e volta a tela inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Chama o metodo que verifica a lista de produtos e atribui o valor do retorno a variavel listProd
        listProd.setText(InsereProdutos.lista.imprimirLista());
        //Permite o scroll vertical caso a quantidade de produtos ultrapasse o tamanho da tela
        listProd.setMovementMethod(new ScrollingMovementMethod());
    }
}