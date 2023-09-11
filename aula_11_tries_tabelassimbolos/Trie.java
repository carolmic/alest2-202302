package aula_11_tries_tabelassimbolos;

import java.util.LinkedList;
import java.util.Queue;

public class Trie {
    private static final int TAMANHO_ALFABETO = 26;        //apenas letras maiusculas
    private class Nodo {
        private boolean fimDaChave;
        private char valor;
        private int nivel;
        private Nodo[] proximo;

        public Nodo() {
            this.proximo = new Nodo[TAMANHO_ALFABETO];
            fimDaChave = false;
            this.nivel = 0;
        }
    }
    private Nodo raiz;
    private int quantidade;
    public Trie() {
        this.quantidade = 0;
        this.raiz = new Nodo();
    }
    public void adicionar(String chave) {
        Nodo aux = this.raiz;
        int nivel = this.raiz.nivel;
        for (int i = 0; i < chave.length(); i++) {
            int posicaoNoArray = chave.charAt(i) - 65;
            if (aux.proximo[posicaoNoArray] == null) {
                Nodo novoNodo = new Nodo();
                novoNodo.valor = chave.charAt(i);
                novoNodo.nivel = nivel;
                aux.proximo[posicaoNoArray] = novoNodo;
            }
            nivel++;
            aux = aux.proximo[posicaoNoArray];
        }
        aux.fimDaChave = true;
    }

    public boolean contem(String chave) {
        Nodo n = buscarNodo(chave);
        if(n==null) return false;
        return n.fimDaChave; //se for final de chave retorna true
    }
    private Nodo buscarNodo(String chave) {
        //retorna true ou false se a chave existe na TRIE
        Nodo aux = this.raiz;
        for (int nivel = 0; nivel < chave.length() ; nivel++) {
            int indice = chave.charAt(nivel) - 'A'; //mesma coisa que fazer - 65
            if(aux.proximo[indice]==null) return null;
            aux = aux.proximo[indice];
        }
        return aux;

    }
    public void imprimir() {
        //IMPLEMENTAR EM AULA
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.adicionar("JA");
        t.adicionar("JANTAR");
        t.adicionar("JATO");
        t.adicionar("JATOBA");
        t.imprimir();
        System.out.println(t.contem("JA"));
        System.out.println(t.contem("JAT"));
        System.out.println(t.contem("JATO"));


    }

}
