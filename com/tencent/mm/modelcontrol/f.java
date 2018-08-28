package com.tencent.mm.modelcontrol;

public final class f implements Comparable {
    public int dQL;
    public int dQM;
    public int dQN;
    public int dQO;
    public int dQP;
    public int dQQ;
    public int dQR;

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.dQL = i;
        this.dQM = i2;
        this.dQN = i3;
        this.dQO = i4;
        this.dQP = i5;
        this.dQQ = i6;
        this.dQR = i7;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return 0;
        }
        return this.dQL - ((f) obj).dQL;
    }
}
