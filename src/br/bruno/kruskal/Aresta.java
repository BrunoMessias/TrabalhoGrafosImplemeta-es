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
        
        colocarArestaNaAdjacentes(this);
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
    
    /**
     * Adciona essa aresta a lista de adjacentes da origem e do destino
     * @param aresta aresta a ser adicionada
     */
    private void colocarArestaNaAdjacentes(Aresta aresta){
        aresta.getOrigem().addAdjacentes(aresta);
        aresta.getOrigem().addAdjacentes(aresta);
    }
}