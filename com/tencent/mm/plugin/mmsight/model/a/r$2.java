package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.x;

class r$2 implements Runnable {
    final /* synthetic */ r ljJ;

    r$2(r rVar) {
        this.ljJ = rVar;
    }

    public final void run() {
        try {
            if (this.ljJ.lhN != null) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder");
                this.ljJ.ljA.stop();
                this.ljJ.lhN.stop();
                this.ljJ.lhN.release();
                this.ljJ.lhN = null;
                this.ljJ.bTv = false;
                if (this.ljJ.ljH != null) {
                    this.ljJ.ljH.bew();
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
