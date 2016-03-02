package br.bruno.kruskal;

/**
 * Classe principal do programa
 * @author bruno
 */
public class Main {
    
    /**
     * Monta o grafo e busca o menor caminho entre dois pontos
     * @param args
     */
    public static void main(String[] args) { 
       /* Grafo grafo = new Grafo();
        
        No no;
        no = new No("1");//0
        grafo.addNo(no);
        no = new No("2");//1
        grafo.addNo(no);
        no = new No("3");//2
        grafo.addNo(no);
        no = new No("4");//3
        grafo.addNo(no);
        no = new No("5");//4
        grafo.addNo(no);
        no = new No("6");//5
        grafo.addNo(no);
        no = new No("7");//6
        grafo.addNo(no);
        
        //Cria as arestas do nó
        
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(1), 2);
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(2), 5);
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(3), 4);
        Aresta.inserirAresta(grafo.getNo(1), grafo.getNo(2), 2);
        Aresta.inserirAresta(grafo.getNo(1), grafo.getNo(4), 7);
        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(3), 1);
        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(4), 4);
        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(5), 3);
        Aresta.inserirAresta(grafo.getNo(3), grafo.getNo(5), 4);
        Aresta.inserirAresta(grafo.getNo(4), grafo.getNo(5), 1);
        Aresta.inserirAresta(grafo.getNo(4), grafo.getNo(6), 5);
        Aresta.inserirAresta(grafo.getNo(5), grafo.getNo(6), 7);
        
         No no;
        no = new No("SF");//0
        grafo.addNo(no);
        no = new No("LA");//1
        grafo.addNo(no);
        no = new No("D");//2
        grafo.addNo(no);
        no = new No("C");//3
        grafo.addNo(no);
        no = new No("A");//4
        grafo.addNo(no);
        no = new No("B");//5
        grafo.addNo(no);
        no = new No("NY");//6
        grafo.addNo(no);
        no = new No("M");//7
        grafo.addNo(no);
        
        
        //Cria as arestas do nó
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(1), 39);
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(2), 89);
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(3), 120);
        Aresta.inserirAresta(grafo.getNo(0), grafo.getNo(6), 210);
        Aresta.inserirAresta(grafo.getNo(1), grafo.getNo(2), 50);
        Aresta.inserirAresta(grafo.getNo(1), grafo.getNo(6), 170);
        Aresta.inserirAresta(grafo.getNo(2), grafo.getNo(3), 65);
        Aresta.inserirAresta(grafo.getNo(3), grafo.getNo(5), 79);
        Aresta.inserirAresta(grafo.getNo(3), grafo.getNo(6), 59);
        Aresta.inserirAresta(grafo.getNo(3), grafo.getNo(4), 99);
        Aresta.inserirAresta(grafo.getNo(4), grafo.getNo(6), 80);
        Aresta.inserirAresta(grafo.getNo(4), grafo.getNo(7), 70);
        Aresta.inserirAresta(grafo.getNo(5), grafo.getNo(6), 20);
        Aresta.inserirAresta(grafo.getNo(6), grafo.getNo(7), 66);*/
       
        Grafo grafo = GrafoAleatorioKruskal.gerar(10000, 20, 25, 100);
        //Gera a arvore geradora com custo minimo
        grafo.kruskal();
        
        //TESTE
        int teste = grafo.getNo(0).getConjunto();
        boolean answer = true;
        for(No n : grafo.getNos()){
            if (teste!= n.getConjunto()){
                answer = false;
            }
        }
        if(answer){
            System.out.println("Todos os nós pertecem ao mesmo conjunto");
        }
        else{
            System.out.println("Deu erro");
        }
    }
}