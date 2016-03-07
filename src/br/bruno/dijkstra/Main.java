package br.bruno.dijkstra;

/**
 * Classe principal do programa
 * @author bruno
 */
public class Main {
    
    /**
     * Monta o grafo e busca o menor caminho entre dois pontos
     */
    public static void main(String[] args) throws Exception {
        Grafo grafo = GrafoAleatorioDijkstra.gerar(1000, 10, 10, 50);
        
        Grafo grafoClone = grafo.clone();

        grafo.dijkstraHeap(0,7);
        System.out.println(grafoClone.getNo(0).getEstadoNo());
        System.out.println(grafo.getNo(0).getEstadoNo());
        //grafo.dijkstra(0,7);
        //grafoClone.dijkstraHeap(0,7);
        
        
//        Cria os nós do grafo
//        No no;
//        no = new No("1");//0
//        grafo.addNo(no);
//        no = new No("2");//1
//        grafo.addNo(no);
//        no = new No("3");//2
//        grafo.addNo(no);
//        no = new No("4");//3
//        grafo.addNo(no);
//        no = new No("5");//4
//        grafo.addNo(no);
//        no = new No("6");//5
//        grafo.addNo(no);
//        no = new No("7");//6
//        grafo.addNo(no);
//        
//        //Cria as arestas do nó
//        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(1), 2);
//        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(2), 5);
//        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(3), 4);
//        Aresta.inserirAresta(grafo.getNo(1), grafo.getNo(2), 2);
//        Aresta.inserirAresta(grafo.getNo(1), grafo.getNo(4), 7);
//        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(3), 1);
//        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(4), 4);
//        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(5), 3);
//        Aresta.inserirAresta(grafo.getNo(3), grafo.getNo(5), 4);
//        Aresta.inserirAresta(grafo.getNo(4), grafo.getNo(5), 1);
//        Aresta.inserirAresta(grafo.getNo(4), grafo.getNo(6), 5);
//        Aresta.inserirAresta(grafo.getNo(5), grafo.getNo(6), 7);
    }
}