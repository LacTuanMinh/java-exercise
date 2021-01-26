package collection;

public class TelevisionShowLinkedListImpl implements TelevisionShowLinkedList {

    private int size = 0;

    private Node head = null;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(TelevisionShow show) {

        Node newNode = new Node(show);

        if (this.head == null) {
            size++;
            head = newNode;
            return true;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, TelevisionShow show) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(show);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        if(index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    @Override
    public TelevisionShow get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.show;
    }

    @Override
    public boolean contains(TelevisionShow show) {
        return indexOf(show) >= 0;
    }

    @Override
    public int indexOf(TelevisionShow show) {

        for(int i = 0; i< size;i++) {
            if(get(i).equals(show))
            {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean remove(TelevisionShow show) {
       return remove(indexOf(show)) != null;
    }

    @Override
    public TelevisionShow remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;

        if (index == 0) {
            head = head.next;
            size--;
            return temp.show;
        }

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node returnedNode =  temp.next;
        temp.next = temp.next.next;
        size--;
        return returnedNode.show;

    }

    private class Node {
        TelevisionShow show;
        Node next;

        Node(TelevisionShow show) {
            this.show = show;
            next = null;
        }
    }
}
