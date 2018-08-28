package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

class e$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ String dat;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ e fYT;

    e$1(e eVar, MMActivity mMActivity, String str, String str2, l lVar, int i) {
        this.fYT = eVar;
        this.bAl = mMActivity;
        this.bAj = str;
        this.dat = str2;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 0) {
            return;
        }
        if (i2 == -1) {
            h.bA(this.bAl, this.bAl.getResources().getString(j.app_shared));
            e.c(this.bAj, this.dat, "", 1, i2);
            x.i("MicroMsg.JsApiShareTimeline", "result is success");
            this.fCl.E(this.doP, this.fYT.f("success", null));
            return;
        }
        x.i("MicroMsg.JsApiShareTimeline", "result is cancel");
        this.fCl.E(this.doP, this.fYT.f("cancel", null));
        e.c(this.bAj, this.dat, "", 3, i2);
    }
}
