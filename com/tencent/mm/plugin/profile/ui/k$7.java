package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONObject;

class k$7 implements b {
    final /* synthetic */ c.b lWC;
    final /* synthetic */ a lWD;
    final /* synthetic */ k lWx;

    k$7(k kVar, c.b bVar, a aVar) {
        this.lWx = kVar;
        this.lWC = bVar;
        this.lWD = aVar;
    }

    public final boolean bnw() {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        String str = "";
        try {
            str = new JSONObject(this.lWC.euo).optString("url");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
        }
        h.mEJ.h(15319, new Object[]{this.lWx.guS.field_openImAppid, Integer.valueOf(this.lWC.action), this.lWD.title});
        intent.putExtra("rawUrl", str);
        ad.getContext().startActivity(intent);
        return true;
    }
}
