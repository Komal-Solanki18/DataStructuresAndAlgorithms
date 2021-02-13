package datastructures.linear.lists.linked.singly;

import datastructures.linear.lists.ListADT;
import datastructures.linear.lists.linked.singly.node.Node;

public class SinglyLinkedList<E> implements ListADT<E> {

    /*
     * This head reference variable will
     * 1. Store the reference value for the first node object in the linked list.
     * 2. Keep track of the first node in the linked list in case it is changed anytime.
     * */
    private Node<E> head = null;

    /*
     * This size variable will keep the count of the total number of nodes in the linked list except the head node.
     * */
    private int size = 0;

    @Override
    public boolean add(E item) {
        return false;
    }

    /**
     * This method will add an item node in the linked list at the given item.
     *
     * @param index The index of the linked list at which the node is to be added.
     * @param item  The data value of the node to be created and added to the linked list.
     * @throws IndexOutOfBoundsException If the index is negative or greater than the size.
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            // throw the IndexOutOfBoundsException if the index given is incorrect.
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            // the node is to be added at the first index, call the addFirst() method
            addFirst(item);
        } else {
            // the node is to be added somewhere after a given node
            // firstly, get the node after which we have to add a new node.
            Node<E> previousNode = getNode(index - 1);
            // call the addAfter() method to add the node after 'temp'.
            addAfter(previousNode, item);
        }
    }

    /**
     * This method will add an item node to the beginning of the linked list.
     * Since the programmer is only giving us the item(the data value) and NOT
     * the node itself, we would have to create a node. Since, the linked list can only
     * operate on nodes.
     *
     * @param item This is the data value of the node to be created and added to the linked list.
     */
    private void addFirst(E item) {
        /*
         * The code following these comments is the summation of the two lines of code
         * written inside the comments.
         * Node<E> n1 = new Node<E>(item, null);
         * head = n1;
         * */
        head = new Node<>(item, head);
        // increase the size of the linked list
        size++;
    }

    /**
     * This method will add an item node after a given node in the linked list.
     * Similar to the addFirst() method, this method also receives only the data value, so we
     * would have create a node and then send it to the linked list to be added after the
     * given node.
     *
     * @param node The node after which the new node is to be added.
     * @param item The data value of the node to be created and added to the linked list.
     */
    private void addAfter(Node<E> node, E item) {
        /*
         * The code following these comments is the summation of the two lines of code
         * written inside the comments.
         * Node<E> n1 = new Node<E>(item, node.next);
         * node.setNext(n1);
         * */
        node.setNext(new Node<>(item, node.getNext()));
        // increase the size of the linked list
        size++;
    }


    @Override
    public E remove() {
        return null;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * This method will return a node at the specified index from the linked list.
     *
     * @param index An non-negative index from the linked list.
     * @return The node at the specified index.
     */
    private Node<E> getNode(int index) {
        Node<E> currentNode = head;
        /*
         * using a loop to traverse the whole linked list,
         * the loop will run until i is less than the size of the linked list,
         * AND
         * the current node traversed is not equal to null.
         * */
        for (int i = 0; i < index; i++) {
            // change the reference value of the response variable to the next node
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
}
