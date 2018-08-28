package com.tencent.mm.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.h.13;

class h$13$2 implements Runnable {
    final /* synthetic */ Bitmap hIM;
    final /* synthetic */ 13 tiR;
    final /* synthetic */ int tiS;

    h$13$2(13 13, Bitmap bitmap, int i) {
        this.tiR = 13;
        this.hIM = bitmap;
        this.tiS = i;
    }

    public final void run() {
        h.a(this.tiR.tiG, true);
        this.tiR.tiO.V(this.hIM);
        if (this.tiR.tiP == 3) {
            h.a(this.tiR.tiO, 8, 8, false, 0, 0, 0);
        } else if (this.tiR.tiP == 4) {
            h.a(this.tiR.tiO, 8, 0, false, 0, 0, 0);
        }
        h.b(this.tiR.bAj, this.tiR.pre, this.tiR.tiQ, this.tiR.dAy, this.tiR.tiP);
        if (this.tiS == 2) {
            h.mEJ.a(858, 13, 1, false);
        }
    }
}
