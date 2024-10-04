public class Pilha {
    private int[] pilha;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        pilha = new int[capacidade];
        topo = -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public void push(int valor) {
        if (isFull()) return;
        pilha[++topo] = valor;
    }

    public int pop() {
        if (isEmpty()) return -1;
        return pilha[topo--];
    }
}