package com.tencent.mm.plugin.clean.ui.newui;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import org.json.JSONObject;

class CleanNewUI$5 extends c {
    final /* synthetic */ CleanNewUI hTB;

    CleanNewUI$5(CleanNewUI cleanNewUI, String str) {
        this.hTB = cleanNewUI;
        super(str);
    }

    public final void onComplete() {
        x.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[]{this.content});
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            au.HU();
            com.tencent.mm.model.c.DT().a(a.sSl, this.content);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            h.mEJ.a(282, 8, 1, false);
        }
    }
}
