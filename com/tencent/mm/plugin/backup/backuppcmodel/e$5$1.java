package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.backuppcmodel.e.5;
import java.util.Set;

class e$5$1 implements Runnable {
    final /* synthetic */ int gUs;
    final /* synthetic */ Set gWP;
    final /* synthetic */ 5 gWX;

    e$5$1(5 5, Set set, int i) {
        this.gWX = 5;
        this.gWP = set;
        this.gUs = i;
    }

    public final void run() {
        for (c mw : this.gWP) {
            mw.mw(this.gUs);
        }
    }
}
