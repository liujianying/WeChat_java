package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.ok;
import com.tencent.mm.sdk.b.a;

class c$13 implements Runnable {
    final /* synthetic */ c tOm;

    c$13(c cVar) {
        this.tOm = cVar;
    }

    public final void run() {
        ok okVar = new ok();
        if (c.c(this.tOm) != null) {
            okVar.bZm.userName = c.c(this.tOm).field_username;
            a.sFg.m(okVar);
        }
    }
}
