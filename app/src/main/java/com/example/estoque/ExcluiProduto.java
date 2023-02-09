package com.example.estoque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExcluiProduto extends AppCompatActivity {

    //Declarando variáveis globais
    private EditText exclProd;
    private TextView exclMsg;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclui_produto);

        //Define o titulo da pagina
        setTitle("Exclusão de Produto");

        // Inicializa as varaiaveis
        exclProd = findViewById(R.id.excl_prod);
        exclMsg = findViewById(R.id.excl_msg);
        btnVoltar = findViewById(R.id.btn_voltar3);

        //Botao voltar que encerra a view atual e volta a tela inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //Metodo que exclui um produto da lista
    public void excluirProduto(View view){
        //Declaracao de duas variaveis do tipo String
        String nomeProd;
        String returnMsg;
        //Atribuicao do valor digitado no campo exclProd a variavel nomeProd
        nomeProd = this.exclProd.getText().toString();
        //Utilizando a variavel nomeProd como parametro de entrada do metodo removeProd e atribuindo o valor retornado a variavel returnMsg
        returnMsg = InsereProdutos.lista.removeProd(nomeProd);

        //Se o produto for excluido com sucesso o usuario eh direcionado para o menu
        if(returnMsg.equalsIgnoreCase("Sucesso!")){
            exclMsg.setText(returnMsg);
            finish();
        }else{
            //Senao ele retorna a mensagem de lista vazia ou produto nao encontrado
            exclMsg.setText(returnMsg);
        }
    }
}