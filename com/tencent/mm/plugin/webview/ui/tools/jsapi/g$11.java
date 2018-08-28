package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$11 implements e {
    final /* synthetic */ g qiK;

    g$11(g gVar) {
        this.qiK = gVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (g.l(this.qiK) != null && g.l(this.qiK).isShowing()) {
            g.l(this.qiK).dismiss();
            g.a(this.qiK, null);
        }
        au.DF().b(1566, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
            com.tencent.mm.plugin.webview.model.l lVar2 = (com.tencent.mm.plugin.webview.model.l) lVar;
            aoj aoj = lVar2.diG == null ? null : (aoj) lVar2.diG.dIE.dIL;
            if (aoj == null) {
                g.a(this.qiK, g.k(this.qiK), "selectSingleContact:fail", null);
                return;
            }
            int i3;
            Object obj = g.k(this.qiK).mcy.get("result_sign_type");
            if (obj != null) {
                i3 = bi.getInt((String) obj, 0);
            } else {
                i3 = 0;
            }
            Map hashMap = new HashMap();
            hashMap.put("package", aoj.rsx);
            hashMap.put("sign", aoj.rsy);
            if (i3 == 1) {
                hashMap.put("signType", aoj.rsz);
            }
            hashMap.put("timestamp", aoj.rhq);
            hashMap.put("noncestr", aoj.rsw);
            x.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", new Object[]{aoj.rsx, aoj.rsy});
            g.a(this.qiK, g.k(this.qiK), "selectSingleContact:ok", hashMap);
            return;
        }
        x.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
        g.a(this.qiK, g.k(this.qiK), "selectSingleContact:fail", null);
    }
}
