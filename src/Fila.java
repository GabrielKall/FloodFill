public class Fila {
    private int[] fila;
    private int tamanho;
    private int inicio;
    private int fim;
    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        fila = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void enqueue(int valor) {
        if (isFull()) return;
        fim = (fim + 1) % capacidade;
        fila[fim] = valor;
        tamanho++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int valorRemovido = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return valorRemovido;
    }
}