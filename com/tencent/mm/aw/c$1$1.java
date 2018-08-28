package com.tencent.mm.aw;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.aw.c.1;
import com.tencent.mm.sdk.platformtools.x;

class c$1$1 implements IdleHandler {
    final /* synthetic */ 1 ehn;

    c$1$1(1 1) {
        this.ehn = 1;
    }

    public final boolean queueIdle() {
        x.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
        e.RQ().b(this.ehn.ehm);
        return false;
    }
}
