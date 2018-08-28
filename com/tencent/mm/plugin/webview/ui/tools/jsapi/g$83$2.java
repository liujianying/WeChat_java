package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.fi;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.83;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class g$83$2 implements Runnable {
    final /* synthetic */ 83 qjK;
    final /* synthetic */ fi qjL;

    g$83$2(83 83, fi fiVar) {
        this.qjK = 83;
        this.qjL = fiVar;
    }

    public final void run() {
        if (this.qjL.bNG.aoy) {
            if (g.l(this.qjK.qiK) != null) {
                g.l(this.qjK.qiK).dismiss();
                g.a(this.qjK.qiK, null);
            }
            if (bi.oW(this.qjL.bNG.content)) {
                g.a(this.qjK.qiK, this.qjK.qiH, "translateVoice:fail", null);
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("translateResult", this.qjL.bNG.content);
            g.a(this.qjK.qiK, this.qjK.qiH, "translateVoice:ok", hashMap);
        }
    }
}
