import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        var head = createLinkedList(4, 3, 9, 1);
        printReversedRecursively(head);
        printReversedUsingStack(head);
    }

    /**
     * Creates a list of linked {@link Node} objects based on the given array of elements and returns a head of the list.
     *
     * @param elements an array of elements that should be added to the list
     * @param <T>      elements type
     * @return head of the list
     */
    public static <T> Node<T> createLinkedList(T... elements) {
        var hed = new Node<>(elements[0]);
        var current = hed;
        for (int i = 1; i < elements.length; i++) {
            current.setNext(new Node<>(elements[i]));
            current = current.getNext();
        }
        return hed;
    }
    /**
     * Prints a list in a reserved order using a recursion technique. Please note that it should not change the list,
     * just print its elements.
     * <p>
     * Imagine you have a list of elements 4,3,9,1 and the current head is 4. Then the outcome should be the following:
     * 1 -> 9 -> 3 -> 4
     *
     * @param head the first node of the list
     * @param <T>  elements type
     */
    public static <T> void printReversedRecursively(Node<T> head) {
        print(head.getNext());
        System.out.print(head.getElement());
    }

    private static <T> void print(Node<T> node) {
        if (node == null) return;
        print(node.getNext());
        System.out.print(node.getElement() + " -> ");
    }

    /**
     * Prints a list in a reserved order using a {@link java.util.Stack} instance. Please note that it should not change
     * the list, just print its elements.
     * <p>
     * Imagine you have a list of elements 4,3,9,1 and the current head is 4. Then the outcome should be the following:
     * 1 -> 9 -> 3 -> 4
     *
     * @param head the first node of the list
     * @param <T>  elements type
     */
    public static <T> void printReversedUsingStack(Node<T> head) {
        if (head == null) {
            return;
        }
        printLinkedList(head.getNext());
        System.out.println(head.getElement());
    }

    private static <T> void printLinkedList(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getNext();
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().getElement() + " -> ");
        }
    }
}