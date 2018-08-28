package com.tencent.pb.common.b;

import java.util.HashSet;
import java.util.Set;

class e$3 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ e vcj;
    final /* synthetic */ d vck;

    e$3(e eVar, d dVar, int i, int i2, String str) {
        this.vcj = eVar;
        this.vck = dVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
    }

    public final void run() {
        Set set = (Set) e.b(this.vcj).get(this.vck.getType());
        if (set != null && set.size() > 0) {
            Set<b> hashSet = new HashSet();
            hashSet.addAll(set);
            for (b bVar : hashSet) {
                if (bVar != null && set.contains(bVar)) {
                    bVar.a(this.bFq, this.bFr, this.dJG, this.vck);
                }
            }
        }
    }
}
