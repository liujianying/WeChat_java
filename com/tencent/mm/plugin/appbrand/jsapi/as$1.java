package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class as$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ as fGp;

    as$1(as asVar, l lVar, int i) {
        this.fGp = asVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fGp.hashCode() & 65535)) {
            if (intent != null) {
                x.i("MicroMsg.JsApiOpenOfflinePayView", "callback: %s", new Object[]{intent.getStringExtra("key_callback")});
                this.fCl.E(this.doP, this.fGp.f(r0, null));
                h.mEJ.h(14954, new Object[]{f.cfF(), "openOfflinePayView:ok"});
            } else {
                this.fCl.E(this.doP, this.fGp.f("fail", null));
                if (!f.cfE()) {
                    h.mEJ.h(14954, new Object[]{f.cfF(), "openOfflinePayView:fail"});
                }
            }
            if (!f.cfE()) {
                f.cfG();
            }
        }
    }
}
