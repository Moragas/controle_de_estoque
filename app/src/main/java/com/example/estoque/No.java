package com.example.estoque;

public class No {

    private Produto prod; //Declarando objeto prod do tipo Produto com modificador de acesso private (nao pode ser acessado por outras classes)
    private No proximo; //O mesmo caso de cima, porem com objeto proximo do tipo No

    public No(Produto prod) { //Metodo No que recebe o produto como parametro
        this.prod = prod; //Atribui o produto ao objeto prod
        this.proximo = null; //Atribui nulo ao objeto proximo
    }

    public Produto getProd() { //Metodo que retorna o produto
        return prod;
    }

    public void setProd(Produto prod) { //Metodo que recebe o produto como parametro e atualiza o valor do objeto prod
        this.prod = prod;
    }

    public No getProximo() { //Metodo que retorna o proximo
        return proximo;
    }

    public void setProximo(No proximo) { //Metodo que recebe o proximo como parametro e atualiza o valor do objeto proximo
        this.proximo = proximo;
    }
}
