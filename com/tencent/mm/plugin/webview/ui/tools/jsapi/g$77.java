package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$77 implements b {
    final /* synthetic */ String jHJ;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$77(g gVar, String str, i iVar) {
        this.qiK = gVar;
        this.jHJ = str;
        this.qiH = iVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", new Object[]{Boolean.valueOf(z), str2, str});
        if (!bi.oW(str) && str.equals(this.jHJ)) {
            e.bUW().a(this);
            if (g.l(this.qiK) != null) {
                g.l(this.qiK).dismiss();
                g.a(this.qiK, null);
            }
            if (z) {
                Map hashMap = new HashMap();
                hashMap.put("serverId", str2);
                g.a(this.qiK, this.qiH, "uploadVoice:ok", hashMap);
                return;
            }
            g.a(this.qiK, this.qiH, "uploadVoice:fail", null);
        }
    }
}
