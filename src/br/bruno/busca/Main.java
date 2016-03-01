package br.bruno.busca;

/**
 * Classe principal do programa
 * @author tiago
 */
public class Main {
    
    /**
     * Monta o grafo e executas as buscas em largura e profundidade
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
        //Cria os nós do grafo
        No no;
        no = new No(1);
        grafo.addNo(no);
        no = new No(2);
        grafo.addNo(no);
        no = new No(3);
        grafo.addNo(no);
        no = new No(4);
        grafo.addNo(no);
        no = new No(5);
        grafo.addNo(no);
        no = new No(6);
        grafo.addNo(no);
        no = new No(7);
        grafo.addNo(no);
        
        //Cria as arestas do nó
        grafo.criarAresta(0, 1);
        grafo.criarAresta(0, 2);
        grafo.criarAresta(0, 3);
        
        grafo.criarAresta(1, 3);
        grafo.criarAresta(1, 5);
        
        grafo.criarAresta(3, 6);
        
        grafo.criarAresta(4, 5);
        grafo.criarAresta(4, 6);
        
        grafo.criarAresta(5, 6);
        
        //Realiza as buscas
        System.out.println("Busca em profundidade");
        grafo.buscaEmProfundidade(0);
        System.out.println("\nBusca em largura");
        grafo.buscaEmLargura(0);
        
        //Exibe o resultado final no grafo
        System.out.println("\n\nGrafo completo");
        grafo.mostrarGrafo();
    }   
}
