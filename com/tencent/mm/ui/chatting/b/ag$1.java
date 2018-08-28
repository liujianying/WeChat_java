package com.tencent.mm.ui.chatting.b;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.chatting.b.b.o;

class ag$1 extends ag {
    final /* synthetic */ ag tRZ;

    ag$1(ag agVar) {
        this.tRZ = agVar;
    }

    public final void handleMessage(Message message) {
        if (this.tRZ.bAG != null && this.tRZ.bAG.eaR && ag.yT()) {
            ag.Ju();
            ((o) this.tRZ.bAG.O(o.class)).cvn();
            this.tRZ.bAG.avj();
        }
    }
}
