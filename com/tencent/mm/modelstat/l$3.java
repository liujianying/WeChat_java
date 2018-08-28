package com.tencent.mm.modelstat;

class l$3 implements Runnable {
    final /* synthetic */ String dJG;
    final /* synthetic */ l ekq;
    final /* synthetic */ int ekt;
    final /* synthetic */ int eku;
    final /* synthetic */ int ekv;
    final /* synthetic */ String ekw;
    final /* synthetic */ boolean ekx;

    l$3(l lVar, int i, int i2, String str, int i3, String str2, boolean z) {
        this.ekq = lVar;
        this.ekt = i;
        this.eku = i2;
        this.dJG = str;
        this.ekv = i3;
        this.ekw = str2;
        this.ekx = z;
    }

    public final void run() {
        l.b(this.ekt, this.eku, this.ekv, this.ekx);
    }

    public final String toString() {
        return super.toString() + "|report";
    }
}
