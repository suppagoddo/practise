import java.util.*;

/**
 * Created by uagrawal on 10/6/15.
 */
public class DataStructure {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.peek();
        stack.pop();
        stack.empty();

        Queue<String> queue = new LinkedList<String>();
        queue.add("helo");
        queue.poll();

        Queue<Integer> que = new PriorityQueue<Integer>();
        que.add(4);

        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
        queue1.add(3);
        queue1.add(1);
        queue1.add(2);

        System.out.print(queue1.poll() + "," + queue1.poll() + "," + queue1.poll());

    }
}
