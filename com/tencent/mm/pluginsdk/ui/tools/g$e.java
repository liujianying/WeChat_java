package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.tools.g.d;

class g$e implements Runnable {
    ImageView bOA;
    Bitmap jDx;
    final /* synthetic */ g qSF;

    private g$e(g gVar) {
        this.qSF = gVar;
    }

    /* synthetic */ g$e(g gVar, byte b) {
        this(gVar);
    }

    public final void run() {
        if (this.bOA != null) {
            if (this.jDx == null || !this.jDx.isRecycled()) {
                d.b(this.bOA, this.jDx);
            } else {
                d.d(this.bOA);
            }
        }
        this.bOA = null;
        this.jDx = null;
        this.qSF.qSB.C(this);
    }
}
