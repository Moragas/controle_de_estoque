package com.example.estoque;

public class Produto {

    private int id; //Declarando variavel id do tipo int com modificador de acesso private (nao pode ser acessado por outras classes)
    private String nome; //O mesmo caso de cima, porem a variavel do tipo String
    private float valor; //O mesmo caso de cima, porem a variavel do tipo float
    private int qtdeAtual;
    private int qtdeMin;

    public Produto() { //Método construtor responsavel pela criacao do objeto da classe
        this.id = 0;
    }

    //Abaixo metodos getters para acessar atributos dos objetos e metodos setters para modificar atributos dos objetos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdeAtual() {
        return qtdeAtual;
    }

    public void setQtdeAtual(int qtdeAtual) {
        this.qtdeAtual = qtdeAtual;
    }

    public int getQtdeMin() {
        return qtdeMin;
    }

    public void setQtdeMin(int qtdeMin) {
        this.qtdeMin = qtdeMin;
    }
}
