package com.company;

import java.util.Arrays;

public class MyIntArrayList {

    private int[] elements;
    private int size;

    public MyIntArrayList() {
        this(10);
    }

    public MyIntArrayList(int initialCapacity) {
        this.elements = new int[initialCapacity];
        this.size = initialCapacity;
    }

    public MyIntArrayList(MyIntArrayList c) {
        this.elements = c.elements;
        this.size = c.size;
    }

    public void add(int index, int e) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to" +
                    " add element at position " + index);
            return;
        }

        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size + 1);
        }

        for (int i = this.elements.length - 1; i >= index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = e;
        size++;
    }

    public boolean add(int e) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size + 1);
        }

        this.elements[size] = e;
        this.size++;

        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to" +
                    " get element at position " + index);
            return -1;
        }
        return this.elements[index];
    }

    public int indexOf(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        for (int i = this.elements.length - 1; i >= 0; i--) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int e) {
        if (this.indexOf(e) != -1) {
            for (int i = indexOf(e); i < this.elements.length - 1; i++) {
                this.elements[i] = this.elements[i + 1];
            }
            this.elements = Arrays.copyOf(this.elements, this.size - 1);
            this.size--;
            return true;
        }
        return false;
    }

    public int removeElementAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to" +
                    " remove element at position " + index);
            return -1;
        }

        int removedElement = this.elements[index];
        for (int i = index; i < this.elements.length - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements = Arrays.copyOf(this.elements, this.size - 1);
        this.size--;

        return removedElement;
    }

    public void clear() {
        this.size = 0;
    }

    public int set(int index, int e) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to set" +
                    " the element " + e + " at position " + index);
            return -1;
        }

        int replacedElement = this.elements[index];
        this.elements[index] = e;
        return replacedElement;
    }

    public boolean addAll(MyIntArrayList c) {
        if (c.size == 0) {
            System.out.println("NullPointerException");
            return false;
        }
        int lastIndex = this.elements.length;
        this.elements = Arrays.copyOf(this.elements, this.elements.length + c.elements.length);

        for (int i = 0; i < c.elements.length; i++) {
            this.elements[lastIndex + i] = c.elements[i];
            size++;
        }
        return true;

    }

    public boolean addAll(int index, MyIntArrayList c) {
        if (c.size == 0) {
            System.out.println("NullPointerException");
            return false;
        }
        int lastIndex = this.elements.length;
        this.elements = Arrays.copyOf(this.elements, this.elements.length + c.elements.length);

        for (int i = 0; i < c.elements.length; i++) {
            this.elements[lastIndex + i] = this.elements[i];
        }

        for (int i = 0; i < c.elements.length; i++) {
            this.elements[index + i] = c.elements[i];
            size++;
        }
        return true;
    }

    public int[] toArray() {
        int[] result = this.elements;
        return result;
    }

    public void ensureCapacity(int minCapacity) {
        this.size = minCapacity;
    }

    public void trimToSize() {
        this.size = this.elements.length;
    }
}