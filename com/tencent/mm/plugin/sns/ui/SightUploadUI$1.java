package com.tencent.mm.plugin.sns.ui;

import android.widget.LinearLayout.LayoutParams;

class SightUploadUI$1 implements Runnable {
    final /* synthetic */ int nRv;
    final /* synthetic */ SightUploadUI nRw;

    SightUploadUI$1(SightUploadUI sightUploadUI, int i) {
        this.nRw = sightUploadUI;
        this.nRv = i;
    }

    public final void run() {
        SightUploadUI.a(this.nRw).setWidth((int) (((double) this.nRv) * 0.7d));
        SightUploadUI.b(this.nRw).setLayoutParams(new LayoutParams((int) (((double) this.nRv) * 0.3d), SightUploadUI.b(this.nRw).getHeight()));
    }
}
