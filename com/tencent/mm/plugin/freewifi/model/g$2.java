package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ g jjV;
    final /* synthetic */ String jjW;
    final /* synthetic */ g$a jjX = null;
    final /* synthetic */ String jjh;
    final /* synthetic */ Intent val$intent;

    g$2(g gVar, String str, String str2, Intent intent) {
        this.jjV = gVar;
        this.jjW = str;
        this.jjh = str2;
        this.val$intent = intent;
    }

    public final void run() {
        String Cc = g.Cc(this.jjW);
        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", new Object[]{Cc, this.jjW});
        if (!bi.oW(Cc)) {
            String cP = g.cP(Cc, "res=");
            x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", new Object[]{cP, Cc});
            if (!bi.oW(cP) && (cP.startsWith("success") || cP.startsWith("already"))) {
                g.b(this.jjh, 2, this.val$intent);
                j.aOK().Ch(this.jjh);
                return;
            }
        }
        g.b(this.jjh, 3, this.val$intent);
    }
}
