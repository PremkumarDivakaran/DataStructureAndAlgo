package week5;

import org.junit.Test;

public class Practice2_MergeLinkedList {
    /*
    Pseudocode -
     */

    @Test  //Positive
    public void example1(){
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(7);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(6);
        node2.next.next.next = new Node(8);

        Node head = mergeLinkedList(node1,node2);

        printAllNodes(head);

    }

    private Node mergeLinkedList(Node node1, Node node2) {
        Node merged=new Node();
        Node out = merged;

        while(node1!=null && node2!=null){
            if(node1.data<node2.data){
                out.next = node1;
                node1 = node1.next;
            }else {
                out.next = node2;
                node2 = node2.next;
            }
            out = out.next;
        }

        /*if(node1==null) out.next = node2;
        else out.next = node1;*/

        out.next = node1==null ? node2 : node1;

        return merged.next;
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
