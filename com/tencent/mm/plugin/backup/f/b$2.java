package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ab.e;
import java.util.HashSet;
import java.util.Set;

class b$2 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ b gXI;

    b$2(b bVar, int i, int i2, String str) {
        this.gXI = bVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
    }

    public final void run() {
        Set set;
        synchronized (b.QV()) {
            set = (Set) b.QV().get(Integer.valueOf(this.gXI.getType()));
        }
        if (set != null && set.size() > 0) {
            Set<e> hashSet = new HashSet();
            hashSet.addAll(set);
            for (e eVar : hashSet) {
                if (eVar != null && set.contains(eVar)) {
                    eVar.a(this.bFq, this.bFr, this.dJG, this.gXI);
                }
            }
        }
    }
}
