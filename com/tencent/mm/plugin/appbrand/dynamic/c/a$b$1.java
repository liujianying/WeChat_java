package com.tencent.mm.plugin.appbrand.dynamic.c;

import com.tencent.mm.plugin.appbrand.dynamic.c.a.b;
import com.tencent.mm.protocal.MMProtocalJni;

class a$b$1 implements Runnable {
    final /* synthetic */ b fvC;

    a$b$1(b bVar) {
        this.fvC = bVar;
    }

    public final void run() {
        MMProtocalJni.setClientPackVersion(-1);
    }
}
