package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import java.util.Set;

class d$2 implements Runnable {
    final /* synthetic */ d gWN;
    final /* synthetic */ Set gWP;

    d$2(d dVar, Set set) {
        this.gWN = dVar;
        this.gWP = set;
    }

    public final void run() {
        for (c aqN : this.gWP) {
            aqN.aqN();
        }
    }
}
