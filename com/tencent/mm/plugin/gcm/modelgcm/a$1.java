package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a khm;

    a$1(a aVar) {
        this.khm = aVar;
    }

    public final void run() {
        x.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
        a aVG = a.aVG();
        if (aVG != null) {
            aVG.aVI();
        }
    }
}
