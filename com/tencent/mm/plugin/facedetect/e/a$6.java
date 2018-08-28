package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.sdk.platformtools.x;

class a$6 implements b {
    final /* synthetic */ a iSF;

    a$6(a aVar) {
        this.iSF = aVar;
    }

    public final void av(byte[] bArr) {
        x.v("MicroMsg.FaceVideoRecorder", "hy: on video data come");
        a.s(this.iSF).H(new 1(this, bArr));
    }

    public final a<byte[]> aJC() {
        return j.lin;
    }
}
