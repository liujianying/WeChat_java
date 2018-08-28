package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.l;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.a.a;
import java.util.LinkedList;

class g$6 implements a<com.tencent.mm.u.a.a> {
    final /* synthetic */ String bAj;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ g.a qiL;

    g$6(g gVar, i iVar, g.a aVar, String str) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qiL = aVar;
        this.bAj = str;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        com.tencent.mm.u.a.a aVar = (com.tencent.mm.u.a.a) lVar;
        x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.qiK, this.qiH, "authorize:fail", null);
            this.qiL.aia();
        } else if (aVar instanceof com.tencent.mm.u.a.a) {
            final aou CU = aVar.CU();
            int i3 = CU.rRd.bMH;
            String str2 = CU.rRd.bMI;
            x.i("MicroMsg.MsgHandler", "NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                ah.A(new Runnable() {
                    public final void run() {
                        LinkedList linkedList = CU.rEI;
                        String str = CU.jSv;
                        String str2 = CU.rbh;
                        com.tencent.mm.plugin.webview.ui.tools.widget.l lVar = new com.tencent.mm.plugin.webview.ui.tools.widget.l(g.j(g$6.this.qiK));
                        1 1 = new 1(this);
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                            g.a(g$6.this.qiK, g$6.this.qiH, "authorize:fail", null);
                            g$6.this.qiL.aia();
                        } else if (!lVar.a(linkedList, str, str2, 1)) {
                            g$6.this.qiL.aia();
                        }
                    }
                });
            } else if (i3 == 0) {
                g.a(this.qiK, this.qiH, "authorize:ok", null);
                this.qiL.aia();
            } else {
                x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                g.a(this.qiK, this.qiH, "authorize:fail", null);
                this.qiL.aia();
            }
        }
    }
}
