package br.bruno.prim;

public class Aresta {
    private No origem; 
    private No destino;
    private final int custo;
    
    public Aresta(int custo){
        this.custo = custo;
    }
    
    private Aresta(No origem, No destino, int custo) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;;
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
    
    public static void inserirAresta(No no1, No no2, int custo){
        Aresta aresta1 = new Aresta(no1, no2, custo);
        aresta1.getOrigem().addAdjacentes(aresta1);
        Aresta aresta2 = new Aresta(no2, no1, custo);
        aresta2.getOrigem().addAdjacentes(aresta2);
    }
}