package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.l;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.c;
import com.tencent.mm.u.a.c$a;
import java.util.HashMap;
import java.util.Map;

class g$4 implements c$a<c> {
    final /* synthetic */ String bAj;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ g$a qiL;

    g$4(g gVar, i iVar, g$a g_a, String str) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qiL = g_a;
        this.bAj = str;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        c cVar = (c) lVar;
        x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.qiK, this.qiH, "login:fail", null);
            this.qiL.aia();
        } else if (cVar instanceof c) {
            aoy CW = cVar.CW();
            int i3 = CW.rRd.bMH;
            String str2 = CW.rRd.bMI;
            String str3 = CW.rRf;
            x.i("MicroMsg.MsgHandler", "NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                ah.A(new 1(this, CW, str3));
            } else if (i3 == 0) {
                String str4 = CW.rRg;
                Map hashMap = new HashMap();
                hashMap.put("code", str4);
                g.a(this.qiK, this.qiH, "login:ok", hashMap);
                x.d("MicroMsg.MsgHandler", "resp data code [%s]", new Object[]{str4});
                this.qiL.aia();
            } else {
                g.a(this.qiK, this.qiH, "login:fail", null);
                x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                this.qiL.aia();
            }
        }
    }
}
