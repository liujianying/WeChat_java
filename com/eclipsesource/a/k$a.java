package com.eclipsesource.a;

import java.io.Writer;

class k$a extends i {
    private final char[] acc;
    private int acd;

    /* synthetic */ k$a(Writer writer, char[] cArr, byte b) {
        this(writer, cArr);
    }

    private k$a(Writer writer, char[] cArr) {
        super(writer);
        this.acc = cArr;
    }

    protected final void if() {
        this.acd++;
        this.acb.write(91);
        im();
    }

    protected final void ig() {
        this.acd--;
        im();
        this.acb.write(93);
    }

    protected final void ih() {
        this.acb.write(44);
        if (!im()) {
            this.acb.write(32);
        }
    }

    protected final void ii() {
        this.acd++;
        this.acb.write(123);
        im();
    }

    protected final void ij() {
        this.acd--;
        im();
        this.acb.write(125);
    }

    protected final void ik() {
        this.acb.write(58);
        this.acb.write(32);
    }

    protected final void il() {
        this.acb.write(44);
        if (!im()) {
            this.acb.write(32);
        }
    }

    private boolean im() {
        int i = 0;
        if (this.acc == null) {
            return false;
        }
        this.acb.write(10);
        while (i < this.acd) {
            this.acb.write(this.acc);
            i++;
        }
        return true;
    }
}
