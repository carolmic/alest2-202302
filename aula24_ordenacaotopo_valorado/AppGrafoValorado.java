package aula24_ordenacaotopo_valorado;

public class AppGrafoValorado {
    public static void main(String[] args) {
        GrafoValoradoNaoDirecionado g = new GrafoValoradoNaoDirecionado(3);
        g.adicionarAresta(0,1, 100);
        g.adicionarAresta(0,2, 50);
        g.adicionarAresta(2, 1, 30);
        System.out.println(g.toDot());
    }
}
