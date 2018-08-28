package com.tencent.mm.plugin.card.b;

import com.tencent.mm.plugin.card.b.m.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class m$1 implements Runnable {
    final /* synthetic */ boolean dSv;
    final /* synthetic */ ArrayList dha;
    final /* synthetic */ String huS;
    final /* synthetic */ m huT;

    m$1(m mVar, String str, boolean z, ArrayList arrayList) {
        this.huT = mVar;
        this.huS = str;
        this.dSv = z;
        this.dha = arrayList;
    }

    public final void run() {
        Set set;
        synchronized (this.huT.huO) {
            set = (Set) this.huT.huO.get(this.huS);
        }
        if (set != null && set.size() > 0) {
            Set<a> hashSet = new HashSet();
            hashSet.addAll(set);
            for (a aVar : hashSet) {
                if (aVar != null) {
                    aVar.a(this.dSv, this.dha);
                }
            }
        }
    }
}
