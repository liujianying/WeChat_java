package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsUploadUI.12;

class SnsUploadUI$12$1 implements Runnable {
    final /* synthetic */ 12 ogW;

    SnsUploadUI$12$1(12 12) {
        this.ogW = 12;
    }

    public final void run() {
        SnsUploadUI.c(this.ogW.ogU).bEv();
        SnsUploadUI.c(this.ogW.ogU).postInvalidate();
        SnsUploadUI.d(this.ogW.ogU).postInvalidate();
    }
}
