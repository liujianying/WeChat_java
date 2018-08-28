package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONObject;

class k$5 implements b {
    final /* synthetic */ c.b lWC;
    final /* synthetic */ a lWD;
    final /* synthetic */ k lWx;

    k$5(k kVar, c.b bVar, a aVar) {
        this.lWx = kVar;
        this.lWC = bVar;
        this.lWD = aVar;
    }

    public final boolean bnw() {
        String str = this.lWC.euo;
        try {
            str = new JSONObject(this.lWC.euo).optString("tel");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
        }
        h.mEJ.h(15319, new Object[]{this.lWx.guS.field_openImAppid, Integer.valueOf(this.lWC.action), this.lWD.title});
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.setFlags(268435456);
        this.lWx.bOb.startActivity(intent);
        return true;
    }
}
