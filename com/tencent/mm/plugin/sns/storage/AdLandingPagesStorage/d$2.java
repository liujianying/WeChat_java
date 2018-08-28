package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;

class d$2 implements Runnable {
    final /* synthetic */ String iRk;
    final /* synthetic */ a nIk;
    final /* synthetic */ String nny;

    d$2(a aVar, String str, String str2) {
        this.nIk = aVar;
        this.nny = str;
        this.iRk = str2;
    }

    public final void run() {
        this.nIk.MX(this.nny + this.iRk);
    }
}
