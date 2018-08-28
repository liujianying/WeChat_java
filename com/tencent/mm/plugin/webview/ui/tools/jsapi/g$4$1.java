package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class g$4$1 implements Runnable {
    final /* synthetic */ String jHi;
    final /* synthetic */ aoy qiM;
    final /* synthetic */ 4 qiN;

    g$4$1(4 4, aoy aoy, String str) {
        this.qiN = 4;
        this.qiM = aoy;
        this.jHi = str;
    }

    public final void run() {
        LinkedList linkedList = this.qiM.rEI;
        x.d("MicroMsg.MsgHandler", "appName %s, appIconUrl %s", new Object[]{this.qiM.jSv, this.qiM.rbh});
        l lVar = new l(g.j(this.qiN.qiK));
        1 1 = new 1(this);
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
            g.a(this.qiN.qiK, this.qiN.qiH, "login:fail", null);
            this.qiN.qiL.aia();
        } else if (!lVar.a(linkedList, r1, r2, 1)) {
            this.qiN.qiL.aia();
        }
    }
}
