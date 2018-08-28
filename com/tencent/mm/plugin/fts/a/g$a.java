package com.tencent.mm.plugin.fts.a;

public class g$a {
    int bottom;
    int up;

    public g$a(int i, int i2) {
        this.bottom = i;
        this.up = i2;
    }

    public final boolean l(char c) {
        return c >= this.bottom && c <= this.up;
    }
}
