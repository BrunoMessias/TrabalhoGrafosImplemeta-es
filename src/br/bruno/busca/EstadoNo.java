package br.bruno.busca;

/**
 * Estados de um nó em uma busca
 * @author tiago
 */
public enum EstadoNo {
    /**
     * Ainda não chegou a esse nó
     */
    DESMARCADO,
    /**
     * Encontrou esse nó
     */
    DESCOBERTO,
    /**
     * Já encontrou todos os vizinhos desse nó
     */
    EXPLORADO
}
