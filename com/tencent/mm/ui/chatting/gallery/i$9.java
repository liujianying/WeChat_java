package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.u.e;
import com.tencent.mm.sdk.platformtools.bi;

class i$9 implements Runnable {
    final /* synthetic */ i tWK;

    i$9(i iVar) {
        this.tWK = iVar;
    }

    public final void run() {
        String bdt = e.bdt();
        if (bi.oW(bdt)) {
            h.mEJ.k(14092, "0");
        } else {
            h.mEJ.k(14092, bdt);
        }
    }
}
