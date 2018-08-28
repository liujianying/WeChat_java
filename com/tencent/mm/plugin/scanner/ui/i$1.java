package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class i$1 extends ag {
    final /* synthetic */ i mKt;

    i$1(i iVar) {
        this.mKt = iVar;
    }

    public final void handleMessage(Message message) {
        if (message != null && message.what == 1 && this.mKt.gmo != null) {
            this.mKt.gmo.setVisibility(0);
        }
    }
}
