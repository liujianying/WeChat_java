package com.tencent.mm.plugin.websearch.api;

import android.os.Looper;
import com.tencent.mm.plugin.websearch.api.aa.7;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class aa$1 implements Runnable {
    final /* synthetic */ aa pMf;
    final /* synthetic */ String val$url;

    aa$1(aa aaVar, String str) {
        this.pMf = aaVar;
        this.val$url = str;
    }

    public final void run() {
        x.i(this.pMf.TAG, "preload start");
        7 7 = new 7(this.pMf, this.val$url);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            7.run();
        } else {
            ah.A(7);
        }
    }
}
