package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.u.a.1;
import com.tencent.mm.protocal.c.pm;

class u$a$1$2 implements Runnable {
    final /* synthetic */ pm noE;
    final /* synthetic */ 1 noF;

    u$a$1$2(1 1, pm pmVar) {
        this.noF = 1;
        this.noE = pmVar;
    }

    public final void run() {
        if (!this.noF.noD.noA.b(this.noE, this.noF.noD.iWY)) {
            this.noF.noD.iWY.sendEmptyMessage(0);
        }
    }
}
