package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class h$1 extends ag {
    final /* synthetic */ h lij;

    h$1(h hVar, Looper looper) {
        this.lij = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.lij.lhY != null) {
            this.lij.lhY.beh();
            this.lij.lhY = null;
        }
    }
}
