package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.sdk.platformtools.x;

class l$4 implements Runnable {
    final /* synthetic */ l eSI;

    l$4(l lVar) {
        this.eSI = lVar;
    }

    public final void run() {
        x.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
        Intent be = a.ezn.be(this.eSI.eSu);
        be.addFlags(67108864);
        this.eSI.eSu.startActivity(be);
        this.eSI.eSu.finish();
    }
}
