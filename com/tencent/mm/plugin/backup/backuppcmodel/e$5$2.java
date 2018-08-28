package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.backuppcmodel.e.5;

class e$5$2 implements Runnable {
    final /* synthetic */ int gUs;
    final /* synthetic */ 5 gWX;

    e$5$2(5 5, int i) {
        this.gWX = 5;
        this.gUs = i;
    }

    public final void run() {
        if (e.e(this.gWX.gWV) != null) {
            e.e(this.gWX.gWV).mv(this.gUs);
        }
    }
}
