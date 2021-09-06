/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. Implement the MinStack class:
MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:
-2^31 <= val <= 2^31 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
    
Link: https://leetcode.com/problems/min-stack/ */

//Using 2 Stacks
class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> min_value;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min_value = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(min_value.isEmpty() || val <= min_value.peek()) {
            min_value.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min_value.peek().equals(stack.peek())) {
            min_value.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_value.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */