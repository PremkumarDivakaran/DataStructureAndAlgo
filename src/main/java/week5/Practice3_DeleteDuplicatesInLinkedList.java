package week5;

import org.junit.Test;

public class Practice3_DeleteDuplicatesInLinkedList {
    /*
    Pseudocode -
     */

    @Test  //Positive
    public void example1(){
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(7);

        Node out = deleteDuplicates_1(node);

        printAllNodes(out);

    }

    private Node deleteDuplicates(Node node) {
        Node current = node;

        while(current.next!=null){
            if(current.data==current.next.data){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

        return node;
    }

    private Node deleteDuplicates_1(Node node) {
        Node current = node;
        Node out = new Node();

        while(current!=null){
            if(current.data==current.next.data){
                current.next = current.next.next;
            }else {
                out.next = current;
                current = current.next;
            }
        }

        return node;
    }


    public class Node{
        //Node previous;
        Node next;
        int data;

        Node(){
            this.next = null;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void printAllNodes(Node node) {
        Node current = node;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

}
