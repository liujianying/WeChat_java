package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class a$1 extends ag {
    final /* synthetic */ a gKD;

    a$1(a aVar, Looper looper) {
        this.gKD = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (1000 == message.what) {
            String str = (String) message.obj;
            int i = message.arg1;
            if (this.gKD.gKC != null) {
                this.gKD.gKC.aD(str, i);
            }
        }
    }
}
