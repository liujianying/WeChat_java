package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ g llv;

    g$1(g gVar) {
        this.llv = gVar;
    }

    public final void run() {
        try {
            if (this.llv.llj != null) {
                x.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                this.llv.llj.stop();
                this.llv.llj.release();
                this.llv.llj = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
