package com.tencent.mm.remoteservice;

class a$1 implements Runnable {
    final /* synthetic */ Object[] nnG;
    final /* synthetic */ String sCj;
    final /* synthetic */ a sCk;

    a$1(a aVar, Object[] objArr, String str) {
        this.sCk = aVar;
        this.nnG = objArr;
        this.sCj = str;
    }

    public final void run() {
        a.a(this.sCk).a(this.sCk, this.sCj, this.sCk.objectsToBundle(this.nnG));
    }
}
