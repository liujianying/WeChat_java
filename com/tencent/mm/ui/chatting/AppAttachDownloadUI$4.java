package com.tencent.mm.ui.chatting;

import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;

class AppAttachDownloadUI$4 implements f {
    final /* synthetic */ AppAttachDownloadUI tGp;

    AppAttachDownloadUI$4(AppAttachDownloadUI appAttachDownloadUI) {
        this.tGp = appAttachDownloadUI;
    }

    public final void a(int i, int i2, l lVar) {
        float f;
        if (i2 == 0) {
            f = 0.0f;
        } else {
            f = (((float) i) * 100.0f) / ((float) i2);
        }
        if (i < i2 && AppAttachDownloadUI.k(this.tGp).getVisibility() != 0) {
            AppAttachDownloadUI.k(this.tGp).setVisibility(0);
            AppAttachDownloadUI.l(this.tGp).setVisibility(8);
            AppAttachDownloadUI.m(this.tGp).setVisibility(0);
        }
        AppAttachDownloadUI.n(this.tGp).setProgress((int) f);
    }
}
