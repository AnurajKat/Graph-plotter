/**
 * Created by a2z on 3/7/2017.
 */
public class stack_char {
    private int maxSize;
    private String[] stackArray;
    private int top;

    public stack_char(int max) {
        this.maxSize = max;
        this.stackArray = new String[this.maxSize];
        this.top = -1;
    }

    public void spp_push(String t) {
        this.stackArray[++this.top] = t;
    }

    public void push(String j) {
        this.stackArray[++this.top] = j;
    }

    public String pop() {
        return this.stackArray[this.top--];
    }

    public String peek() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }
}
