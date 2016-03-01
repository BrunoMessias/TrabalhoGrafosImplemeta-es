package br.bruno.prim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Grafo {
    private List<No> nos = new ArrayList<>();
    
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
     * @param init origem da busca
     * @param finish destino da busca
     */
    public void prim(int init, int finish) {
        //Onde começa
        No inicio = nos.get(init); 
        //O inicio tem custo 0
        inicio.setDistanciaRelativa(0);  
        //Onde queremos chegar
        No fim = nos.get(finish);  
        
        //Lista de nós não verificados
        List<No> nosNaoVerificados = new ArrayList<>(); 
        
        //Popula a lista com todos os nós abertos
        for(No no: nos) {
            nosNaoVerificados.add(no);
        }
        
        //Nó em que estamos atualmente
        No atual = inicio; 
        
        //A partir da origem, gera a MST até o fim
        while(!nosNaoVerificados.isEmpty()) {
            //Iterando sobre as arestas do nó atual
            for(Aresta aresta: atual.getAdjacentes()) { 
                
                //Verifica se o custo para usar esta aresta é menor que o da aresta atualmente utilizada
                if(aresta.getCusto() < aresta.getDestino().getDistanciaRelativa()) { 
                   //Altera o custo para a aresta de menor custo
                   aresta.getDestino().setDistanciaRelativa(aresta.getCusto());
                   //Define o nó antecessor
                   aresta.getDestino().setAntecessor(atual); 
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
        
        //Pilha MST
        Stack<No> caminhoMinimo = new Stack<>();
        //Adiciona o o ultimo no na pilha da MST
        caminhoMinimo.addElement(fim);
        
        //Adiciona os elementos na pilha a partir do fim
        atual = fim;
        //Ireta sobre os antecessores de cada no
        while(!atual.equals(inicio)) {
            //Seleciona o antecessor do no atual
            atual = atual.getAntecessor();
            //Adiciona o antecessor na pilha
            caminhoMinimo.addElement(atual);
        }
        
        int custoMST = 0;
        //Exibe a MST
        while(!caminhoMinimo.empty()) {
            //Remove o topo da pilha
            atual = caminhoMinimo.pop();
            
            //Verifica se a pilha da MST está vazia
            if(!caminhoMinimo.empty()){
                //Busca o topo da pilha
                No proximo = caminhoMinimo.peek();
                //Exibe o vertice atual, o de destino e o custo relativo para chegar ao destino
                System.out.println(atual.getId()+"\t->\t"+proximo.getId()+"\tCusto: "+proximo.getDistanciaRelativa());
                //Soma o custo relativo ao custo total da MST
                custoMST += proximo.getDistanciaRelativa();
            }
        }
        //Exibe o custo total da MST
        System.out.println("Custo MST: "+custoMST);
    }
}
    
