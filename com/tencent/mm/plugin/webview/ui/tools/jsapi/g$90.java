package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.t;
import com.tencent.mm.protocal.c.aaw;
import java.util.HashMap;
import java.util.Map;

class g$90 implements e {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$90(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        aaw aaw;
        String str2;
        int i3 = -1;
        t.a(this);
        String str3 = "getEnterpriseChat:fail";
        if (i == 0 && i2 == 0) {
            t tVar = (t) lVar;
            if (tVar.diG == null || tVar.diG.dIE.dIL == null) {
                aaw = null;
            } else {
                aaw = (aaw) tVar.diG.dIE.dIL;
            }
            if (aaw == null || aaw.riQ == null) {
                str2 = str3;
            } else {
                i3 = aaw.riQ.ret;
                if (aaw.riQ.bMI == null || aaw.riQ.bMI.length() <= 0) {
                    str2 = str3;
                } else {
                    str2 = "getEnterpriseChat:fail_" + aaw.riQ.bMI;
                }
            }
        } else {
            str2 = str3;
            aaw = null;
        }
        if (i3 != 0) {
            g.a(this.qiK, this.qiH, str2, null);
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("result", aaw.result);
        g.a(this.qiK, this.qiH, "getEnterpriseChat:ok", hashMap);
    }
}
