package com.tencent.mm.ui.appbrand;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class c$2 extends ag {
    final /* synthetic */ c tro;

    c$2(c cVar, Looper looper) {
        this.tro = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        c.a(this.tro);
    }
}
