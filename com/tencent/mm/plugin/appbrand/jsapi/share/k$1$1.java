package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.k.1;
import com.tencent.mm.sdk.platformtools.x;

class k$1$1 implements Runnable {
    final /* synthetic */ long fZk;
    final /* synthetic */ Bundle fZl;
    final /* synthetic */ 1 fZm;

    k$1$1(1 1, long j, Bundle bundle) {
        this.fZm = 1;
        this.fZk = j;
        this.fZl = bundle;
    }

    public final void run() {
        x.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", new Object[]{Long.valueOf(System.currentTimeMillis() - this.fZk)});
        this.fZl.putInt("action", 2);
        f.a("com.tencent.mm", this.fZl, a.class, null);
    }
}
