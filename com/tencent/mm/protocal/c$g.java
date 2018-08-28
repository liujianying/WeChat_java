package com.tencent.mm.protocal;

public abstract class c$g {
    protected String NAME = "noName";
    protected String qVD = "";
    protected int qVE = -1;
    protected boolean qVF = false;

    public c$g(String str, String str2, int i, boolean z) {
        this.NAME = str;
        this.qVD = str2;
        this.qVE = i;
        this.qVF = z;
    }

    public final String getName() {
        return this.NAME;
    }

    public final String cfX() {
        return this.qVD;
    }

    public final int cfY() {
        return this.qVE;
    }

    public final boolean cfZ() {
        return this.qVF;
    }
}
