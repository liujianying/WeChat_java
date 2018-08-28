package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public final class n implements e, MobileVerifyUI$b {
    private String eHp = null;
    private String eHq = "";
    private int eHr = 2;
    private MobileVerifyUI eTG;

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.eTG = mobileVerifyUI;
        this.eHp = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.eHq = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.eHr = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean jn(int i) {
        hp hpVar;
        String str;
        hq hqVar;
        String str2;
        x xVar;
        MobileVerifyUI mobileVerifyUI;
        MobileVerifyUI mobileVerifyUI2;
        switch (3.eTK[i - 1]) {
            case 1:
                hpVar = new hp();
                hpVar.bQV.context = this.eTG;
                a.sFg.m(hpVar);
                str = hpVar.bQW.bQX;
                hqVar = new hq();
                a.sFg.m(hqVar);
                str2 = hqVar.bQY.bQZ;
                g.DF().a(132, this);
                xVar = new x(this.eTG.bTi, 2, this.eTG.eGC.getText().toString().trim(), "", str, str2);
                g.DF().a(xVar, 0);
                mobileVerifyUI = this.eTG;
                mobileVerifyUI2 = this.eTG;
                this.eTG.getString(j.app_tip);
                mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.bind_mcontact_verifing), true, new 2(this, xVar));
                break;
            case 2:
                g.DF().a(132, this);
                g.DF().a(new x(this.eTG.bTi, 1, "", 0, ""), 0);
                break;
            case 3:
                hpVar = new hp();
                hpVar.bQV.context = this.eTG;
                a.sFg.m(hpVar);
                str = hpVar.bQW.bQX;
                hqVar = new hq();
                a.sFg.m(hqVar);
                str2 = hqVar.bQY.bQZ;
                g.DF().a(132, this);
                xVar = new x(this.eTG.bTi, 2, this.eTG.eGC.getText().toString().trim(), "", str, str2);
                g.DF().a(xVar, 0);
                mobileVerifyUI = this.eTG;
                mobileVerifyUI2 = this.eTG;
                this.eTG.getString(j.app_tip);
                mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.bind_mcontact_verifing), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.DF().c(xVar);
                        g.DF().b(132, n.this);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eTG.eHw != null) {
            this.eTG.eHw.dismiss();
            this.eTG.eHw = null;
        }
        if (lVar.getType() == 132) {
            g.DF().b(132, this);
            if (((x) lVar).Oh() == 2 && i == 0 && i2 == 0) {
                com.tencent.mm.kernel.a.unhold();
                if (com.tencent.mm.pluginsdk.a.eI(this.eTG).size() != 0) {
                    i3 = 1;
                }
                Intent be;
                if (this.eHq == null || !this.eHq.contains("1") || i3 == 0) {
                    be = com.tencent.mm.plugin.account.a.a.ezn.be(this.eTG);
                    be.addFlags(67108864);
                    this.eTG.startActivity(be);
                    this.eTG.eUl = 4;
                    this.eTG.finish();
                    return;
                }
                com.tencent.mm.plugin.c.a.pU("R300_300_QQ");
                be = new Intent(this.eTG, FindMContactAddUI.class);
                be.addFlags(67108864);
                be.putExtra("regsetinfo_ticket", this.eHp);
                be.putExtra("regsetinfo_NextStep", this.eHq);
                be.putExtra("regsetinfo_NextStyle", this.eHr);
                be.putExtra("login_type", 1);
                Intent be2 = com.tencent.mm.plugin.account.a.a.ezn.be(this.eTG);
                be2.addFlags(67108864);
                MMWizardActivity.b(this.eTG, be, be2);
                this.eTG.finish();
            }
        } else if (!this.eTG.e(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.eTG, this.eTG.getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
