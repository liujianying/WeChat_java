package com.tencent.mm.plugin.facedetect.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends ag {
    final /* synthetic */ d iPx;

    d$1(d dVar, Looper looper) {
        this.iPx = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                x.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                this.iPx.aKk();
                return;
            default:
                return;
        }
    }
}
