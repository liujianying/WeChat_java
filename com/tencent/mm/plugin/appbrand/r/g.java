package com.tencent.mm.plugin.appbrand.r;

public final class g {
    private long gBH;
    private long gBI;
    private a gBJ;

    public interface a {
        boolean i(Object... objArr);
    }

    public g(long j, a aVar) {
        this.gBH = j;
        this.gBJ = aVar;
    }

    public final boolean k(Object... objArr) {
        boolean z = false;
        if (!((System.currentTimeMillis() - this.gBI < this.gBH) || this.gBJ == null)) {
            z = this.gBJ.i(objArr);
            if (z) {
                this.gBI = System.currentTimeMillis();
            }
        }
        return z;
    }
}
