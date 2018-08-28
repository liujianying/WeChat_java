package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ g llv;

    g$2(g gVar) {
        this.llv = gVar;
    }

    public final void run() {
        try {
            if (this.llv.llk != null) {
                x.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
                this.llv.llk.stop();
                this.llv.llk.release();
                this.llv.llk = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
