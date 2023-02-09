package com.example.estoque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    //Declarando variáveis globais
    private Button insereIni;
    private Button insereFim;
    private Button localizaProd;
    private Button excluiProd;
    private Button imprimeList;
    private Button qtdeProd;
    private Button ajuda;
    private Button estMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Menu do Estoque");

        //Inicializando as variáveis
        insereIni = findViewById(R.id.insert_ini);
        insereFim = findViewById(R.id.insert_fim);
        localizaProd = findViewById(R.id.localiza_prod);
        excluiProd = findViewById(R.id.exclude_prod);
        imprimeList = findViewById(R.id.print_list);
        qtdeProd = findViewById(R.id.qtde_prod);
        ajuda = findViewById(R.id.btn_ajuda);
        estMin = findViewById(R.id.btn_estMin);

        //Atribuindo a chamada de uma nova tela a um botao atraves do clique (abaixo uma atribuicao para cada botao do menu)
        insereIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insereProd = new Intent(getApplicationContext(), InsereProdutos.class);
                //Na chamada da tela, envia um parametro chamado local que recebe o valor de inicio
                insereProd.putExtra("Local", "Inicio");
                startActivity(insereProd);
            }
        });

        insereFim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insereProd = new Intent(getApplicationContext(), InsereProdutos.class);
                //Na chamada da tela, envia um parametro chamado local que recebe o valor de fim
                insereProd.putExtra("Local", "Fim");
                startActivity(insereProd);
            }
        });

        imprimeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exibeProd = new Intent(getApplicationContext(), ExibeProdutos.class);
                startActivity(exibeProd);
            }
        });

        excluiProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent excluiProd = new Intent(getApplicationContext(), ExcluiProduto.class);
                startActivity(excluiProd);
            }
        });

        localizaProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent localProd = new Intent(getApplicationContext(), LocalizaProduto.class);
                startActivity(localProd);
            }
        });

        qtdeProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quantProd = new Intent(getApplicationContext(), QuantidadeProduto.class);
                startActivity(quantProd);
            }
        });

        estMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent estoqMin = new Intent(getApplicationContext(), EstoqueMinimo.class);
                startActivity(estoqMin);
            }
        });

        ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajud = new Intent(getApplicationContext(), Ajuda.class);
                startActivity(ajud);
            }
        });
    }
}