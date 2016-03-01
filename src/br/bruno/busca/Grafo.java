package br.bruno.busca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Definição de um grafo.
 * @author tiago
 */
public class Grafo {
    private List<No> nos = new ArrayList<>(); //Nós desse grafo
    
    public void addNo(No no) {
        nos.add(no);
    }
    
    public No getNo(int i) {
        return nos.get(i);
    }
    
    /**
     * Realiza uma busca em largura nesse grafo
     * @param num raiz de onde a busca deve começar
     */
    public void buscaEmLargura(int num) {
        desmarcarTodos();
        
        Queue<No> descobertos = new LinkedList<>(); //Fila de nós descobertos
        
        No raiz = nos.get(num);
        raiz.setEstadoAtual(EstadoNo.DESCOBERTO);
        descobertos.add(raiz);
        
        //Enquanto ouver algum nó descoberto
        while(!descobertos.isEmpty()) {
            No antigo = descobertos.peek(); //Pega o nó mais antigo
            
            for(No no: antigo.getAdjacentes()) { //Percorre todos os adjacentes desse nó
                if(no.getEstadoAtual() == EstadoNo.DESMARCADO) {
                    no.setEstadoAtual(EstadoNo.DESCOBERTO); //Marca os nós como descoberto caso estejam desmarcado
                    descobertos.add(no); //Adiciona o nó a fila de descobertos
                }
            }
            antigo.setEstadoAtual(EstadoNo.EXPLORADO); //Marca o nó como explorado apos descobrir todos os seus adjacentes
            System.out.println(antigo.getValor()+" Explorado");
            descobertos.remove(); //Retira o nó que foi explorado da fila de descobertos
        }
    }
    
    /**
     * Realiza uma busca em profundidade nesse grafo
     * @param num raiz de onde a busca deve começar
     */
    public void buscaEmProfundidade(int num) {
        desmarcarTodos();
        
        Stack<No> descobertos = new Stack<>(); //Pilha de nós descobertos
        
        No raiz = nos.get(num);
        raiz.setEstadoAtual(EstadoNo.DESCOBERTO);
        descobertos.push(raiz);
        
        //Enquanto ouver algum nó descoberto
        while(!descobertos.isEmpty()) {
            No recente = descobertos.peek(); //Pega o nó mais recente
            
            boolean explorado = true;
            for(No no: recente.getAdjacentes()) { //Percorre todos os adjacentes desse nó
                if(no.getEstadoAtual() == EstadoNo.DESMARCADO) {
                    explorado = false;
                    no.setEstadoAtual(EstadoNo.DESCOBERTO); //Marca os nós como descoberto caso estejam desmarcado
                    descobertos.push(no); //Adiciona o nó a pilha de descobertos
                    break;
                }
            }
            
            if(explorado) {
                recente.setEstadoAtual(EstadoNo.EXPLORADO); //Marca o nó como explorado caso ele não tenha mais adjacentes desmarcados
                System.out.println(recente.getValor()+" Explorado");
                descobertos.pop(); //Retira o nó explorado da pilha de descobertos
            }
        }
    }
    
    /**
     * Cria uma nova aresta nesse grafo
     * @param a índice do nó origem
     * @param b índice do nó destino
     */
    public void criarAresta(int a, int b) {
        this.getNo(a).addAdjacente(this.getNo(b));
        this.getNo(b).addAdjacente(this.getNo(a));
    }
    
    /**
     * Desmarca todos os nós do grafo
     */
    public void desmarcarTodos() {
        for(No no: nos) {
            no.setEstadoAtual(EstadoNo.DESMARCADO);
        }
    }
    
    /**
     * Exibe o estado atual de cada nó do grafo
     */
    public void mostrarGrafo() {
        for(No no: nos) {
            System.out.println("No "+no.getValor()+" "+no.getEstadoAtual().toString());
        }
    }
}
