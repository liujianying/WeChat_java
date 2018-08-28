package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.l;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import com.tencent.mm.u.a.b.a;

class g$5 implements a<b> {
    final /* synthetic */ int fvO;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ g.a qiL;

    g$5(g gVar, i iVar, g.a aVar, int i) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qiL = aVar;
        this.fvO = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        b bVar = (b) lVar;
        x.d("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.qiK, this.qiH, "authorize:fail", null);
            this.qiL.aia();
        } else if (!(bVar instanceof b)) {
        } else {
            if (this.fvO == 2) {
                x.d("MicroMsg.MsgHandler", "press reject button");
                this.qiL.aia();
                return;
            }
            aos CV = bVar.CV();
            int i3 = CV.rRd.bMH;
            String str2 = CV.rRd.bMI;
            x.i("MicroMsg.MsgHandler", "NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                g.a(this.qiK, this.qiH, "authorize:ok", null);
                this.qiL.aia();
                return;
            }
            x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
            g.a(this.qiK, this.qiH, "authorize:fail", null);
            this.qiL.aia();
        }
    }
}
