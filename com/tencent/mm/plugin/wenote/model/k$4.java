package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import com.tencent.mm.bb.a;
import com.tencent.mm.sdk.platformtools.ag;

class k$4 extends ag {
    final /* synthetic */ k qoG;

    k$4(k kVar) {
        this.qoG = kVar;
    }

    public final void handleMessage(Message message) {
        if (k.c(this.qoG).qoW.booleanValue()) {
            k.d(this.qoG).bZk();
            k.c(this.qoG).qoW = Boolean.valueOf(false);
        }
        k.c(this.qoG).qpr = (int) a.bD(k.e(this.qoG));
        sendEmptyMessageDelayed(4096, 250);
    }
}
