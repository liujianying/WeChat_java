package com.tencent.tinker.a.b.a;

public final class h extends a {
    public short[] vqb;

    public h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.vqb = new short[i];
    }

    public final void c(short s) {
        int i = this.vpT;
        if (this.vqb.length - i <= 0) {
            Object obj = new short[(this.vqb.length + (this.vqb.length >> 1))];
            System.arraycopy(this.vqb, 0, obj, 0, i);
            this.vqb = obj;
        }
        this.vqb[this.vpT] = s;
        cGR();
    }

    public final void c(short s, short s2) {
        c(s);
        c(s2);
    }

    public final void a(short s, short s2, short s3) {
        c(s);
        c(s2);
        c(s3);
    }

    public final void writeInt(int i) {
        c((short) i);
        c((short) (i >> 16));
    }
}
