package com.tencent.mm.modelvoiceaddr;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;

class b$2 extends ag {
    final /* synthetic */ b eqj;

    b$2(b bVar, Looper looper) {
        this.eqj = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 291 && this.eqj.TV()) {
            g.DF().a(this.eqj, 0);
        }
    }
}
