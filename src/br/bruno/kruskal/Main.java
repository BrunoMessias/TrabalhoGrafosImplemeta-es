package br.bruno.kruskal;

/**
 * Classe principal do programa
 * @author bruno
 */
public class Main {
    
    /**
     * Monta o grafo e busca o menor caminho entre dois pontos
     * @param args
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
        //Cria os nós do grafo
        No no;
        no = new No("SF");//0
        grafo.addNo(no);
        no = new No("LA");//1
        grafo.addNo(no);
        no = new No("D");//2
        grafo.addNo(no);
        no = new No("C");//3
        grafo.addNo(no);
        no = new No("A");//4
        grafo.addNo(no);
        no = new No("B");//5
        grafo.addNo(no);
        no = new No("NY");//6
        grafo.addNo(no);
        no = new No("M");//7
        grafo.addNo(no);
        
        //Cria as arestas do nó
        new Aresta(grafo.getNo(0), grafo.getNo(1), 39);
        new Aresta(grafo.getNo(0), grafo.getNo(2), 89);
        new Aresta(grafo.getNo(0), grafo.getNo(3), 120);
        new Aresta(grafo.getNo(0), grafo.getNo(6), 210);
        new Aresta(grafo.getNo(1), grafo.getNo(2), 50);
        new Aresta(grafo.getNo(1), grafo.getNo(6), 170);
        new Aresta(grafo.getNo(2), grafo.getNo(3), 65);
        new Aresta(grafo.getNo(3), grafo.getNo(5), 79);
        new Aresta(grafo.getNo(3), grafo.getNo(6), 59);
        new Aresta(grafo.getNo(3), grafo.getNo(4), 99);
        new Aresta(grafo.getNo(4), grafo.getNo(6), 80);
        new Aresta(grafo.getNo(4), grafo.getNo(7), 70);
        new Aresta(grafo.getNo(5), grafo.getNo(6), 20);
        new Aresta(grafo.getNo(6), grafo.getNo(7), 66);
        
        //Descobre o menor caminho
        grafo.kruskal(0);
    }
}