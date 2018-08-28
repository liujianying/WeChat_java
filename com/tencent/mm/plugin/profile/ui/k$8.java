package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.g.a.qu;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONObject;

class k$8 implements b {
    final /* synthetic */ c.b lWC;
    final /* synthetic */ a lWD;
    final /* synthetic */ k lWx;

    k$8(k kVar, c.b bVar, a aVar) {
        this.lWx = kVar;
        this.lWC = bVar;
        this.lWD = aVar;
    }

    public final boolean bnw() {
        try {
            JSONObject jSONObject = new JSONObject(this.lWC.euo);
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("pagepath");
            qu quVar = new qu();
            quVar.cbq.userName = optString;
            quVar.cbq.cbs = bi.aG(optString2, "");
            com.tencent.mm.sdk.b.a.sFg.m(quVar);
            h.mEJ.h(15319, new Object[]{this.lWx.guS.field_openImAppid, Integer.valueOf(this.lWC.action), this.lWD.title});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
        }
        return true;
    }
}
