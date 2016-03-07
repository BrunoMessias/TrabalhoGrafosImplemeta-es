package br.bruno.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Define um nó no grafo
 * @author bruno
 */
public class No implements Comparable<No> {
    private final String id; //Identificador desse nó
    private EstadoNo estadoNo; //Estado atual do nó
        
    private List<Aresta> adjacentes; //Lista de arestas das quais ele faz parte(adjacentes)
            
    private int custoMinimo; //Custo mínimo para chegar nesse nó
    private No antecessor; //Nó antecessor para chegar até ele com custo mínimo
    
    public No(String id) {
        this.id = id;
        
        custoMinimo = Integer.MAX_VALUE-10;
        antecessor = null;
        adjacentes = new ArrayList<>();
        estadoNo = EstadoNo.ABERTO;
    }
    
    public int getCustoMinimo() {
        return custoMinimo;
    }
    
    public void setCustoMinimo(int custoMinimo) {
        this.custoMinimo = custoMinimo;
    }
    
    public EstadoNo getEstadoNo() {
        return estadoNo;
    }
    
    public void setEstadoNo(EstadoNo estadoNo) {
        this.estadoNo = estadoNo;
    }
    
    public No getAntecessor() {
        return antecessor;
    }
    
    public void setAntecessor(No antecessor) {
        this.antecessor = antecessor;
    }
    
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
    
    public List<Aresta> getAdjacentes() {
        return adjacentes;
    }
    
    @Override
    public int compareTo(No no) {
        if(this.getCustoMinimo() < no.getCustoMinimo()) {
            return -1;
        } else if(this.getCustoMinimo() == no.getCustoMinimo()){
            return 0;
        } else{
            return 1;
        }
    }       
}