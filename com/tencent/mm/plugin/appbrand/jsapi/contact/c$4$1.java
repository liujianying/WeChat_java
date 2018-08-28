package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c.4;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class c$4$1 implements a {
    final /* synthetic */ 4 fPA;

    c$4$1(4 4) {
        this.fPA = 4;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.fPA.fPv != null) {
                this.fPA.fPv.a(true, "ok", intent);
            }
            if (c.fIS > 0) {
                c.fIS--;
                this.fPA.fIY.fdO.aav();
            }
            x.i("MicroMsg.JsApiEnterContact", "mmOnActivityResult lockCount:%d", new Object[]{Integer.valueOf(c.fIS)});
            this.fPA.fPy.ahB();
        }
    }
}
