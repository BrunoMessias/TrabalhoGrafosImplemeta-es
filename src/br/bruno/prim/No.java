package br.bruno.prim;

import java.util.ArrayList;
import java.util.List;

public class No implements Comparable<No> {
    //Identificador
    private final String id;
    //Estado atual
    private EstadoNo estadoNo;
    //Lista de arestas
    private List<Aresta> adjacentes;
    //Distâncias relativas para cada vértice
    private int distanciaRelativa;
    //Nó antecessor de custo mínimo
    private No antecessor;
    
    public No(String id) {
        this.id = id;
        distanciaRelativa = Integer.MAX_VALUE;
        antecessor = null;
        adjacentes = new ArrayList<>();
        estadoNo = EstadoNo.NAO_VERIFICADO;
    }
    
    /**
     * Distância relativa para chegar a este vértice
     * @return distância relativa
     */
    public int getDistanciaRelativa() {
        return distanciaRelativa;
    }
    
    /**
     * Altera a distância relativa deste vértice
     * @param distanciaRelativa novo valor de distância relativa
     */
    public void setDistanciaRelativa(int distanciaRelativa) {
        this.distanciaRelativa = distanciaRelativa;
    }
    
    /**
     * Estado atual desde vértice
     * @return estado atual
     */
    public EstadoNo getEstadoNo() {
        return estadoNo;
    }
    
    /**
     * Altera o estado ataul deste vértice
     * @param estadoNo novo estado
     */
    public void setEstadoNo(EstadoNo estadoNo) {
        this.estadoNo = estadoNo;
    }
    
    /**
     * Vértice antecessor deste na MST
     * @return vértice antecessor
     */
    public No getAntecessor() {
        return antecessor;
    }
    
    /**
     * Altera o vértice antecessor deste
     * @param antecessor novo antecessor
     */
    public void setAntecessor(No antecessor) {
        this.antecessor = antecessor;
    }
    
    /**
     * Identificador deste vértice
     * @return 
     */
    public String getId() {
        return id;
    }
    
    /**
     * Adiciona uma aresta adjacente a esse nó
     * @param aresta aresta adjacente
     */
    public void addAdjacentes(Aresta aresta) {
        adjacentes.add(aresta);
    }
    
    /**
     * Remove uma aresta adjacente a esse nó
     * @param pos posição da aresta a ser removida
     */
    public void removeAdjacentes(int pos){
        adjacentes.remove(pos);
    }
    
    /**
     * Lista de arestas vizinhas deste vértice
     * @return 
     */
    public List<Aresta> getAdjacentes() {
        return adjacentes;
    }
    
    @Override
    public int compareTo(No no) {
        if(this.getDistanciaRelativa() < no.getDistanciaRelativa()) {
            return -1;
        } else {
            return 1;
        }
    }       
}