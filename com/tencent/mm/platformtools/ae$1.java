package com.tencent.mm.platformtools;

class ae$1 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ String ewx;
    final /* synthetic */ boolean ewy;
    final /* synthetic */ int ewz;

    ae$1(String str, String str2, boolean z, int i) {
        this.ewx = str;
        this.dhF = str2;
        this.ewy = z;
        this.ewz = i;
    }

    public final void run() {
        ae.a(this.ewx, this.dhF, this.ewy, this.ewz);
    }
}
