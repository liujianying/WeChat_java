package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements Runnable {
    final /* synthetic */ h llK;

    h$1(h hVar) {
        this.llK = hVar;
    }

    public final void run() {
        h hVar = this.llK;
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", new Object[]{hVar.llC, hVar.lkw});
        if (hVar.llC != null && hVar.lkw != null) {
            hVar.llC.lkx = true;
            try {
                hVar.lkw.join();
                e.remove(hVar.llC);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
