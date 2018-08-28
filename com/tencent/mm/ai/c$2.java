package com.tencent.mm.ai;

import com.tencent.mm.model.am.b.a;

class c$2 implements Runnable {
    final /* synthetic */ c dST;
    final /* synthetic */ String dSU;
    final /* synthetic */ boolean dSV = false;

    c$2(c cVar, String str) {
        this.dST = cVar;
        this.dSU = str;
    }

    public final void run() {
        if (this.dST.dSL.containsKey(this.dSU)) {
            a aVar = (a) this.dST.dSL.get(this.dSU);
            if (aVar != null) {
                aVar.x(this.dSU, this.dSV);
            }
            this.dST.dSL.remove(this.dSU);
        }
    }
}
