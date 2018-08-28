package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.l;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.d;
import com.tencent.mm.u.a.d$a;
import java.util.HashMap;
import java.util.Map;

class g$3 implements d$a<d> {
    final /* synthetic */ int fvO;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ g$a qiL;

    g$3(g gVar, i iVar, g$a g_a, int i) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qiL = g_a;
        this.fvO = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        d dVar = (d) lVar;
        x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.qiK, this.qiH, "login:fail", null);
            this.qiL.aia();
        } else if (!(dVar instanceof d)) {
        } else {
            if (this.fvO == 2) {
                x.d("MicroMsg.MsgHandler", "press reject button");
                this.qiL.aia();
                return;
            }
            aow CX = dVar.CX();
            int i3 = CX.rRd.bMH;
            String str2 = CX.rRd.bMI;
            x.i("MicroMsg.MsgHandler", "stev NetSceneJSLoginConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                String str3 = CX.rRg;
                Map hashMap = new HashMap();
                hashMap.put("code", str3);
                g.a(this.qiK, this.qiH, "login:ok", hashMap);
                this.qiL.aia();
                x.d("MicroMsg.MsgHandler", "resp data code [%s]", new Object[]{str3});
                return;
            }
            g.a(this.qiK, this.qiH, "login:fail", null);
            this.qiL.aia();
            x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLoginConfirm %s", new Object[]{str2});
        }
    }
}
