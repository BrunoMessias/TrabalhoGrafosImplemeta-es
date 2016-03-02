package br.bruno.kruskal;


/**
 * Define uma aresta no grafo
 * @author bruno
 */
public class Aresta {
    private final No origem; //Origem da aresta
    private final No destino;//Destino da aresta
    private final int custo; //Custo dessa aresta
    
    public Aresta(No origem, No destino, int custo) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
    }

    public No getOrigem() {
        return origem;
    }

    public No getDestino() {
        return destino;
    }

    public int getCusto() {
        return custo;
    }
    
    public static void inserirAresta(No no1, No no2, int custo){
        Aresta aresta1 = new Aresta(no1, no2, custo);
        aresta1.getOrigem().addAdjacentes(aresta1);
        Aresta aresta2 = new Aresta(no2, no1, custo);
        aresta2.getOrigem().addAdjacentes(aresta2);
    }
}