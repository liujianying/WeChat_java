package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;

class p$3 implements Runnable {
    p$3() {
    }

    public final void run() {
        Object aP = p.aP(20, p.zK(20));
        if (!TextUtils.isEmpty(aP)) {
            z.bTc().cu(aP, 1);
        }
    }
}
