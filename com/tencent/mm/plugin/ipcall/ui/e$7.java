package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.sdk.platformtools.bi;

class e$7 implements Runnable {
    final /* synthetic */ e kuf;

    e$7(e eVar) {
        this.kuf = eVar;
    }

    public final void run() {
        akc aYD = c.aYD();
        if (aYD != null) {
            this.kuf.kua.setText(aYD.rMK);
            if (bi.oW(aYD.rMS)) {
                this.kuf.kub.setText("");
                this.kuf.kub.setVisibility(8);
                return;
            }
            this.kuf.kub.setText(aYD.rMS);
            this.kuf.kub.setVisibility(0);
            return;
        }
        this.kuf.kua.setText("");
        this.kuf.kub.setText("");
        this.kuf.kub.setVisibility(8);
    }
}
