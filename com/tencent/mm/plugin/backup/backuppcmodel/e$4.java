package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import java.util.Set;

class e$4 implements Runnable {
    final /* synthetic */ Set gWP;
    final /* synthetic */ e gWV;

    e$4(e eVar, Set set) {
        this.gWV = eVar;
        this.gWP = set;
    }

    public final void run() {
        for (c aqN : this.gWP) {
            aqN.aqN();
        }
    }
}
