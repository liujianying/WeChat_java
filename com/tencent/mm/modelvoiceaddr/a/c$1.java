package com.tencent.mm.modelvoiceaddr.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class c$1 extends ag {
    final /* synthetic */ c erm;

    c$1(c cVar, Looper looper) {
        this.erm = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 0 && c.a(this.erm) != null) {
            c.a(this.erm).vU();
        }
    }
}
