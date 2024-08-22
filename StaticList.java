public class StaticList {
    private int[] data; 
    private int size;  


    public StaticList(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser maior que 0.");
        }
        this.data = new int[size];
        this.size = 0;
    }

    public void clear() {
        this.size = 0;
    }

    public void add(int value) {
        if (isFull()) {
            throw new IllegalStateException("A lista está cheia.");
        }
        this.data[size] = value;
        size++;
    }

    public void add(int value, int pos) {
        if (isFull()) {
            throw new IllegalStateException("A lista está cheia.");
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = value;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean isFull() {
        return size == data.length;
    }

    public void setData(int value, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        this.data[pos] = value;
    }

    public int getData(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        return this.data[pos];
    }


    public int getSize() {
        return size;
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {
        StaticList list = new StaticList(10);

        list.add(5);
        list.add(10);
        list.add(15);

        list.add(7, 1);

        System.out.println("Lista após inserções:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Elemento na posição " + i + ": " + list.getData(i));
        }

        int index = list.find(10);
        System.out.println("O elemento 10 está na posição: " + index);

        list.remove(1);

        System.out.println("Lista após remoção:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Elemento na posição " + i + ": " + list.getData(i));
        }

        list.clear();
        System.out.println("Lista após limpar:");
        System.out.println("Tamanho da lista: " + list.getSize());
    }
}
