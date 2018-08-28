package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.x;

class h$4 implements Runnable {
    final /* synthetic */ h lij;

    h$4(h hVar) {
        this.lij = hVar;
    }

    public final void run() {
        try {
            if (this.lij.lhN != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder");
                this.lij.lhN.stop();
                this.lij.lhN.release();
                this.lij.lhN = null;
            }
            if (this.lij.bDp != null && !this.lij.lhX) {
                this.lij.bDp.we();
                this.lij.bDp = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
