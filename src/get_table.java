/**
 * Created by a2z on 3/7/2017.
 */
public class get_table  extends eq_ver {
    int[][] table1;
    int len;
    String s;

    get_table(int a, String b) {
        super(b);
        this.s = b;
        this.len = a + 1;
        this.table1 = new int[this.len][2];
    }

    void set_table_pos() throws Exception {
        for(int i = 0; i < this.len; ++i) {
            this.table1[i][0] = i;
            this.table1[i][1] = super.result(i);
        }

    }

    void set_table_neg() throws Exception {
        int c = this.len / 2;

        for(int i = 0; i < this.len; ++i) {
            this.table1[i][0] = i;
            this.table1[i][1] = super.result(-i);
        }

    }

    void set_table_inpost_neg() throws Exception {
        int c = this.len / 2;

        for(int i = 0; i < this.len; ++i) {
            this.table1[i][0] = i;
            this.table1[i][1] = super.result1(-1);
        }

    }

    void set_table_inpost_pos() throws Exception {
        for(int i = 0; i < this.len; ++i) {
            this.table1[i][0] = i;
            this.table1[i][1] = super.result1(i);
        }

    }

    int ret_val(int at_i) {
        return this.table1[at_i][1];
    }
}

