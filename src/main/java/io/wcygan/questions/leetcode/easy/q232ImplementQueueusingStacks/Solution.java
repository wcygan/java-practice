package io.wcygan.questions.leetcode.easy.q232ImplementQueueusingStacks;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * Difficulty: Easy
 * URL: https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * &nbsp;
 * Example 1:
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * &nbsp;
 * Constraints:
 * 1 <= x <= 9
 * At most 100&nbsp;calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 * &nbsp;
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
class MyQueue {

    // Keep new items (reorder on insert)
    Stack<Integer> in = new Stack<>();

    // Keep next item to remove
    Stack<Integer> out = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        if (out.empty()) {
            out.push(x);
            return;
        }

        int size = in.size();

        for (int i = 0; i < size; i++) {
            out.push(in.pop());
        }

        in.push(x);

        for (int i = 0; i < size; i++) {
            in.push(out.pop());
        }
    }

    public int pop() {
        int returnValue = out.pop();

        if (!in.empty()) {
            out.push(in.pop());
        }

        return returnValue;
    }

    public int peek() {
        return out.peek();
    }

    public boolean empty() {
        return out.empty();
    }
}
