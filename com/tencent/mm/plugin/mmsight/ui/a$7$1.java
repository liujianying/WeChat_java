package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.a.7;

class a$7$1 implements Runnable {
    final /* synthetic */ 7 lpo;

    a$7$1(7 7) {
        this.lpo = 7;
    }

    public final void run() {
        if (this.lpo.lpk.eXe != null) {
            this.lpo.lpk.eXe.dismiss();
        }
        if (this.lpo.lpk.lpc != null) {
            this.lpo.lpk.lpc.onError();
        }
    }
}
