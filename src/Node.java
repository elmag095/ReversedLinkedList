import java.util.Objects;

public class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(element, node.element) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, next);
    }
}
