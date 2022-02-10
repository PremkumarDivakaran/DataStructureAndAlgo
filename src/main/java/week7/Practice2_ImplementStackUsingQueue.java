package week7;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice2_ImplementStackUsingQueue {

    class MyStack {

        Deque<Integer> deque = new ArrayDeque<>();

        public MyStack() {

        }

        public void push(int x) {
            deque.offer(x);
            int n = deque.size();
            while(n>1){
                deque.offer(deque.poll());
                n--;
            }
        }

        public int pop() {
            return deque.poll();
        }

        public int top() {
            return deque.peek();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }

    @Test
    public void testRunner(){
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.top());

        stack.pop();
        stack.pop();
        System.out.println(stack.top());

        stack.pop();
        System.out.println(stack.empty());
    }

}
