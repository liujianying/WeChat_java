package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

class d$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ WeakReference fQJ;
    final /* synthetic */ int fQL;
    final /* synthetic */ d fQM;

    d$1(d dVar, WeakReference weakReference, int i, int i2) {
        this.fQM = dVar;
        this.fQJ = weakReference;
        this.fQL = i;
        this.doP = i2;
    }

    public final void run() {
        if (((p) this.fQJ.get()).mContext instanceof MMActivity) {
            ((MMActivity) ((p) this.fQJ.get()).mContext).YC();
        }
        String str = m.lZ(this.fQL) ? "ok" : "fail";
        if (this.fQJ.get() != null) {
            ((p) this.fQJ.get()).E(this.doP, this.fQM.f(str, null));
        }
    }
}
