package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class h$1 extends ag {
    final /* synthetic */ h tiG;

    h$1(h hVar, Looper looper) {
        this.tiG = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (h.a(this.tiG) != null) {
                    h.b(this.tiG);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
