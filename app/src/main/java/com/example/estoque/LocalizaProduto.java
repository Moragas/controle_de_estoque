package com.example.estoque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LocalizaProduto extends AppCompatActivity {

    // Declara as variaveis globais
    private TextView localProd;
    private EditText buscaProd;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localiza_produto);

        //Define o titulo da pagina
        setTitle("Localiza Produto");

        // Inicializa as varaiaveis
        localProd = findViewById(R.id.local_prod);
        buscaProd = findViewById(R.id.busca_prod);
        btnVoltar = findViewById(R.id.btn_voltar4);

        //Botao voltar que encerra a view atual e volta a tela inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //Metodo que mostra na tela o produto buscado
    public void localizarProduto(View view){
        //Declaracao de duas variaveis do tipo String
        String nomeProd;
        String returnMsg;
        //Atribuicao do valor digitado no campo buscaProd a variavel nomeProd
        nomeProd = this.buscaProd.getText().toString();
        //Utilizando a variavel nomeProd como parametro de entrada do metodo pesquisaProd e atribuindo o valor retornado a variavel returnMsg
        returnMsg = InsereProdutos.lista.pesquisaProd(nomeProd);

        //Atribui o valor do retorno a variavel localProd
        localProd.setText(returnMsg);

        //Chamando o metodo que recolhe o teclado
        recolheTeclado(view);
    }

    //Metodo para recolher o teclado apos clique no botao localizar
    public void recolheTeclado(View view){
        if(view != null){
            InputMethodManager recolheTecla = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            recolheTecla.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}