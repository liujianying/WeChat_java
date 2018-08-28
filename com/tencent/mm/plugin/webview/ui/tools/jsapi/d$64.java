package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.x;

class d$64 implements Runnable {
    final /* synthetic */ d qhD;
    final /* synthetic */ String qhJ;

    d$64(d dVar, String str) {
        this.qhD = dVar;
        this.qhJ = str;
    }

    public final void run() {
        String a = d.a(this.qhD, "html");
        if (!d.fu(a, this.qhJ)) {
            x.e("MicroMsg.JsApiHandler", "failed to write Html file");
        } else if (d.m(this.qhD) != null && d.d(this.qhD) != null) {
            try {
                d.m(this.qhD).z(1, d.d(this.qhD).getUrl(), a);
            } catch (RemoteException e) {
                x.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[]{e.getMessage()});
            }
        }
    }
}
