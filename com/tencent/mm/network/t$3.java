package com.tencent.mm.network;

import com.tencent.mm.kernel.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class t$3 implements Runnable {
    final /* synthetic */ t esu;

    t$3(t tVar) {
        this.esu = tVar;
    }

    public final void run() {
        x.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
        aa.Va().d(4, -100, ad.getContext().getString(a.main_err_auth));
    }
}
