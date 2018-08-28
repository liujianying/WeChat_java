package com.tencent.mm.ak;

class g$4 implements Runnable {
    final /* synthetic */ float bCn;
    final /* synthetic */ g dUE;
    final /* synthetic */ String dUF;
    final /* synthetic */ boolean dUG = true;
    final /* synthetic */ int dUH;

    g$4(g gVar, String str, float f, boolean z, int i) {
        this.dUE = gVar;
        this.dUF = str;
        this.bCn = f;
        this.dUH = i;
    }

    public final void run() {
        this.dUE.a(this.dUF, true, this.bCn, true, false, this.dUG, this.dUH);
        g.a(this.dUE).post(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|loadImginBackground";
    }
}
