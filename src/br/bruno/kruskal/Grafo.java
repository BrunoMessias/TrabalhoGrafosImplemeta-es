package br.bruno.kruskal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Definição de um grafo
 * @author bruno
 */
public class Grafo {
    private List<No> nos = new ArrayList<>(); //Nós desse grafo
    private Queue<Aresta> listCaminhoMinimo = new LinkedList<>();
    
    public void addNo(No no) {
        nos.add(no);
        no.setConjunto(nos.size());
    }
    
    public No getNo(int pos) {
        return nos.get(pos);
    }
    
    
    public void findLessAresta(){
        Aresta arestaMinima = null;
        for(int i = 0; i < nos.size(); i++){
            for(Aresta aresta : nos.get(i).getAdjacentes()){
                if(aresta.getOrigem().getConjunto() != aresta.getDestino().getConjunto()){
                    if(arestaMinima == null || arestaMinima.getCusto() > aresta.getCusto()){
                    arestaMinima = aresta;
                    }  
                }
            }
        }
        changeConjunto(arestaMinima.getDestino().getConjunto(), arestaMinima.getOrigem().getConjunto());
        listCaminhoMinimo.add(arestaMinima);
    }
    
    public void changeConjunto(int conjuntoOld, int conjuntoNew){
        for(No no : nos){
            if(no.getConjunto() == conjuntoOld){
                no.setConjunto(conjuntoNew);
            }
        }
    }
    /**
     * Encontra o menor caminho entre dois pontos utilizando o algoritmo de dijkstra
     * @param init origem da busca
     */
    public void kruskal(int init) {

        No inicio = nos.get(init); //Onde começa        
        No atual = inicio; //Nó em que estamos atualmente
        
        while(listCaminhoMinimo.size() < nos.size()-1){
            findLessAresta();
        }        
        
        
        while(!listCaminhoMinimo.isEmpty()){
            System.out.print("Origem  "+listCaminhoMinimo.peek().getOrigem().getId()+"     ");  
            System.out.println("Destino  "+listCaminhoMinimo.peek().getDestino().getId());
            listCaminhoMinimo.remove();
        }
    }
}
    
