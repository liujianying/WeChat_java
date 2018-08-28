package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.bxu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class bv$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ bv fHr;

    bv$1(bv bvVar, l lVar, int i) {
        this.fHr = bvVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        boolean z = true;
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            bxu bxu = (bxu) bVar.dIE.dIL;
            Map hashMap = new HashMap();
            try {
                hashMap.put("data", new JSONObject(bxu.stU));
                this.fCl.E(this.doP, this.fHr.f("ok", hashMap));
                return;
            } catch (Exception e) {
                this.fCl.E(this.doP, this.fHr.f("fail:resp invalid", null));
                return;
            }
        }
        String str2 = "MicroMsg.JsApiVerifyPlugin";
        String str3 = "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (bVar.dIE.dIL != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        x.e(str2, str3, objArr);
        this.fCl.E(this.doP, this.fHr.f("fail:cgi fail", null));
    }
}
