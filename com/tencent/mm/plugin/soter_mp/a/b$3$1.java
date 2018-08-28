package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.a.c.i;
import com.tencent.d.b.a.a;
import com.tencent.mm.plugin.soter_mp.a.b.3;

class b$3$1 implements Runnable {
    final /* synthetic */ a oon;
    final /* synthetic */ 3 ooo;

    b$3$1(3 3, a aVar) {
        this.ooo = 3;
        this.oon = aVar;
    }

    public final void run() {
        i iVar = (i) this.oon.vlN;
        this.ooo.oom.oor.errCode = 0;
        this.ooo.oom.oor.Yy = "OK";
        this.ooo.oom.oor.oou = (byte) 1;
        this.ooo.oom.oor.bZt = iVar.vlM;
        this.ooo.oom.oor.oov = iVar.signature;
        this.ooo.oom.bFq();
    }
}
