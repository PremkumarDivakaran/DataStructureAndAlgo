package week5;

import org.junit.Test;

public class Practice4_RemoveDuplicatesInLinkedList {
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

        Node out = deleteDuplicates(node);

        printAllNodes(out);

    }

    private Node deleteDuplicates(Node node) {
        Node current = node;

        while(current.next!=null){
            if(current.data==current.next.data){

            }else{

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
