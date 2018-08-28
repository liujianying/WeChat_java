package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ i llM;

    i$1(i iVar) {
        this.llM = iVar;
    }

    public final void run() {
        if (this.llM.ldq != null) {
            x.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
            try {
                this.llM.ldq.stop();
                this.llM.ldq.release();
                this.llM.ldq = null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "delay to stop decoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
