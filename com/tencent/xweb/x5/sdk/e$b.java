package com.tencent.xweb.x5.sdk;

import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.xweb.x5.sdk.d.a;

class e$b implements PreInitCallback {
    a vEb;

    public e$b(a aVar) {
        this.vEb = aVar;
    }

    public final void onCoreInitFinished() {
    }

    public final void onViewInitFinished(boolean z) {
        if (this.vEb != null) {
            this.vEb.onViewInitFinished(z);
        }
    }
}
