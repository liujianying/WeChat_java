package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$14 implements Runnable {
    final /* synthetic */ i tWK;

    i$14(i iVar) {
        this.tWK = iVar;
    }

    public final void run() {
        try {
            int w;
            if (bi.oW(this.tWK.tTx.cwO().cxz().tXa.getVideoPath())) {
                w = t.w(i.f(this.tWK).elF, i.a(this.tWK));
            } else {
                w = this.tWK.tTx.cwO().cxz().tXa.getCurrentPosition() / 1000;
            }
            i.f(this.tWK).iC(w);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "start timer error[%s]", new Object[]{e.toString()});
        }
        i.m(this.tWK).J(500, 500);
    }
}
