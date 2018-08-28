package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$c implements Runnable {
    boolean oKP = false;
    final /* synthetic */ b oXY;

    b$c(b bVar) {
        this.oXY = bVar;
    }

    public final void run() {
        while (!this.oKP && !b.q(this.oXY)) {
            if (b.bMv().kqx.videoDecode(b.bMv().kqx.oPf) == 1) {
                int i = b.bMv().kqx.field_remoteImgWidth;
                int i2 = b.bMv().kqx.field_remoteImgHeight;
                if (OpenGlRender.oUV == 1) {
                    if (b.h(this.oXY)) {
                        b.r(this.oXY).b(b.bMv().kqx.oPf, i, i2, OpenGlRender.oUB + OpenGlRender.oUH);
                    } else {
                        b.s(this.oXY).b(b.bMv().kqx.oPf, i, i2, OpenGlRender.oUB + OpenGlRender.oUH);
                    }
                } else if (b.h(this.oXY)) {
                    b.r(this.oXY).b(b.bMv().kqx.oPf, i, i2, OpenGlRender.oUE + OpenGlRender.oUH);
                } else {
                    b.s(this.oXY).b(b.bMv().kqx.oPf, i, i2, OpenGlRender.oUE + OpenGlRender.oUH);
                }
            }
            try {
                Thread.sleep(20);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
            }
        }
    }
}
