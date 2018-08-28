package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.a.l;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.a;

class BizChatSearchUI$a$1 implements Runnable {
    final /* synthetic */ String tFj;
    final /* synthetic */ a tFk;

    BizChatSearchUI$a$1(a aVar, String str) {
        this.tFk = aVar;
        this.tFj = str;
    }

    public final void run() {
        if (this.tFj.equals(a.c(this.tFk))) {
            au.DF().a(new l(a.e(this.tFk), this.tFj, 0), 0);
        }
    }
}
