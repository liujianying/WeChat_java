package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.sns.model.ab.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ab$1 extends ag {
    final /* synthetic */ ab npf;

    ab$1(ab abVar, Looper looper) {
        this.npf = abVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (ab.a(this.npf) >= 5 || System.currentTimeMillis() - ab.b(this.npf) > 300000) {
            x.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ab.a(this.npf));
            ab.kEE = false;
        } else if (!ab.c(this.npf) && ab.kEE) {
            new a(this.npf).o(new String[]{""});
        }
    }
}
