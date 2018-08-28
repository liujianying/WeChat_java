package com.tencent.mars.mm;

import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.bi;

class MMLogic$3 implements Runnable {
    final /* synthetic */ String val$_info;

    MMLogic$3(String str) {
        this.val$_info = str;
    }

    public final void run() {
        aa.Vb().onPush(268369923, bi.oW(this.val$_info) ? null : this.val$_info.getBytes());
    }
}
