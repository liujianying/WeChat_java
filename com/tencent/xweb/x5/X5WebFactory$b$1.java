package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.x5.X5WebFactory.b;

class X5WebFactory$b$1 implements PreInitCallback {
    private boolean vDP = false;
    private boolean vDQ = false;
    final /* synthetic */ c vDR;

    X5WebFactory$b$1(c cVar) {
        this.vDR = cVar;
    }

    public final void onCoreInitFinished() {
        this.vDP = true;
        if (this.vDP && this.vDQ && this.vDR != null) {
            this.vDR.onCoreInitFinished();
            b.Ju();
        }
    }

    public final void onViewInitFinished(boolean z) {
        this.vDQ = true;
        if (this.vDP && this.vDQ && this.vDR != null) {
            this.vDR.onCoreInitFinished();
            b.Ju();
        }
    }
}
