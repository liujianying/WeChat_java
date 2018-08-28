package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;

class p$2 implements Runnable {
    p$2() {
    }

    public final void run() {
        Object bSS = p.bSS();
        if (!TextUtils.isEmpty(bSS)) {
            z.bTc().cu(bSS, 4);
        }
    }
}
