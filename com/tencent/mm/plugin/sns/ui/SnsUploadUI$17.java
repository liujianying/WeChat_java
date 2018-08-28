package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;

class SnsUploadUI$17 implements Runnable {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$17(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.ogU.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        af.byd();
        s.dA(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
