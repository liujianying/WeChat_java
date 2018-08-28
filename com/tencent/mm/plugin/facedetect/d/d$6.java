package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.2;

class d$6 implements Runnable {
    final /* synthetic */ d iPx;

    d$6(d dVar) {
        this.iPx = dVar;
    }

    public final void run() {
        if (a.aKA().iSn) {
            this.iPx.iPb.a(a.aKA().aKB());
            a aKA = a.aKA();
            aKA.iSf.H(new 2(aKA));
        }
    }
}
