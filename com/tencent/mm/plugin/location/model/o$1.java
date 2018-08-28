package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class o$1 extends ag {
    final /* synthetic */ o kDV;

    o$1(o oVar, Looper looper) {
        this.kDV = oVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            o oVar = this.kDV;
            switch (message.what) {
                case 1:
                    oVar.aZr();
                    return;
                default:
                    return;
            }
        }
    }
}
