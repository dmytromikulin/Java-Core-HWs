class MyArrayList {
    private Object[] elements;
    private int size;

    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(Object value) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = value;
        size++;
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        System.out.println("Size: " + list.size());

        list.remove(1);
        System.out.println(list.get(1));
        System.out.println("Size after removal: " + list.size());

        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}