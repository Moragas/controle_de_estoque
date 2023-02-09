package com.example.estoque;

public class ListaProduto {

    //Declaração de dois objetos do tipo No e uma variavel do tipo inteiro
    private No primeiro;
    private No ultimo;
    private int quantidade;

    //Metodo construtor responsavel pela criacao do objeto da classe
    public ListaProduto(No primeiro, No ultimo, int quantidade) {
        this.primeiro = primeiro;
        this.ultimo = ultimo;
        this.quantidade = quantidade;
    }

    //Abaixo metodos getters para acessar atributos dos objetos e metodos setters para modificar atributos dos objetos
    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //Metodo para verificar se existe produto cadastrado na lista que retorna um boleano verdadeiro se o objeto primeiro tiver valor nulo, senao retorna falso
    public boolean listaVazia(){
        return(this.primeiro == null);
    }

    public void inserirPrimeiro(Produto prod){ //Metodo que recebe o objeto prod para inseri-lo na primeira posicao da lista
        No novoNo = new No(prod); //Instancia um novo no
        if(this.listaVazia()){ //Condicional que verifica se o retorno do metodo listaVazia eh verdadeiro para executar o que esta dentro das chaves
            this.ultimo = novoNo; //Atribui ao objeto ultimo o valor novoNo
        }

        novoNo.setProximo(this.primeiro); //Chama o metodo setProximo passando como parametro o primeiro no para atualizar o valor do objeto
        this.primeiro = novoNo; //Atribui ao primeiro o valor do novoNo
        this.quantidade++; //Incrementa o valor da quantidade conforme produtos vao sendo adicionados a lista
    }

    public void inserirUltimo(Produto prod){ //Metodo que recebe o objeto prod para inseri-lo na ultima posicao da lista. Funciona como o metodo inserirPrimeiro
        No novoNo = new No(prod);
        if(this.listaVazia()){
            this.primeiro = novoNo;
        }else{
            this.ultimo.setProximo(novoNo);
        }

        this.ultimo = novoNo;
        this.quantidade++;
    }

    public String imprimirLista(){ //Metodo que retorna uma String com os produtos cadastrados e seus atributos
        String msg = "", reporProd; //Declara uma variavel do tipo String concatenada ao valor da String reporProd
        int i = 1; //Declara variavel do tipo int

        if(listaVazia()){ //Verifica se a lista eh vazia
            msg = "Lista vazia!"; //Atribui valor a variavel msg
        }else{
            No atual = this.primeiro; //Atribui ao No atual o valor do primeiro
            while (atual != null){ //Repete as instrucoes dentro das chaves enquanto o valor de atual for diferente de nulo
                if(atual.getProd().getQtdeAtual() < atual.getProd().getQtdeMin()){ //Verifica se a quantidade de determinado produto eh menor do que a quantidade minima do mesmo
                    reporProd = "Repor estoque do produto!"; //Atribui valor a variavel reporProd
                }else{
                    reporProd = ""; //Atribui valor a variavel reporProd
                }

                //Atribui as informacoes do produto a String msg
                msg += + i + "." + atual.getProd().getNome() + "\t|Preço: R$" + atual.getProd().getValor() + "\t|Qtde mínima: " + atual.getProd().getQtdeMin() + "\t|" + reporProd + "\n";
                atual = atual.getProximo(); //Atribui a atual o valor do proximo no
                i++; //Incrementa o valor da variavel
            }
        }
        return msg; //Retorna a String msg para mostrar na tela
    }

    public String removeProd(String nomeProd){ //Metodo que remove o produto com o mesmo nome do parametro de entrada
        String msg = "";
        No atual = this.primeiro; //Atribui ao no atual o valor do primeiro no
        No anterior = null; //Atribui ao no anterior o valor nulo
        if(listaVazia()){ //Verifica se a lista esta vazia
            return msg = "Lista vazia!";
        }else{ //Se a lista nao for vazia executa as acoes abaixo
            if(atual.getProd().getNome().equalsIgnoreCase(nomeProd)){ //Se o parametro de entrada for igual ao nome do primeiro produto, remove o primeiro da lista
                this.primeiro = this.primeiro.getProximo(); //Substitui o valor do primeiro produto pelo valor do segundo
                this.quantidade--; //Decrementa o valor da variavel quantidade
                return msg = "Sucesso!";
            }else{
                while ((atual != null) && !(atual.getProd().getNome().equalsIgnoreCase(nomeProd))){ //Passa de produto em produto enquanto o nome do produto for diferente de nulo e diferente do nome passado no parametro
                    anterior = atual; //Atribui o valor do no atual ao no anterior
                    atual = atual.getProximo(); //Atribui o valor do proximo no ao no atual
                }

                if(atual != null){ //Remove no meio da lista
                    anterior.setProximo(atual.getProximo());
                    this.quantidade--;
                    return msg = "Sucesso!";
                }else if(atual == this.ultimo){ //Remove no final da lista
                    this.ultimo = anterior;
                    this.quantidade--;
                    return msg = "Sucesso!";
                }else{
                    return msg = "Nome do produto nao encontrado!";
                } //Os retornos indicam se o produto foi removido ou nao da lista de produtos, e quando o produto é removido faz o decremento da variavel quantidade
            }
        }
    }

