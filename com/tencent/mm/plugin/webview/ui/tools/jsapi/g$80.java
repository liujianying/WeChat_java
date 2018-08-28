package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$80 implements b {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjx;

    g$80(g gVar, String str, i iVar) {
        this.qiK = gVar;
        this.qjx = str;
        this.qiH = iVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.MsgHandler", "doDownloadVoice, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
        if (!bi.oW(str2) && str2.equals(this.qjx)) {
            e.bUW().a(this);
            if (g.l(this.qiK) != null) {
                g.l(this.qiK).dismiss();
                g.a(this.qiK, null);
            }
            if (z) {
                Map hashMap = new HashMap();
                hashMap.put("localId", str);
                g.a(this.qiK, this.qiH, "downloadVoice:ok", hashMap);
                return;
            }
            g.a(this.qiK, this.qiH, "downloadVoice:fail", null);
        }
    }
}
