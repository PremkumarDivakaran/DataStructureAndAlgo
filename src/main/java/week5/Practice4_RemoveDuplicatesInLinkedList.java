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
        node.next.next = new Node(1);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next = new Node(5);

        Node out = deleteDuplicates(node);

        printAllNodes(out);

    }

    private Node deleteDuplicates(Node node) {
        if(node==null || node.next==null) return node;

        Node out = new Node();
        Node uniqueNodes = out;
        boolean isSame = false;

        Node prev = node;
        Node curr = node.next;

        while(curr!=null){
            if(prev.data!=curr.data) {
                if(!isSame) {
                    uniqueNodes.next = prev;
                    uniqueNodes = uniqueNodes.next;
                }
                isSame = false;
            }else{
                uniqueNodes.next = null;
                isSame = true;
            }
            if(curr.next==null && !isSame) uniqueNodes.next = curr;

            prev = prev.next;
            curr = curr.next;
        }

        return out.next;
    }


    public class Node{
        //Node previous;
        Node next;
        int data;

        Node(){}

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
