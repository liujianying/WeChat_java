package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONObject;

class k$6 implements b {
    final /* synthetic */ c.b lWC;
    final /* synthetic */ a lWD;
    final /* synthetic */ k lWx;

    k$6(k kVar, c.b bVar, a aVar) {
        this.lWx = kVar;
        this.lWC = bVar;
        this.lWD = aVar;
    }

    public final boolean bnw() {
        String str = "";
        try {
            str = new JSONObject(this.lWC.euo).optString("mailto");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
        }
        h.mEJ.h(15319, new Object[]{this.lWx.guS.field_openImAppid, Integer.valueOf(this.lWC.action), this.lWD.title});
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:" + str));
        this.lWx.bOb.startActivity(intent);
        return true;
    }
}
