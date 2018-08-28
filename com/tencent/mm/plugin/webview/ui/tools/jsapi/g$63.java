package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.model.d$b;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$63 implements d$b {
    final /* synthetic */ String gkR;
    final /* synthetic */ String jHJ;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$63(g gVar, String str, String str2, i iVar) {
        this.qiK = gVar;
        this.gkR = str;
        this.jHJ = str2;
        this.qiH = iVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.MsgHandler", this.gkR + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bi.oW(str) && str.equals(this.jHJ)) {
            e.bUW().a(this);
            if (g.l(this.qiK) != null) {
                g.l(this.qiK).dismiss();
                g.a(this.qiK, null);
            }
            if (z) {
                Map hashMap = new HashMap();
                hashMap.put("serverId", str2);
                hashMap.put("mediaUrl", str3);
                g.a(this.qiK, this.qiH, this.gkR + ":ok", hashMap);
                return;
            }
            g.a(this.qiK, this.qiH, this.gkR + ":fail", null);
        }
    }
}
