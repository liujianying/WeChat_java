package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.protocal.c.btt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class g$110 implements e {
    final /* synthetic */ String bAj;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$110(g gVar, i iVar, String str) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.bAj = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (g.l(this.qiK) != null && g.l(this.qiK).isShowing()) {
            g.l(this.qiK).dismiss();
            g.a(this.qiK, null);
        }
        if (i == 0 && i2 == 0) {
            btt btt;
            w wVar = (w) lVar;
            if (wVar.diG == null) {
                btt = null;
            } else {
                btt = (btt) wVar.diG.dIE.dIL;
            }
            if (btt != null) {
                String str2 = btt.username;
                if (bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
                } else if (g.j(this.qiK) instanceof MMActivity) {
                    if (g.a(this.qiK, this.bAj, (String) this.qiH.mcy.get("title"), (String) this.qiH.mcy.get("img_url"), str2, (String) this.qiH.mcy.get("desc"), (String) this.qiH.mcy.get("src_username"), (String) this.qiH.mcy.get("src_displayname"), "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") == null) {
                        x.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
                        g.a(this.qiK, this.qiH, "sendAppMessageToSpecifiedContact:fail", null);
                    } else {
                        return;
                    }
                }
            }
            x.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
        } else {
            x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
        }
        g.a(this.qiK, this.qiH, "sendAppMessageToSpecifiedContact:fail", null);
    }
}
