package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.plugin.fingerprint.b.h.a;
import com.tencent.mm.plugin.wxpay.a.i;

class h$a$1 implements Runnable {
    final /* synthetic */ a jgJ;

    h$a$1(a aVar) {
        this.jgJ = aVar;
    }

    public final void run() {
        this.jgJ.jgH.jgD.af(-1, this.jgJ.jgH.jgF.getString(i.fingerprint_open_fail));
    }
}
