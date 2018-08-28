package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;

class a$1 implements Runnable {
    final /* synthetic */ byte[] pJP;
    final /* synthetic */ a pJQ;

    a$1(a aVar, byte[] bArr) {
        this.pJQ = aVar;
        this.pJP = bArr;
    }

    public final void run() {
        a.bSl().pIM.ba(this.pJP);
    }
}
