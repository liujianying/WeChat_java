package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.ui.MMActivity;

class g$3 implements Runnable {
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ g eSt;

    g$3(g gVar, MMActivity mMActivity) {
        this.eSt = gVar;
        this.bAl = mMActivity;
    }

    public final void run() {
        Intent be = a.ezn.be(this.bAl);
        be.addFlags(67108864);
        this.bAl.startActivity(be);
        this.bAl.finish();
    }
}
