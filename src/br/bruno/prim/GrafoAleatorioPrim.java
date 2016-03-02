package br.bruno.prim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tiago
 */
public class GrafoAleatorioPrim {
    
    public static Grafo gerar(int tamanho, int maxArestas, int maxDistacia, int maxCusto) {
        if(maxArestas > maxDistacia){
            maxDistacia = maxArestas;
        }
        Grafo grafo = new Grafo();
        
        No[] nos = new No[tamanho];
        
        int i = 0;
        for(i=0; i<tamanho; i++) {
            nos[i] = new No(String.valueOf(i+1));
            grafo.addNo(nos[i]);
        }
        
        Random rand = new Random();
        
        for(i=0; i<tamanho-1; i++) {
            int arestas = rand.nextInt(maxArestas)+1;
            if(i+arestas >= tamanho) {
                arestas = 1;
            }
            List sorteados = new ArrayList<>();
            for(int j=0; j<arestas; j++) {
                int dPos;
                do {
                    dPos = rand.nextInt(maxDistacia)+(i+1);
                } while(sorteados.contains(dPos) || dPos >= tamanho);
                
                sorteados.add(dPos);
                int custo = rand.nextInt(maxCusto-10)+10;
                Aresta.inserirAresta(nos[i], nos[dPos], custo);
            }
        }
        
        return grafo;
    }
}
