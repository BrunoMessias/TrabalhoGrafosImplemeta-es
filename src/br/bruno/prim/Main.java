package br.bruno.prim;

public class Main {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
        //Nós
        grafo.addNo(new No("SF"));  //0
        grafo.addNo(new No("LA"));  //1
        grafo.addNo(new No("D"));   //2
        grafo.addNo(new No("C"));   //3
        grafo.addNo(new No("A"));   //4
        grafo.addNo(new No("B"));   //5
        
        //Arestas
        Aresta a;
        a = new Aresta(grafo.getNo(0), grafo.getNo(1), 39);
        a = new Aresta(grafo.getNo(0), grafo.getNo(2), 89);
        a = new Aresta(grafo.getNo(0), grafo.getNo(3), 120);
        a = new Aresta(grafo.getNo(1), grafo.getNo(2), 50);
        a = new Aresta(grafo.getNo(2), grafo.getNo(3), 65);
        a = new Aresta(grafo.getNo(3), grafo.getNo(5), 79);
        a = new Aresta(grafo.getNo(3), grafo.getNo(4), 99);
        
        //Prim
        grafo.prim(0,5);
    }
}