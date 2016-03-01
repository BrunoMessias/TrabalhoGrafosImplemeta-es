package br.bruno.busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Define um Nó do Grafo
 * @author tiago
 */
public class No implements Comparable<No> {
    private int valor; //Id desse nó
    private List<No> adjacentes;  //Lista de adjacências
    private EstadoNo estadoAtual; //Estado atual do nó
    
    public No(int valor) {
        this.valor = valor;
                
        adjacentes = new ArrayList<>();
        estadoAtual = EstadoNo.DESMARCADO;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public List<No> getAdjacentes() {
        return adjacentes;
    }
    
    public void setAdjacentes(List<No> adjacentes) {
        this.adjacentes = adjacentes;
        Collections.sort(adjacentes);
    }
    
    /**
     * Adiciona um nó a lista de adjacencias desse nó
     * @param no nó a ser adicionado
     */
    public void addAdjacente(No no) {
        adjacentes.add(no);
        Collections.sort(adjacentes);
    }
    
    /**
     * Remove um nó da lista de adjacencias desse nó
     * @param id identificador do nó a ser removido
     */
    public void removeAdjacente(int id) {
        adjacentes.remove(id);
        Collections.sort(adjacentes);
    }
    
    public EstadoNo getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EstadoNo estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    @Override
    public int compareTo(No no) {
        if(this.getValor() < no.getValor()) {
            return -1;
        } else {
            return 1;
        }
    }
}
