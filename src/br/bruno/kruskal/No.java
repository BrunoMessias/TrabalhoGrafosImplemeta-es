package br.bruno.kruskal;

import java.util.ArrayList;
import java.util.List;

/**
 * Define um nó no grafo
 * @author bruno
 */
public class No {
    private final String id; //Identificador desse nó
    private EstadoNo estadoNo; //Estado atual do nó    
    private List<Aresta> adjacentes; //Lista de arestas das quais ele faz parte(adjacentes)
    private int conjunto;
            
     public No(String id) {
        this.id = id;  
        adjacentes = new ArrayList<>();
        estadoNo = EstadoNo.ABERTO;
        conjunto = 0;
    }
    
    public EstadoNo getEstadoNo() {
        return estadoNo;
    }
    
    public void setEstadoNo(EstadoNo estadoNo) {
        this.estadoNo = estadoNo;
    }
    
    public String getId() {
        return id;
    }

    public int getConjunto() {
        return conjunto;
    }

    public void setConjunto(int conjunto) {
        this.conjunto = conjunto;
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
    
    public List<Aresta> getAdjacentes() {
        return adjacentes;
    }
    
}