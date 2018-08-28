package com.tencent.xweb.xwalk;

import com.tencent.xweb.xwalk.XWAppBrandEngine.a;

class XWAppBrandEngine$a$1 implements Runnable {
    final /* synthetic */ a vEC;

    XWAppBrandEngine$a$1(a aVar) {
        this.vEC = aVar;
    }

    public final void run() {
        this.vEC.vEB.notifyRunTimer(this.vEC.vEB.mInstance, this.vEC.bnu);
    }
}
