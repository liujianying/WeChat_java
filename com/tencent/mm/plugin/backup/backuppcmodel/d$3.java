package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import java.util.Set;

class d$3 implements Runnable {
    final /* synthetic */ int gUs;
    final /* synthetic */ d gWN;
    final /* synthetic */ Set gWP;

    d$3(d dVar, Set set, int i) {
        this.gWN = dVar;
        this.gWP = set;
        this.gUs = i;
    }

    public final void run() {
        for (c mw : this.gWP) {
            mw.mw(this.gUs);
        }
    }
}
