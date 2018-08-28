package com.eclipsesource.a;

import java.io.Writer;

final class m extends Writer {
    private final char[] abN;
    private final Writer acb;
    private int fill = 0;

    m(Writer writer) {
        this.acb = writer;
        this.abN = new char[128];
    }

    public final void write(int i) {
        if (this.fill > this.abN.length - 1) {
            flush();
        }
        char[] cArr = this.abN;
        int i2 = this.fill;
        this.fill = i2 + 1;
        cArr[i2] = (char) i;
    }

    public final void write(char[] cArr, int i, int i2) {
        if (this.fill > this.abN.length - i2) {
            flush();
            if (i2 > this.abN.length) {
                this.acb.write(cArr, i, i2);
                return;
            }
        }
        System.arraycopy(cArr, i, this.abN, this.fill, i2);
        this.fill += i2;
    }

    public final void write(String str, int i, int i2) {
        if (this.fill > this.abN.length - i2) {
            flush();
            if (i2 > this.abN.length) {
                this.acb.write(str, i, i2);
                return;
            }
        }
        str.getChars(i, i + i2, this.abN, this.fill);
        this.fill += i2;
    }

    public final void flush() {
        this.acb.write(this.abN, 0, this.fill);
        this.fill = 0;
    }

    public final void close() {
    }
}
