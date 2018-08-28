package com.tencent.mm.plugin.wenote.model.nativenote.spans;

public final class a {
    public final q qsK;
    public int qsL;
    public int qsM;

    public a(q qVar, int i, int i2) {
        this.qsK = qVar;
        this.qsL = i;
        this.qsM = i2;
    }

    public final String toString() {
        return this.qsK.name() + " - " + this.qsL + "/" + this.qsM;
    }
}
