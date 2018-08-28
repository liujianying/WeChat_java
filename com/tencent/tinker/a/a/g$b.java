package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public class g$b implements Comparable<g$b> {
    public int voJ;
    public int voK;
    public int voL;

    public final /* synthetic */ int compareTo(Object obj) {
        g$b g_b = (g$b) obj;
        int fJ = c.fJ(this.voJ, g_b.voJ);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.voK, g_b.voK);
        return fJ == 0 ? c.fJ(this.voL, g_b.voL) : fJ;
    }

    public g$b(int i, int i2, int i3) {
        this.voJ = i;
        this.voK = i2;
        this.voL = i3;
    }
}
