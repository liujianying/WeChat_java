package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.y;
import com.tencent.mm.protocal.c.bxn;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class g$39 implements e {
    final /* synthetic */ g qiK;
    final /* synthetic */ y qjo;
    final /* synthetic */ i qjp;

    g$39(g gVar, y yVar, i iVar) {
        this.qiK = gVar;
        this.qjo = yVar;
        this.qjp = iVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            bxn bxn = (bxn) this.qjo.dZf.dIE.dIL;
            if (bxn.iwS == 0) {
                List<String> list = bxn.stQ;
                if (list == null || list.isEmpty()) {
                    g.a(this.qiK, this.qjp, "startMonitoringBeacons:no uuids", null);
                } else {
                    for (String a : list) {
                        g.a(this.qiK, a);
                    }
                }
            } else {
                g.a(this.qiK, this.qjp, "startMonitoringBeacons:system error", null);
                x.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", new Object[]{bxn.iwT});
            }
            au.DF().b(1702, this);
        }
    }
}
