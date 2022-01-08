package week5;

import org.junit.Test;

public class Practice5_RemoveElementsFromLinkedList {
    /*
    Pseudocode -
     */

    @Test  //Positive
    public void example1(){
        Node node = addNode(1);
        node.next = addNode(1);
        node.next.next = addNode(1);
        node.next.next.next = addNode(1);
        node.next.next.next.next = addNode(1);
        node.next.next.next.next.next = addNode(1);
        node.next.next.next.next.next.next = addNode(1);

        //Node node = new Node();

        /*System.out.println(node.data);
        System.out.println(node.next);*/

        Node out = removeElements(node,1);

        printAllNodes(out);

    }

    private Node addNode(int data){
        return new Node(data);
    }

    private Node removeElements(Node node, int data) {
        while(node!=null && node.data==data){
            node = node.next;
        }
        if(node==null || node.next==null) return node;

        Node current = node;
        while(current.next!=null){
            if(current.next.data==data && current.next.next==null){
                current.next = null;
                break;
            } else if(current.next.data==data && current.next.next!=null){
                while(current.next!=null && current.next.data==data){
                    current.next = current.next.next;
                }
            }else current = current.next;
        }
        return node;
    }


    public class Node{
        //Node previous;
        Node next;
        int data;

        Node(){
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
