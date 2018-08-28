package com.tencent.mm.plugin.topstory;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.c.a;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.protocal.c.bgx;

class c$a$1 implements Runnable {
    final /* synthetic */ bgx oyM;
    final /* synthetic */ a oyN;

    c$a$1(a aVar, bgx bgx) {
        this.oyN = aVar;
        this.oyM = bgx;
    }

    public final void run() {
        g.DF().a(new n(this.oyM), 0);
    }
}
