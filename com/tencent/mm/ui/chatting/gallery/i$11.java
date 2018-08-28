package com.tencent.mm.ui.chatting.gallery;

import android.os.Message;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$11 implements a {
    final /* synthetic */ i tWK;

    i$11(i iVar) {
        this.tWK = iVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            j cwO = this.tWK.tTx.cwO();
            if (!(cwO == null || bi.oW(i.a(this.tWK)))) {
                x.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", Integer.valueOf(hashCode()), i.a(this.tWK));
                if (!i.b(this.tWK)) {
                    t.c(i.a(this.tWK), cwO.cxz().tXa.getCurrentPosition(), i.c(this.tWK));
                }
                i.a(this.tWK, cwO);
                i.d(this.tWK).bv(false);
                if (i.c(this.tWK)) {
                    com.tencent.mm.sdk.b.a.sFg.c(i.e(this.tWK));
                    i.f(this.tWK).cxB();
                    i.a(this.tWK, false);
                }
            }
            i.g(this.tWK);
        }
        return false;
    }
}
