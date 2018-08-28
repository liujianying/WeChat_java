package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.sv;
import java.util.HashMap;
import java.util.Map;

class g$33 implements Runnable {
    final /* synthetic */ sv pep;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$33(g gVar, sv svVar, i iVar) {
        this.qiK = gVar;
        this.pep = svVar;
        this.qiH = iVar;
    }

    public final void run() {
        if (this.pep.cdJ.retCode == 0) {
            Map hashMap = new HashMap();
            hashMap.put("buffer", this.pep.cdJ.buffer);
            g.a(this.qiK, this.qiH, "handleWCPayWalletBuffer:ok", hashMap);
        } else if (this.pep.cdJ.retCode == -2) {
            g.a(this.qiK, this.qiH, "handleWCPayWalletBuffer:null", null);
        } else {
            g.a(this.qiK, this.qiH, "handleWCPayWalletBuffer:fail", null);
        }
    }
}
