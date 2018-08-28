package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.n.c.a;
import com.tencent.mm.sdk.platformtools.ah;

class o$2 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ a frB;
    final /* synthetic */ o frC;
    final /* synthetic */ ah frD;

    o$2(o oVar, String str, a aVar, ah ahVar) {
        this.frC = oVar;
        this.dhF = str;
        this.frB = aVar;
        this.frD = ahVar;
    }

    public final void run() {
        if (r.sb(this.dhF)) {
            r.a(this.dhF, false, new b<WxaAttributes>() {
                public final /* synthetic */ void e(int i, Object obj) {
                    WxaAttributes wxaAttributes = (WxaAttributes) obj;
                    if (o$2.this.frB != null) {
                        o$2.this.frB.b(wxaAttributes);
                    }
                }
            });
        } else if (this.frB != null) {
            this.frB.b(this.frC.rR(this.dhF));
        }
        Looper.myQueue().addIdleHandler(new 2(this));
    }
}
