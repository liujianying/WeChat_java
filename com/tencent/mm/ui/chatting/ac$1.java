package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ac$1 extends ag {
    final /* synthetic */ ac tMu;

    ac$1(ac acVar, Looper looper) {
        this.tMu = acVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.tMu.huM != null && au.HX()) {
            x.d("MicroMsg.EggMgr", "post start egg");
            this.tMu.a(this.tMu.tMt, this.tMu.huM);
        }
    }
}
