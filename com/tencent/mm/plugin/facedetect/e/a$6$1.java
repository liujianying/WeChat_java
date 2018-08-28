package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.6;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

class a$6$1 implements Runnable {
    final /* synthetic */ byte[] etO;
    final /* synthetic */ 6 iSM;

    a$6$1(6 6, byte[] bArr) {
        this.iSM = 6;
        this.etO = bArr;
    }

    public final void run() {
        SightVideoJNI.mirrorCameraData(this.etO, a.i(this.iSM.iSF), a.j(this.iSM.iSF), false);
        if (a.g(this.iSM.iSF).bem() != null) {
            a.g(this.iSM.iSF).bem().T(this.etO);
        }
    }
}
