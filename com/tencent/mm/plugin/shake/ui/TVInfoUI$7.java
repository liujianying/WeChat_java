package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ui.base.preference.f;

class TVInfoUI$7 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ String lMy;
    final /* synthetic */ TVInfoUI nbD;

    TVInfoUI$7(TVInfoUI tVInfoUI, String str, Bitmap bitmap) {
        this.nbD = tVInfoUI;
        this.lMy = str;
        this.abc = bitmap;
    }

    public final void run() {
        if (TVInfoUI.e(this.nbD) != null && TVInfoUI.e(this.nbD).equals(this.lMy)) {
            if (!(TVInfoUI.f(this.nbD) == null || this.abc == null)) {
                TVInfoUI.f(this.nbD).setImageBitmap(this.abc);
                TVInfoUI.g(this.nbD);
            }
            TVInfoUI.h(this.nbD);
        }
        f fVar = this.nbD.eOE;
    }
}
