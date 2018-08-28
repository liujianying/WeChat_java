package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class g$1 extends ag {
    final /* synthetic */ g eOc;

    g$1(g gVar) {
        this.eOc = gVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.eOc.eOb != null) {
                    this.eOc.eOb.onError(message.arg1, (String) message.obj);
                    return;
                }
                return;
            case 2:
                if (this.eOc.eOb != null) {
                    this.eOc.eOb.m(message.getData());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
