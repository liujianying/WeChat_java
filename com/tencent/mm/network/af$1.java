package com.tencent.mm.network;

class af$1 implements Runnable {
    final /* synthetic */ int etN;
    final /* synthetic */ byte[] etO;
    final /* synthetic */ af etP;

    af$1(af afVar, int i, byte[] bArr) {
        this.etP = afVar;
        this.etN = i;
        this.etO = bArr;
    }

    public final void run() {
        aa.Vb().onPush(this.etN, this.etO);
    }
}
