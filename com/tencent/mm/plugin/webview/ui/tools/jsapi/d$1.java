package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends ag {
    final /* synthetic */ d qhD;

    d$1(d dVar, Looper looper) {
        this.qhD = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                String str = (String) message.obj;
                if (!bi.oW(str)) {
                    d.b(this.qhD).add(str);
                }
                d.c(this.qhD);
                return;
            case 2:
                x.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                return;
            default:
                return;
        }
    }
}
