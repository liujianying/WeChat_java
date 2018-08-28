package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.plugin.voiceprint.model.p.b;
import com.tencent.mm.sdk.platformtools.ag;

class p$b$1 extends ag {
    final /* synthetic */ p oFC;
    final /* synthetic */ b oFD;

    p$b$1(b bVar, p pVar) {
        this.oFD = bVar;
        this.oFC = pVar;
    }

    public final void handleMessage(Message message) {
        if (p.b(this.oFD.oFB) > 0) {
            p.c(this.oFD.oFB);
        }
    }
}