    public String pesquisaProd(String nomeProd){ //Metodo que recebe o nome do produto como parametro
        String msg = "", reporProd;
        int i = 1; //Declara variavel do tipo int
        if(listaVazia()){ //Verifica se a lista eh vazia
            return msg = "Lista vazia!"; //Atribui valor a variavel msg
        }else {
            No atual = this.primeiro; //Atribui ao no atual o valor do primeiro no
            while ((atual != null) && (!atual.getProd().getNome().equalsIgnoreCase(nomeProd))) { //Loop que percorre os nos enquanto o no atual for diferente de nulo e o valor do atributo nome for diferente do parametro de entrada


                //Verifica os produtos que possuem no nome o que foi digitado na busca
                if(atual.getProd().getNome().contains(nomeProd)){
                    msg += + i + "." + atual.getProd().getNome() + "\n";
                    i++;
                }

                atual = atual.getProximo();
            }
            if (atual != null) { //Verifica se um produto com o mesmo nome do parametro de entrada foi encontrado
                if (atual.getProd().getQtdeAtual() < atual.getProd().getQtdeMin()) { //Verifica se a quantidade do produto em questao e inferior a quantidade minima deste produto
                    reporProd = "Repor estoque do produto!";
                } else {
                    reporProd = "Estoque normal!";
                }
                return msg = "Nome: " + atual.getProd().getNome() + "\n" + //Retorna as informacoes do produto
                        "Valor: " + atual.getProd().getValor() + "\n" +
                        "Quantidade atual: " + atual.getProd().getQtdeAtual() + "\n" +
                        "Quantidade minima: " + atual.getProd().getQtdeMin() + "\n" +
                        "Situacao: " + reporProd + "\n";
            } else if(i > 1){
                return msg = "Produtos que você pode estar procurando: \n" + msg; //Retorna o nome dos produtos que possuem um trecho do que foi digitado na busca, caso nenhum produto com o nome digitado seja encontrado
            } else {
                return msg = "Nome de produto nao encontrado." + "\n"; //Retorna caso nenhum produto com o nome informado seja encontrado
            }
        }
    }

    public String prodEstoqueMin(){ //Metodo que verifica o estoque do produtos
        String msg = ""; //Declara uma variavel do tipo String
        int i = 1; //Declara variavel do tipo int

        if(listaVazia()){ //Verifica se a lista eh vazia
            msg = "Lista vazia!"; //Atribui valor a variavel msg
        }else{
            No atual = this.primeiro; //Atribui ao No atual o valor do primeiro
            while (atual != null){ //Repete as instrucoes dentro das chaves enquanto o valor de atual for diferente de nulo
                if(atual.getProd().getQtdeAtual() < atual.getProd().getQtdeMin()){ //Verifica se a quantidade de determinado produto eh menor do que a quantidade minima do mesmo
                    //Atribui as informacoes do produto a String msg
                    msg += + i + "." + atual.getProd().getNome() + "\t|Qtde atual: " + atual.getProd().getQtdeAtual() + "\t|Qtde mínima: " + atual.getProd().getQtdeMin() + "\t|" + "\n";
                    i++; //Incrementa o valor da variavel
                }
                atual = atual.getProximo(); //Atribui a atual o valor do proximo no
            }

            //Verifica se todos os produtos da lista estão com o estoque normal
            if(i == 1){
                msg = "Nenhum produto esta abaixo do estoque minimo!";
            }
        }
        return msg; //Retorna a String msg para mostrar na tela
    }
}
