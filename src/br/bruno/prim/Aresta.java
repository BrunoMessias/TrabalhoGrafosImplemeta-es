package br.bruno.prim;

public class Aresta {
    private final No origem; 
    private final No destino;
    private final int custo;
    
    public Aresta(No origem, No destino, int custo) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
        colocarArestaNaAdjacentes(this);
    }

    /**
     * Vértice de origem desta aresta
     * @return vértice de origem
     */
    public No getOrigem() {
        return origem;
    }

    /**
     * Vértice de destino desta aresta
     * @return vértice de destino
     */
    public No getDestino() {
        return destino;
    }

    /**
     * Custo desta aresta
     * @return custo
     */
    public int getCusto() {
        return custo;
    }
    
    /**
     * Adiciona a aresta a lista de arestas vizinhas dos vértices de origem e destino
     * @param aresta
     */
    private void colocarArestaNaAdjacentes(Aresta aresta){
        aresta.getOrigem().addAdjacentes(aresta);
        aresta.getDestino().addAdjacentes(aresta);
    }
}