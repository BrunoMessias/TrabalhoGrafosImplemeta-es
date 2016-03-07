package br.bruno.dijkstra;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Definição de um grafo
 * @author bruno
 */
public class Grafo implements Cloneable, Serializable{
    private List<No> nos = new ArrayList<>(); //Nós desse grafo
    
    public List<No> getNos(){
        return nos;
    }
    
    public void addNo(No no) {
        nos.add(no);
    }
    
    public No getNo(int pos) {
        return nos.get(pos);
    }
    
    /**
     * Encontra o menor caminho entre dois pontos utilizando o algoritmo de dijkstra
     * @param init origem da busca
     * @param finish destino da busca
     */
    public void dijkstra(int init, int finish) {
        long startTime = System.currentTimeMillis();
        
        No inicio = nos.get(init); //Onde começa
        inicio.setCustoMinimo(0);  //O inicio tem custo 0
        No fim = nos.get(finish);  //Onde queremos chegar
        
        List<No> nosAbertos = new ArrayList<>(); //Lista de nós abertos
        
        //Popula a lista com todos os nós abertos
        for(No no: nos) {
            nosAbertos.add(no);
        }
        
        No atual = inicio; //Nó em que estamos atualmente
        
        //Encontra os caminhos mínimos para todos os nós a partir da origem
        while(!nosAbertos.isEmpty()) {
            for(Aresta aresta: atual.getAdjacentes()) { //Calcula o custo para todos os nós adjacentes
                int novoCusto = atual.getCustoMinimo() + aresta.getCusto();
                
                if(novoCusto < aresta.getDestino().getCustoMinimo()) {
                   aresta.getDestino().setCustoMinimo(novoCusto); //Altera o custo mínimo de um nó
                   aresta.getDestino().setAntecessor(atual); //Define o nó antecessor
                }
            }
            
            atual.setEstadoNo(EstadoNo.FECHADO); //Fecha o nó atual
            nosAbertos.remove(atual); //Remove o nó atual da lista de nós abertos
            Collections.sort(nosAbertos); //Ordena a lista de nós abertos
            if(!nosAbertos.isEmpty()) {
                atual = nosAbertos.get(0); //Pega o nó com o menos custo
            }
        }
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        
        //Controi o menos caminho da origem até o destino
        Stack<No> caminhoMinimo = new Stack<>(); //Uma pilha para montar o caminha mínimo do fim para o inicio
        caminhoMinimo.addElement(fim); //Adiciona o fim ao caminho minimo
        
        atual = fim; //Começa pelo fim
        while(!atual.equals(inicio)) { //Se repete até voltarmos ao início
            atual = atual.getAntecessor();
            caminhoMinimo.addElement(atual);
        }
        
        //Exibe todos os nós na pilha de caminho mínimo
        while(!caminhoMinimo.empty()) {
            atual = caminhoMinimo.pop();
            System.out.println("NO:" + atual.getId());
        }
        
        System.out.println(elapsedTime);
    }
    
