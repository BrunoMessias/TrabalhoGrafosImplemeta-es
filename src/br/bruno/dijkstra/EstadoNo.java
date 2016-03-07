package br.bruno.dijkstra;

/**
 * Estados de um nó no algoritmo de Dijkstra
 * @author bruno
 */
public enum EstadoNo {
    /**
     * O nó está aberto
     */
    ABERTO,
    /**
     * O nó está fechado
     */
    FECHADO,
    /**
     * O nó foi visitado
     */
    VISITADO
}
