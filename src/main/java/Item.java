public record Item(int valor) implements Comparable<Item> {

    @Override
    public int compareTo(Item outro) {
        return Integer.compare(this.valor, outro.valor);
    }
}