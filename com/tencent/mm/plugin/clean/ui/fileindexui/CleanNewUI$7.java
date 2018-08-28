package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;

class CleanNewUI$7 implements Runnable {
    final /* synthetic */ int dVx;
    final /* synthetic */ int fdk;
    final /* synthetic */ CleanNewUI hTh;

    CleanNewUI$7(CleanNewUI cleanNewUI, int i, int i2) {
        this.hTh = cleanNewUI;
        this.fdk = i;
        this.dVx = i2;
    }

    public final void run() {
        CleanNewUI.k(this.hTh).setText(this.hTh.getString(R.l.analyse_file_profress, new Object[]{((this.fdk * 100) / this.dVx) + "%"}));
    }
}
