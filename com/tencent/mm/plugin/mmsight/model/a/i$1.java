package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class i$1 extends ag {
    final /* synthetic */ i lim;

    i$1(i iVar) {
        this.lim = iVar;
    }

    public final void handleMessage(Message message) {
        if (this.lim.lhY != null) {
            this.lim.lhY.beh();
            this.lim.lhY = null;
        }
    }
}
