package Stack;

public class Stack {
    private int size = 0;
    private int[] elements = new int[2];

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int element) {
        this.elements[size++] = element;
    }

    public int pop() {
        if (isEmpty())
            throw new UnderflowException();
        return elements[--size];
    }

    public int peek() {
        if (isEmpty())
            throw new UnderflowException();
        return elements[size - 1];
    }

    public class UnderflowException extends RuntimeException {
    }
}
