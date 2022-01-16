package week5;

import org.junit.Test;

public class Practice1_LinkedList_Odd {
    /*
    Pseudocode -
     */

    @Test  //Positive
    public void example1(){
        Node head = new Node(1);
        head.next = new Node(11);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(9);

        Node out = reverseNode(head);
        printAllNodes(out);
    }

    @Test  //Positive
    public void example2(){
        Node head = new Node(1);
        head.next = new Node(11);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        //printAllNodes(head);
        Node tail = reverseNode(head);
        printAllNodes(tail);

    }

    private void printAllNodes(Node node) {
        Node current = node;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public class Node{
        //Node previous;
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void findOddNode(Node node){
        Node current = node;
        int start = 1;
        while(current!=null){
            //if(start%2!=0) System.out.println(current.data);
            System.out.println(current.data);
            current=current.next.next;
            //start++;
        }
    }

    private void findOddNumber(Node node){
        Node current = node;
        while(current!=null){
            if(current.data%2 != 0) System.out.println(current.data);
            current=current.next.next;
        }
    }

    private Node reverseNode(Node node){
        Node current = node, previous = null, next = null;
        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}
