package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements a {
    final /* synthetic */ n ljp;

    n$3(n nVar) {
        this.ljp = nVar;
    }

    public final void beh() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
        if (this.ljp.lis.ljK != c.lhJ) {
            x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            return;
        }
        q qVar = this.ljp.ljg;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Start");
        qVar.bTv = true;
        qVar.startTime = System.currentTimeMillis();
        this.ljp.lis.a(c.lhC);
    }
}
