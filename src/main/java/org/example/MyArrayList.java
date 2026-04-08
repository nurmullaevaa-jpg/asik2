package org.example;
import org.example.MyList;

import java.util.Iterator;
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[5];
        this.size = 0;
    }

    // Базовые методы
    @Override
    public int size() { return size; }

    @Override
    public void add(T item) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    // Реализация методов удаления
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    @Override
    public void removeFirst() {
        if (size > 0) remove(0);
    }

    @Override
    public void removeLast() {
        if (size > 0) remove(size - 1);
    }

    // Методы добавления
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    // Геттеры
    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override public void set(int index, T item) { elements[index] = item; }
    @Override public void sort() {}
    @Override public int indexOf(Object object) { return -1; }
    @Override public int lastIndexOf(Object object) { return -1; }
    @Override public boolean exists(Object object) { return false; }
    @Override public Object[] toArray() { return new Object[0]; }
    @Override public void clear() { size = 0; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            public T next() { return (T) elements[cursor++]; }
        };
    }
}