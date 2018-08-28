package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class n$6 implements Runnable {
    final /* synthetic */ n ljp;

    n$6(n nVar) {
        this.ljp = nVar;
    }

    public final void run() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[]{Boolean.valueOf(this.ljp.beC())});
        if (!this.ljp.beC()) {
            SightVideoJNI.releaseBigSightDataBuffer(this.ljp.lhM);
            if (this.ljp.liO != null) {
                ah.A(new 1(this));
            }
        } else if (this.ljp.ljn != null) {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
            ah.A(this.ljp.ljn);
        }
    }
}
