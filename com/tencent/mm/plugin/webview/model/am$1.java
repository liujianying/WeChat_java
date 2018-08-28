package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ad;

class am$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ String dhF;
    final /* synthetic */ am pSL;

    am$1(am amVar, String str, String str2) {
        this.pSL = amVar;
        this.dhF = str;
        this.bAj = str2;
    }

    public final void run() {
        d.a(ad.getContext(), this.dhF, this.bAj, null);
    }
}
