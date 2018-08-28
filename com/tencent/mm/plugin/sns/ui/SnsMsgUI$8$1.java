package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsMsgUI.8;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$8$1 implements Runnable {
    final /* synthetic */ 8 nYn;

    SnsMsgUI$8$1(8 8) {
        this.nYn = 8;
    }

    public final void run() {
        synchronized (SnsMsgUI.e(this.nYn.nYl)) {
            x.v("MicroMsg.SnsMsgUI", "comment notify");
            SnsMsgUI.o(this.nYn.nYl);
            SnsMsgUI.e(this.nYn.nYl).a(null, null);
        }
    }
}
