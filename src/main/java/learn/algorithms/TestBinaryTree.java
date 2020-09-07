package learn.algorithms;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TestBinaryTree {

    public static void main(String[] args) {
        Character[] array = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L','M','N','O'};
        BinaryNode gen = new BinaryNode(array[0], null);
        transformArray(array, 0, gen);


//        preOrder(gen);
//        System.out.println("");
//        midOrder(gen);
//        System.out.println("");
//        postOrder(gen);

        int i =0, j =0;
        ArrayQueue<BinaryNode> queue = new ArrayQueue<>(100);
        queue.add(gen);
        cengOrder(gen, queue, 0, 0);
        System.out.println(queue.size());
    }

    public static void transformArray(Character[] array, int parentIndex, BinaryNode parent) {
        int leftIndex = 2*parentIndex + 1;
        if (leftIndex < array.length) {
            parent.leftChild= new BinaryNode(array[leftIndex], parent);
            transformArray(array, leftIndex, parent.leftChild);
        }

        int rightIndex = 2*parentIndex + 2;
        if (rightIndex < array.length) {
            parent.rightChild= new BinaryNode(array[rightIndex], parent);
            transformArray(array, rightIndex, parent.rightChild);
        }
    }

    public static void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.value + ",");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public static void midOrder(BinaryNode node) {
        if (node == null) {
            return;
        } else {
            midOrder(node.leftChild);
            System.out.print(node.value + ",");
            midOrder(node.rightChild);
        }
    }

    public static void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.value + ",");
        }
    }

    public static void cengOrder(BinaryNode node, ArrayQueue<BinaryNode> queue, int i, int j) {

//        System.out.println(queue.get(j));
        if (node.leftChild != null) {
            j++;
            queue.add(node.leftChild);
            System.out.println(queue.get(j).value);
        }

        if (node.rightChild !=null) {
            j++;
            queue.add(node.rightChild);
            System.out.println(queue.get(j).value);
        }
        if (i != j) {
            i++;
            cengOrder(queue.get(i), queue, i, j);
        }
    }

}

class BinaryNode {

    public BinaryNode(Character value, BinaryNode parent) {
        this.value = value;
        this.parent = parent;
    }

    Character value;
    BinaryNode parent;
    BinaryNode leftChild;
    BinaryNode rightChild;
}
