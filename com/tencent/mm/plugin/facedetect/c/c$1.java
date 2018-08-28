package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;

class c$1 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ Bundle iMY;
    final /* synthetic */ c iMZ;

    c$1(c cVar, int i, int i2, String str, Bundle bundle) {
        this.iMZ = cVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
        this.iMY = bundle;
    }

    public final void run() {
        this.iMZ.a(this.bFq, this.bFr, this.dJG, this.iMY);
    }
}
