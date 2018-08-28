package com.tencent.mm.plugin.appbrand.report.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.a.p.2;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ p fJO;
    final /* synthetic */ b grc;

    b$2(b bVar, p pVar) {
        this.grc = bVar;
        this.fJO = pVar;
    }

    public final void run() {
        i iVar = this.grc.gqW;
        p pVar = this.fJO;
        Activity cJ = j.cJ(pVar.mContext);
        if (cJ != null && cJ.isFinishing()) {
            iVar.grH = true;
        }
        iVar.i(pVar);
        iVar.xP();
        p pVar2 = this.grc.gqY;
        p pVar3 = this.fJO;
        pVar2.grK = (String) pVar2.gsD.peekFirst();
        pVar2.grM = null;
        switch (2.fjK[e.qn(pVar2.appId).ordinal()]) {
            case 1:
                pVar2.grL = 3;
                break;
            case 2:
                pVar2.grL = 6;
                break;
            case 3:
                break;
            default:
                Intent intent = pVar2.fdO.fcz.getReporter().gqU;
                if (intent == null) {
                    pVar2.grL = 7;
                    break;
                }
                String str;
                if (intent.getComponent() == null) {
                    str = "";
                    x.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[]{intent});
                } else {
                    str = intent.getComponent().getClassName();
                }
                pVar2.grL = 8;
                pVar2.grM = bi.aG(intent.getStringExtra("appbrand_report_key_target_activity"), str);
                str = pVar2.grM;
                pVar2.gsD.pollFirst();
                pVar2.gsD.push(bi.oV(str));
                break;
        }
        Activity cJ2 = j.cJ(pVar3.mContext);
        if (cJ2 != null && cJ2.isFinishing()) {
            pVar2.grH = true;
        }
        pVar2.k(pVar3);
    }
}
