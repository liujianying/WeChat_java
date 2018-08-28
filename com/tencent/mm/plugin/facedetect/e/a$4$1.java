package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.a;

class a$4$1 implements Runnable {
    final /* synthetic */ 4 iSK;

    a$4$1(4 4) {
        this.iSK = 4;
    }

    public final void run() {
        synchronized (a.a(this.iSK.iSF)) {
            a.e(this.iSK.iSF, a.iSR);
            e.deleteFile(a.h(this.iSK.iSF));
            if (a.r(this.iSK.iSF) != null) {
                a.r(this.iSK.iSF).AW(a.g(this.iSK.iSF).getFilePath());
            }
        }
    }
}
