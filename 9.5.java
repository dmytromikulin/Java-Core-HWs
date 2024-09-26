class MyHashMap {
    private class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;
    private int capacity = 16;
    private int size = 0;

    public MyHashMap() {
        table = new Node[capacity];
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public void remove(Object key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
}

class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Size: " + map.size());

        System.out.println("Value for 'One': " + map.get("One"));
        System.out.println("Value for 'Two': " + map.get("Two"));

        map.remove("Two");

        System.out.println("Size after removal: " + map.size());

        System.out.println("Value for 'Two' after removal: " + map.get("Two"));

        map.clear();
        System.out.println("Size after clear: " + map.size());
    }
}
