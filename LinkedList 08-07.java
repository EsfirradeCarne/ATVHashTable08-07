package linked_link;

public class SimpleLinkedList<T> {

    private BST<T> bst;
    private int size;

    public SimpleLinkedList() {
        this.bst = new BST<T>();
        this.size = 0;
    }

    public void insert(T value, int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException("");
        }
        bst.insert(value);
        this.size++;
    }

    public T get(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException("");
        }
        return bst.find(idx);
    }

    @Override
    public String toString() {
        return bst.toString();
    }

    public static void main(String[] args) {
        SimpleLinkedList<String> sll = new SimpleLinkedList<String>();
        sll.insert("aa", 0);
        sll.insert("bb", 0);
        sll.insert("cc", 2);
        sll.insert("dd", 1);
        System.out.println(sll.toString());

        System.out.println(sll.get(0));
        System.out.println(sll.get(1));
        System.out.println(sll.get(2));
        System.out.println(sll.get(3));
        System.out.println(sll.get(4));
    }

}