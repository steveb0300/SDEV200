// M04 - Programming Assignment 3
// Exercise 24.3
// Implement a doubly linked list

import java.util.ListIterator;
import java.util.Scanner;

public class DoublyLinkedList {

    public static void main(String[] args) {
        new DoublyLinkedList();
    }
    
    public DoublyLinkedList() {
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
        System.out.print("Enter five numbers: ");
        Scanner input = new Scanner(System.in);
        double[] v = new double[5];
        for (int i = 0; i < 5; i++) {
            v[i] = input.nextDouble();
        }

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        input.close();

        ListIterator<Double> iterator1 = list.iterator();
        System.out.print("The list in forward order: ");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        ListIterator<Double> iterator2 = list.iterator(list.size() - 1);
        System.out.print("\nThe list in backward order: ");
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous() + " ");
        }
        System.out.println();
    }
    /*
    public static void main(String[] args) {

        TwoWayLinkedList<Integer> linkedList = new TwoWayLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(3);
        linkedList.addFirst(5);
        linkedList.addFirst(7);
        linkedList.addFirst(9);
        linkedList.addLast(1);
        linkedList.removeFirst(); // remove 9
        linkedList.removeFirst(); // remove 7
        linkedList.removeLast();  // remove 1

        Iterator<Integer> iterator1 = linkedList.iterator();
        // 5 3 1
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        Iterator<Integer> iterator2 = linkedList.iterator(1);
        // 3 1
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println();
    }
    */
}

