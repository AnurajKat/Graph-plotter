/**
 * Created by a2z on 3/7/2017.
 */
public class stack_int {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public stack_int(int max) {
        this.maxSize = max;
        this.stackArray = new int[this.maxSize];
        this.top = -1;
    }

    public void push(int j) {
        this.stackArray[++this.top] = j;
    }

    public int pop() {
        return this.stackArray[this.top--];
    }

    public int peek() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    int sz() {
        return this.top;
    }
}
