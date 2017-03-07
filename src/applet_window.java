/**
 * Created by a2z on 3/7/2017.
 */
import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class applet_window extends Applet implements ActionListener {
    TextField eqField;
    Button okbutton;
    TextField x_axis;
    TextField y_axis;
    CheckboxGroup radioGroup;
    Checkbox radio1;
    Checkbox radio2;

    public applet_window() {
    }

    public void init() {
        this.setSize(1080, 640);
        this.setLayout((LayoutManager) null);
        this.radioGroup = new CheckboxGroup();
        this.okbutton = new Button("okay");
        this.eqField = new TextField("Enter Equation");
        this.x_axis = new TextField("Name of Y-Axis");
        this.y_axis = new TextField("Name of X-Axis");
        this.radio1 = new Checkbox("only positive", this.radioGroup, false);
        this.radio2 = new Checkbox("including negative", this.radioGroup, false);
        this.eqField.setBounds(870, 75, 160, 20);
        this.x_axis.setBounds(870, 125, 100, 20);
        this.y_axis.setBounds(870, 175, 100, 20);
        this.radio1.setBounds(880, 350, 100, 20);
        this.radio2.setBounds(880, 375, 115, 20);
        this.okbutton.setBounds(900, 550, 75, 25);
        this.add(this.eqField);
        this.add(this.radio1);
        this.add(this.radio2);
        this.add(this.okbutton);
        this.okbutton.addActionListener(this);
    }

    public void paint(Graphics G) {
        G.drawString(this.x_axis.getText(), 500, 650);
        short c_x_graph = 450;
        short c_y_graph = 320;
        String eq1 = this.eqField.getText();
        int a;
        int e;
        int x1;
        int y1;
        int x2;
        int var18;
        if (this.radio1.getState()) {
            try {
                G.drawLine(50, 0, 50, 600);
                G.drawLine(50, 600, 850, 600);

                String obj2;
                for (a = 0; a < 35; ++a) {
                    e = 600 - a * 20;
                    G.drawLine(45, e, 50, e);
                    obj2 = "" + a;
                    G.drawString(obj2, 30, e + 5);
                }

                for (a = 0; a <= 10; ++a) {
                    e = 50 + a * 75;
                    G.drawLine(e, 600, e, 605);
                    obj2 = "" + a;
                    G.drawString(obj2, e - 5, 618);
                }

                get_table var16 = new get_table(10, eq1);
                var16.set_table_pos();
                e = 50;
                var18 = 600;

                for (x2 = 0; x2 < 11; ++x2) {
                    x1 = 50 + x2 * 75;
                    y1 = 600 - var16.ret_val(x2) * 20;
                    String y2 = "" + x2 + "     " + var16.ret_val(x2);
                    G.drawString(y2, 870, 125 + x2 * 15);
                    G.drawLine(e, var18, x1, y1);
                    e = x1;
                    var18 = y1;
                }
            } catch (Exception var15) {
                var15.printStackTrace();
                G.drawString("Error Occured. :(", 500, 250);
            }
        } else if (this.radio2.getState()) {
            boolean var17 = false;

            try {
                G.drawLine(c_x_graph, 50, c_x_graph, 620);
                G.drawLine(50, c_y_graph, 850, c_y_graph);

                String var19;
                for (e = 0; e < 28; ++e) {
                    var18 = 600 - e * 20;
                    G.drawLine(c_x_graph - 5, var18, c_x_graph + 5, var18);
                    if (e != 14) {
                        var19 = "" + (e - 14);
                        G.drawString(var19, c_x_graph - 19, var18 + 5);
                    }

                    a = e - 14;
                }

                for (e = 0; e <= 20; ++e) {
                    var18 = 50 + e * 40;
                    G.drawLine(var18, c_y_graph + 5, var18, c_y_graph - 5);
                    var19 = "" + (e - 10);
                    G.drawString(var19, var18 - 10, c_y_graph + 15);
                }

                get_table var20 = new get_table(12, eq1);
                get_table var21 = new get_table(12, eq1);
                var20.set_table_pos();
                var21.set_table_neg();
                x1 = c_x_graph;
                y1 = c_y_graph;

                int i;
                String str;
                int var22;
                for (i = 0; i <= 10; ++i) {
                    x2 = c_x_graph + i * 40;
                    var22 = c_y_graph - var20.ret_val(i) * 20;
                    str = "" + i + "     " + var21.ret_val(i);
                    G.drawString(str, 870, 125 + i * 15);
                    G.drawLine(x1, y1, x2, var22);
                    x1 = x2;
                    y1 = var22;
                }

                x1 = c_x_graph;
                y1 = c_y_graph;

                for (i = 0; i <= 10; ++i) {
                    x2 = c_x_graph - i * 40;
                    var22 = c_y_graph - var21.ret_val(i) * 20;
                    if (i != 0) {
                        str = "-" + i + "     " + var21.ret_val(i);
                    } else {
                        str = "" + i + "     " + var21.ret_val(i);
                    }

                    G.drawString(str, 970, 125 + i * 15);
                    G.drawLine(x1, y1, x2, var22);
                    x1 = x2;
                    y1 = var22;
                }
            } catch (Exception var14) {
                var14.printStackTrace();
                G.drawString("Error Occured. :(", 500, 250);
            }
        }

    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == this.okbutton) {
            this.repaint();
        }

    }
}