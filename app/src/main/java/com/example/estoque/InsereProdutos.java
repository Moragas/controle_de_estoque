package com.example.estoque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InsereProdutos extends AppCompatActivity {
    // Declara as variaveis globais
    private Button btnVoltar;
    private Produto produto;

    //Declarando o objeto lista do tipo ListaProduto como public para poder acessa-la em outras classes e static para poder ter acesso aos metodos e atributos da classe
    static int qtde;
    static No ult;
    static No pri;
    public static ListaProduto lista = new ListaProduto(pri = null, ult = null, qtde = 0);

    private EditText nomeProd;
    private EditText valorProd;
    private EditText qtdeAtualProd;
    private EditText qtdeMinProd;
    private TextView alerta;
    private Boolean campoVazio;
    private String local;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_prod);

        //Atribui a variavel local o valor que foi passado como parametro de chamada da tela
        Intent insereProd = getIntent();
        local = (String) insereProd.getSerializableExtra("Local");

        //Define o titulo da pagina
        setTitle("Inserir Produto no " + local + " do Estoque");

        // Inicializa as varaiaveis
        btnVoltar = findViewById(R.id.btn_voltar);

        alerta = findViewById(R.id.alert);
        campoVazio = false;

        nomeProd = findViewById(R.id.nome_prod);
        valorProd = findViewById(R.id.valor_prod);
        qtdeAtualProd = findViewById(R.id.qtde_atual);
        qtdeMinProd = findViewById(R.id.qtde_min);

        //Botao voltar que encerra a view atual e volta a tela inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //Metodo para salvar o produto na lista
    public void salvaProduto(View view){
        this.produto = new Produto(); //Instanciando um novo objeto do tipo Produto

        campoVazio = false; //Inicializando o booleano campoVazio como false, faz com que possamos terminar de preencher o cadastro apos a mensagem de erro

        //As condicionais abaixo verificam campo a campo se possuem algum valor digitado, senao atribuem o valor de verdadeiro ao booleano campoVazio
        if(this.nomeProd.getText().toString().length() > 0){
            this.produto.setNome(this.nomeProd.getText().toString());
        }else{
            campoVazio = true;
        }

        if(this.valorProd.getText().toString().length() > 0){
            this.produto.setValor(Float.parseFloat(this.valorProd.getText().toString()));
        }else{
            campoVazio = true;
        }

        if(this.qtdeAtualProd.getText().toString().length() > 0){
            this.produto.setQtdeAtual(Integer.parseInt(this.qtdeAtualProd.getText().toString()));
        }else{
            campoVazio = true;
        }

        if(this.qtdeMinProd.getText().toString().length() > 0){
            this.produto.setQtdeMin(Integer.parseInt(this.qtdeMinProd.getText().toString()));
        }else{
            campoVazio = true;
        }

        //Caso campoVazio seja falso, insere o produto no inicio ou no fim da lista, dependendo do parametro de entrada que foi passado
        if(!campoVazio){
            if(local.equals("Inicio")) {
                lista.inserirPrimeiro(produto);
            }else if(local.equals("Fim")){
                lista.inserirUltimo(produto);
            }
            finish();
        }else{
            //Retorno alerta na tela caso campoVazio seja verdadeiro
            alerta.setText("Todos os campos devem ser preenchidos!");
        }
    }
}
