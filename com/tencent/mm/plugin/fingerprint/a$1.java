package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a jgm;

    a$1(a aVar) {
        this.jgm = aVar;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreFingerPrint", "alvinluo post 1500ms delayed");
        a.aMZ();
    }
}
