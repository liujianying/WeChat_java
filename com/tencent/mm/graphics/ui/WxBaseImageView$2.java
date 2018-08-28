package com.tencent.mm.graphics.ui;

import com.tencent.mm.graphics.b.a;
import com.tencent.mm.graphics.b.b;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.sdk.platformtools.x;

class WxBaseImageView$2 implements Runnable {
    final /* synthetic */ WxBaseImageView djS;

    WxBaseImageView$2(WxBaseImageView wxBaseImageView) {
        this.djS = wxBaseImageView;
    }

    public final void run() {
        synchronized (this) {
            b bVar;
            x.i("MicroMsg.WxBaseImageView", "alvinluo reportPerformanceInfo threadId: %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
            a aVar = (a) d.djo.djq.get(Integer.valueOf(2));
            if (aVar == null || !(aVar instanceof b)) {
                bVar = null;
            } else {
                aVar.Cj();
                bVar = (b) aVar;
            }
            int i = com.tencent.mm.graphics.c.a.dju;
            com.tencent.mm.graphics.c.a.a(bVar);
            WxBaseImageView.b(this.djS);
            WxBaseImageView.c(this.djS);
        }
    }
}
