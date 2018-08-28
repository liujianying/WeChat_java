package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsUploadUI.12;

class SnsUploadUI$12$2 implements Runnable {
    final /* synthetic */ 12 ogW;

    SnsUploadUI$12$2(12 12) {
        this.ogW = 12;
    }

    public final void run() {
        SnsUploadSayFooter c = SnsUploadUI.c(this.ogW.ogU);
        if (!c.bEw()) {
            c.setVisibility(8);
        }
        SnsUploadUI.c(this.ogW.ogU).postInvalidate();
        SnsUploadUI.e(this.ogW.ogU).postInvalidate();
    }
}
