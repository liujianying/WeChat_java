package com.tencent.mm.plugin.webview.modelcache;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

class q$4 implements Runnable {
    final /* synthetic */ q pTs;
    final /* synthetic */ ah pTw;

    q$4(q qVar, ah ahVar) {
        this.pTs = qVar;
        this.pTw = ahVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(new 1(this));
    }
}
