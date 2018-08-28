package com.tencent.mm.plugin.backup.backuppcmodel;

class d$4 implements Runnable {
    final /* synthetic */ int gUs;
    final /* synthetic */ d gWN;

    d$4(d dVar, int i) {
        this.gWN = dVar;
        this.gUs = i;
    }

    public final void run() {
        if (d.d(this.gWN) != null) {
            d.d(this.gWN).mv(this.gUs);
        }
    }
}
