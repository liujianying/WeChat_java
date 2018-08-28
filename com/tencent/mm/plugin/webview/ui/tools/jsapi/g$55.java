package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.di;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$55 implements Runnable {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ di qjw;

    g$55(g gVar, di diVar, i iVar) {
        this.qiK = gVar;
        this.qjw = diVar;
        this.qiH = iVar;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", new Object[]{Boolean.valueOf(this.qjw.bLb.bLd), this.qjw.bLb.bLe});
        if (!this.qjw.bLb.bLd) {
            return;
        }
        if (bi.oW(this.qjw.bLb.bLe)) {
            g.a(this.qiK, this.qiH, "getWXDeviceTicket:fail", null);
            return;
        }
        Map hashMap = new HashMap();
        x.i("MicroMsg.MsgHandler", "ticket %s", new Object[]{this.qjw.bLb.bLe});
        hashMap.put("ticket", this.qjw.bLb.bLe);
        g.a(this.qiK, this.qiH, "getWXDeviceTicket:ok", hashMap);
    }
}