    public void dijkstraHeap(int init, int finish) {
            long startTime = System.currentTimeMillis();
            
            Heap heap = new Heap();
            No inicio = nos.get(init); //Onde começa
            inicio.setCustoMinimo(0);  //O inicio tem custo 0
            heap.add(inicio);
            inicio.setEstadoNo(EstadoNo.VISITADO);

            while (!heap.isEmpty()) {
                No u = heap.remove();
                u.setEstadoNo(EstadoNo.FECHADO);
                for(Aresta temp : u.getAdjacentes()){
                    if (temp.getDestino().getEstadoNo() == EstadoNo.ABERTO) {
                        heap.add(temp.getDestino());
                        temp.getDestino().setEstadoNo(EstadoNo.VISITADO);
                    }
                    if (temp.getDestino().getCustoMinimo() > u.getCustoMinimo() + temp.getCusto()) {
                        temp.getDestino().setCustoMinimo(u.getCustoMinimo() + temp.getCusto());
                        temp.getDestino().setAntecessor(u);
                        heap.heapifyUP(temp.getDestino());
                    }
                }
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            
            No fim = nos.get(finish);  //Onde queremos chegar
            //Controi o menos caminho da origem até o destino
            Stack<No> caminhoMinimo = new Stack<>(); //Uma pilha para montar o caminha mínimo do fim para o inicio
            caminhoMinimo.addElement(fim); //Adiciona o fim ao caminho minimo

            No atual = fim; //Começa pelo fim
            while(!atual.equals(inicio)) { //Se repete até voltarmos ao início
                atual = atual.getAntecessor();
                caminhoMinimo.addElement(atual);
            }

            //Exibe todos os nós na pilha de caminho mínimo
            while(!caminhoMinimo.empty()) {
                atual = caminhoMinimo.pop();
                System.out.println("NO:" + atual.getId());
            }
            
            System.out.println(elapsedTime);
    }
    
    public static class Heap {
            private List<No> heap; //Nós dessa heap

            public Heap() {
                heap = new ArrayList<>();
            }

            public void add(No u) {
                heap.add(u);
                heapifyUP(heap.size() - 1);
            }

            public void heapifyUP(No u) {
                for (int i = 0; i < heap.size(); i++) {
                    if (u.equals(heap.get(i))) {
                        heapifyUP(i);
                        break;
                    }
                }
            }

            public void heapifyUP(int position) {
                int currentIndex = position;
                No currentItem = heap.get(currentIndex);
                int parentIndex = (currentIndex - 1) / 2;
                No parentItem = heap.get(parentIndex);
                while (currentItem.compareTo(parentItem) == -1) {
                    swap(currentIndex, parentIndex);
                    currentIndex = parentIndex;
                    if (currentIndex == 0) {
                        break;
                    }
                    currentItem = heap.get(currentIndex);
                    parentIndex = (currentIndex - 1) / 2;
                    parentItem = heap.get(parentIndex);
                }
            }

            public No remove() {
                No v = heap.get(0);
                swap(0, heap.size() - 1);
                heap.remove(heap.size()-1);
                heapifyDown(0);
                return v;
            }

            public void heapifyDown(int position) {
                if (heap.size() == 0) {
                    return;
                }

                int currentIndex = position;
                No currentItem = heap.get(currentIndex);
                int leftChildIndex = currentIndex * 2 - 2 + 2;
                int rightChildIndex = currentIndex * 2 - 2 + 3;
                //int leftChildIndex = 2 * currentIndex + 1;
                //int rightChildIndex = 2 * currentIndex + 2;
                int childIndex;
                if (leftChildIndex >= heap.size()) {
                    return;
                }
                if (rightChildIndex >= heap.size()) {
                    childIndex = leftChildIndex;
                } else if (heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) == -1) {
                    childIndex = rightChildIndex;
                } else {
                    childIndex = leftChildIndex;
                }
                No childItem = heap.get(childIndex);
                while (currentItem.compareTo(childItem) == 1) {
                    swap(currentIndex, childIndex);
                    currentIndex = childIndex;
                    currentItem = heap.get(currentIndex);
                    leftChildIndex = currentIndex * 2 - 2 + 2;
                    rightChildIndex = currentIndex * 2 - 2 + 3;
                    //leftChildIndex = 2 * currentIndex + 1;
                    //rightChildIndex = 2 * currentIndex + 2;
                    if (leftChildIndex >= heap.size()) {
                        return;
                    }
                    if (rightChildIndex >= heap.size()) {
                        childIndex = leftChildIndex;
                    } else if (heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) == -1) {
                        childIndex = rightChildIndex;
                    } else {
                        childIndex = leftChildIndex;
                    }
                }
            }

            public void swap(int index1, int index2) {
                Collections.swap(heap, index1, index2);
            }
            
            public boolean isEmpty() {

                return heap.isEmpty();
            }
        }
    
    
    @Override
    public Grafo clone(){
        try {
            return (Grafo)super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Erro ao clonar.");
            return null;
        }
    }
    
    
}
    
