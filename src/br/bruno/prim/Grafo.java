package br.bruno.prim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {
    private List<No> nos = new ArrayList<>();
    private List<Aresta> mst = new ArrayList<>();
    int custo =0;
    
    /**
     * Adiciona um vértice na lista de vértices do grafo
     * @param no Vértice a ser adicionado
     */
    public void addNo(No no) {
        nos.add(no);
    }
    
    /**
     * Busca um vértice no grafo
     * @param pos posição do grafo na lista
     * @return vértice da posição
     */
    public No getNo(int pos) {
        return nos.get(pos);
    }
    
    /**
     * Encontra a MST utilizando o algoritmo de prim
     * @param init
     */
    public void prim(int init) {
        //Onde começa
        No inicio = nos.get(init); 
        //O inicio tem custo 0
        inicio.setDistanciaRelativa(0);   
        
        //Lista de nós não verificados
        List<No> nosNaoVerificados = new ArrayList<>(); 
        
        //Popula a lista com todos os nós abertos
        for(No no: nos) {
            nosNaoVerificados.add(no);
        }
        
        //Nó em que estamos atualmente
        No atual = inicio; 
        
        int custoMST = 0;
        //A partir da origem, gera a MST até o fim
        while(!nosNaoVerificados.isEmpty()) {

            //Iterando sobre as arestas do nó atual
            for(Aresta aresta: atual.getAdjacentes()) { 
                
                if(aresta.getDestino().getEstadoNo() == EstadoNo.NAO_VERIFICADO){
                    if (aresta.getCusto() < aresta.getDestino().getDistanciaRelativa()) {
                        //Altera o custo para a aresta de menor custo
                        aresta.getDestino().setDistanciaRelativa(aresta.getCusto());
                        aresta.getDestino().setMinima(aresta);
                    }
                }
            }
            
            //Fecha o nó atual
            atual.setEstadoNo(EstadoNo.VERIFICADO); 
            //Remove o nó atual da lista de nós não verificados
            nosNaoVerificados.remove(atual); 
            //Ordena a lista de nós não verificados
            Collections.sort(nosNaoVerificados);
            
            //Verifica se existem nós não verificados para pegar o próximo
            if(!nosNaoVerificados.isEmpty()) {
                //Pega o nó com o menor custo
                atual = nosNaoVerificados.get(0); 
            }
        }
        
        for(int i = 1 ; i < nos.size(); i++){
             mst.add(nos.get(i).getMinima());
             custo += nos.get(i).getMinima().getCusto();
        }
       
    for (int i =0 ; i < nos.size(); i++){  
        for(Aresta aresta : mst){
                if(aresta.getOrigem().equals(nos.get(i))){
                 System.out.println(aresta.getOrigem().getId() + "  ->  " + aresta.getDestino().getId());   
                }
            }
        }
        System.out.println("Custo -> " + custo);
        System.out.println("Tamanno -> " + mst.size());
    }
}
    
