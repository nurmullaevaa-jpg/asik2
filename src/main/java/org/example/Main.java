package org.example;

public class Main {
    public static void main(String[] args) {
        // Testing MyArrayList
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(50);
        arrayList.add(10);
        arrayList.add(30);
        System.out.println("Size: " + arrayList.size());
        arrayList.sort();
        System.out.println("After sort (index 0): " + arrayList.get(0));
        System.out.println();

        // Testing MyLinkedList
        System.out.println("Testing MyLinkedList:");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.addFirst("Node 1");
        linkedList.addLast("Node 2");
        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());
        System.out.println();

        // Testing MyStack (LIFO)
        System.out.println("Testing MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Popped (LIFO): " + stack.pop());
        System.out.println();

        // Testing MyQueue (FIFO)
        System.out.println("Testing MyQueue:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);
        System.out.println("Dequeued (FIFO): " + queue.dequeue());
        System.out.println();

        // Testing MyMinHeap
        System.out.println("Testing MyMinHeap:");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(15);
        heap.insert(5);
        heap.insert(10);
        System.out.println("Min extracted: " + heap.extractMin());
    }
}