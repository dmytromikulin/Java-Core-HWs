class MyQueue {
    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public Object poll() {
        if (head == null) {
            return null;
        }
        Object value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
}

class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        System.out.println("Size: " + queue.size());

        System.out.println("Peek: " + queue.peek());

        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());

        System.out.println("Size after poll: " + queue.size());

        System.out.println("Peek after poll: " + queue.peek());

        queue.clear();
        System.out.println("Size after clear: " + queue.size());
    }
}