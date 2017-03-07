/**
 * Created by a2z on 3/7/2017.
 */


public class infix_to_postfix {
    private stack_char theStack;
    private String input;
    private String output = "";

    public infix_to_postfix(String in) {
        this.input = in;
        int stackSize = this.input.length();
        this.theStack = new stack_char(stackSize);
    }

    public String doTrans(int x) {
        for(int j = 0; j < this.input.length(); ++j) {
            char ch = this.input.charAt(j);
            switch(ch) {
                case '(':
                    this.theStack.push("" + ch);
                    break;
                case ')':
                    this.gotParen(ch);
                    break;
                case '*':
                case '/':
                    this.gotOper(ch, 2);
                    break;
                case '+':
                case '-':
                    this.gotOper(ch, 1);
                    break;
                case ',':
                case '.':
                default:
                    this.output = this.output + ch;
            }
        }

        while(!this.theStack.isEmpty()) {
            this.output = this.output + this.theStack.pop();
        }

        System.out.println("output=" + this.output);
        return this.output;
    }

    public void gotOper(char opThis, int prec1) {
        while(true) {
            if(!this.theStack.isEmpty()) {
                String pol = this.theStack.pop();
                char opTop = pol.charAt(0);
                if(opTop == 40) {
                    this.theStack.push(" " + pol);
                } else {
                    byte prec2;
                    if(opTop != 43 && opTop != 45) {
                        prec2 = 2;
                    } else {
                        prec2 = 1;
                    }

                    if(prec2 >= prec1) {
                        this.output = this.output + " " + pol + " ";
                        continue;
                    }

                    this.theStack.push(" " + pol);
                }
            }

            this.theStack.push(" " + opThis);
            return;
        }
    }

    public void gotParen(char ch) {
        while(true) {
            if(!this.theStack.isEmpty()) {
                String temp = this.theStack.pop();
                System.out.println("at paren" + temp);
                char chx = temp.charAt(0);
                if(chx != 40) {
                    this.output = this.output + temp;
                    continue;
                }
            }

            return;
        }
    }
}
