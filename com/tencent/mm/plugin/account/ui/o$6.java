package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;

class o$6 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ String eTD;
    final /* synthetic */ o eTO;
    final /* synthetic */ String eTQ;
    final /* synthetic */ boolean eTR;
    final /* synthetic */ String eTS;
    final /* synthetic */ String eTT;
    final /* synthetic */ int eTU;

    o$6(o oVar, l lVar, String str, String str2, boolean z, String str3, String str4, int i) {
        this.eTO = oVar;
        this.bFp = lVar;
        this.eTD = str;
        this.eTQ = str2;
        this.eTR = z;
        this.eTS = str3;
        this.eTT = str4;
        this.eTU = i;
    }

    public final void run() {
        this.eTO.eHp = ((s) this.bFp).Rn();
        at.dBv.T("login_user_name", this.eTD);
        Intent be;
        if (this.eTQ == null || !this.eTQ.contains("0")) {
            be = a.ezn.be(this.eTO.eTG);
            be.addFlags(67108864);
            this.eTO.eTG.startActivity(be);
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eTO.eTG.getClass().getName()).append(",R200_900_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",4").toString());
            this.eTO.eTG.finish();
            return;
        }
        com.tencent.mm.plugin.c.a.pU("R300_100_phone");
        if (this.eTR) {
            be = new Intent(this.eTO.eTG, FindMContactAlertUI.class);
            be.putExtra("alert_title", this.eTS);
            be.putExtra("alert_message", this.eTT);
        } else {
            be = new Intent(this.eTO.eTG, FindMContactIntroUI.class);
        }
        be.addFlags(67108864);
        be.putExtra("regsetinfo_ticket", this.eTO.eHp);
        be.putExtra("regsetinfo_NextStep", this.eTQ);
        be.putExtra("regsetinfo_NextStyle", this.eTU);
        Intent be2 = a.ezn.be(this.eTO.eTG);
        be2.addFlags(67108864);
        MMWizardActivity.b(this.eTO.eTG, be, be2);
        this.eTO.eTG.finish();
    }
}
