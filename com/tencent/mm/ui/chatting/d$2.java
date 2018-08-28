package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends ag {
    final /* synthetic */ d tHt;

    d$2(d dVar, Looper looper) {
        this.tHt = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        super.handleMessage(message);
        try {
            x.i("MicroMsg.AutoPlay", "reset speaker");
            this.tHt.setScreenEnable(true);
            d dVar = this.tHt;
            if (this.tHt.tHh.hmc) {
                z = false;
            }
            dVar.hlZ = z;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
        }
    }
}
