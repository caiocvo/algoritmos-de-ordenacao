/**
 * Disciplina: Engenharia de Dados
 * Alunos: Caio César Santos Carvalho, Eduardo Lopes Chagas, Naabi Anne Ribeiro Rodrigues
 * Data: 08/06/2026
 * Objetivo: Classe que representa o objeto a ser ordenado pelos algoritmos,
 *           encapsulando um valor inteiro e definindo sua ordem natural via Comparable.
 */

public record Item(int valor) implements Comparable<Item> {
    @Override
    public int compareTo(Item outro) {
        return Integer.compare(this.valor, outro.valor);
    }
}