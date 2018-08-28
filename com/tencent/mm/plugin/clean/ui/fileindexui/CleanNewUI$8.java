package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.plugin.clean.c.j;

class CleanNewUI$8 implements Runnable {
    final /* synthetic */ CleanNewUI hTh;
    final /* synthetic */ long hTj;

    CleanNewUI$8(CleanNewUI cleanNewUI, long j) {
        this.hTh = cleanNewUI;
        this.hTj = j;
    }

    public final void run() {
        CleanNewUI cleanNewUI = this.hTh;
        long j = this.hTj;
        j.aBt();
        CleanNewUI.a(cleanNewUI, j, j.aBa());
    }
}
