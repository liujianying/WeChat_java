package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;

class o$1 extends ag {
    final /* synthetic */ o mLe;

    o$1(o oVar) {
        this.mLe = oVar;
    }

    public final void handleMessage(Message message) {
        if (this.mLe.mKE >= this.mLe.mKF) {
            if (this.mLe.mKX != null) {
                au.DF().c(this.mLe.mKX);
            }
            o oVar = this.mLe;
            oVar.mKE--;
        }
    }
}
