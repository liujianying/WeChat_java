package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ic.c;

class ht$3 implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ ht b;

    ht$3(ht htVar, c cVar) {
        this.b = htVar;
        this.a = cVar;
    }

    public void run() {
        for (he heVar : ht.b(this.b)) {
            if (heVar != null) {
                heVar.a(this.a);
            }
        }
        ht.c(this.b);
    }
}
