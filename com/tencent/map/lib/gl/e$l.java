package com.tencent.map.lib.gl;

import java.io.Writer;

class e$l extends Writer {
    private StringBuilder a = new StringBuilder();

    e$l() {
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                a();
            } else {
                this.a.append(c);
            }
        }
    }

    private void a() {
        if (this.a.length() > 0) {
            this.a.delete(0, this.a.length());
        }
    }
}
