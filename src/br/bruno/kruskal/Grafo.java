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
    private final List<No> nos = new ArrayList<>(); //Nós desse grafo
    private final Queue<Aresta> arvoreGeradoraMinima = new LinkedList<>();
    
    public void addNo(No no) {
        nos.add(no);
        no.setConjunto(nos.size());
    }

    public List<No> getNos() {
        return nos;
    }
    
    public No getNo(int pos) {
        return nos.get(pos);
    }
    
    
    public void findLessAresta(){
        Aresta arestaMinima = new Aresta (new No("teste"), new No("teste"), Integer.MAX_VALUE);//Valores simbolicos para a inicialização da aresta
        for(No no : nos){
            
            for(Aresta aresta : no.getAdjacentes()){
                if(aresta.getOrigem().getConjunto() != aresta.getDestino().getConjunto()){ //Compara se o conjunto das extremidades da aresta são diferentes
                    if(arestaMinima.getCusto() >= aresta.getCusto()){ //Compara se o custo da aresta minima é maior que a aresta a ser comparada
                    arestaMinima = aresta; // Recebe a aresta menor com o objetivo de armazenar a menor aresta possível
                    }  
                }
            }
        }
        changeConjunto(arestaMinima); 
        arvoreGeradoraMinima.add(arestaMinima); //Adiciona a lista que representa a arvoreGeradoraMinima
    }
    
    /**
     * Muda o conjunto de todos os nós alvos,acrescentando-os a outro conjunto
     * @param aresta
     */
    public void changeConjunto(Aresta aresta){
        int conjuntoOld = aresta.getDestino().getConjunto();
        int conjuntoNew = aresta.getOrigem().getConjunto();
        for(No no : nos){ //Percorre todos os nós 
            if(no.getConjunto() == conjuntoOld){ //Compara se o nó está inserido no conjunto-alvo
                no.setConjunto(conjuntoNew);//Altera para o novo conjunto
            }
        }
    }
    /**
     * Encontra a arvore geradora de custo mínimo utiizando o algoritmo de Kruskal
     */
    public void kruskal() {

        
        while(arvoreGeradoraMinima.size() < nos.size()-1){ //Por definição a arvore geradora é igual ao numero de Nós menos 1
            findLessAresta();
        }        
        
        System.out.println(arvoreGeradoraMinima.size());
        while(!arvoreGeradoraMinima.isEmpty()){ //Printa as arestas que compoem o arvore geradora minima
            System.out.println(arvoreGeradoraMinima.peek().getOrigem().getId()+"  ->  "  + arvoreGeradoraMinima.peek().getDestino().getId());  
            arvoreGeradoraMinima.remove();
        }
    }
}
    
