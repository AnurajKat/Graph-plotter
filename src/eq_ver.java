/**
 * Created by a2z on 3/7/2017.
 */
import java.util.StringTokenizer;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class eq_ver {
    String eq1;

    eq_ver(String equa) {
        this.eq1 = equa.replaceAll("\\s", "");
    }

    boolean isOperator(char ch) {
        return ch == 37 || ch == 47 || ch == 42 || ch == 43 || ch == 45;
    }

    boolean isOperand(char ch) {
        return ch >= 48 && ch <= 57 || ch >= 97 && ch <= 122;
    }

    String substi(String a, int x) {
        String str = "";
        int len = a.length();

        for(int i = 0; i < len; ++i) {
            if(a.charAt(i) == 120) {
                str = str + x;
            } else {
                str = str + a.charAt(i);
            }
        }

        return str;
    }

    public int calc(String p) {
        StringTokenizer st = new StringTokenizer(p, " ");
        boolean r = false;
        boolean len2 = false;
        String str = "";
        stack_int a = new stack_int(st.countTokens());

        while(true) {
            while(st.hasMoreTokens()) {
                str = st.nextToken();
                int var10 = str.length();
                System.out.println(" out condition str=_" + str + "_");
                int var13;
                if(var10 > 1 && this.isOperand(str.charAt(1)) || this.isOperand(str.charAt(0))) {
                    System.out.println("str=_" + str + "_");
                    String var12 = "";

                    for(var13 = 0; var13 < var10; ++var13) {
                        if(this.isOperator(str.charAt(var13))) {
                            var12 = str.substring(var13, var13 + 2);
                            System.out.println("temp=" + var12);
                            a.push(Integer.parseInt(var12));
                            System.out.println("peek =" + a.peek());
                            var12 = "";
                            ++var13;
                        } else {
                            a.push(str.charAt(var13) - 48);
                        }
                    }
                } else if(this.isOperator(str.charAt(0))) {
                    System.out.println("str=_" + str + "_");
                    boolean x = false;
                    boolean y = false;
                    if(a.sz() >= 1) {
                        int var11 = a.pop();
                        var13 = a.pop();
                        System.out.println("\nx=" + var11 + "\ty=" + var13 + "\n");
                        int var9;
                        switch(str.charAt(0)) {
                            case '*':
                                var9 = var13 * var11;
                                System.out.println("r *=" + var9);
                                a.push(var9);
                                break;
                            case '+':
                                var9 = var11 + var13;
                                System.out.println("r +=" + var9);
                                a.push(var9);
                                break;
                            case ',':
                            case '.':
                            default:
                                r = false;
                                break;
                            case '-':
                                var9 = var13 - var11;
                                System.out.println("r -=" + var9);
                                a.push(var9);
                                break;
                            case '/':
                                var9 = var13 / var11;
                                System.out.println("r /=" + var9);
                                a.push(var9);
                        }
                    }
                }
            }

            return a.pop();
        }
    }

    int result1(int x) {
        String str = this.substi(this.eq1, x);
        return this.calc(str);
    }

    String substitute(int x) throws Exception {
        String str = "";

        for(int i = 0; i < this.eq1.length(); ++i) {
            if(this.eq1.charAt(i) == 120) {
                String temp = "(" + x + ")";
                int ln = temp.length();

                for(int j = 0; j < ln; ++j) {
                    str = str + temp.charAt(j);
                }
            } else {
                str = str + this.eq1.charAt(i);
            }
        }

        return str;
    }

    int result(int x) throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object o = engine.eval(this.substitute(x));
        String pop = o.toString();
        int res = Integer.parseInt(pop);
        return res;
    }
}
