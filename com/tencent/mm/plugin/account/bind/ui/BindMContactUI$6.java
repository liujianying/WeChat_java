package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

class BindMContactUI$6 implements a {
    final /* synthetic */ BindMContactUI eGA;
    final /* synthetic */ String eGk;

    BindMContactUI$6(BindMContactUI bindMContactUI, String str) {
        this.eGA = bindMContactUI;
        this.eGk = str;
    }

    public final void e(int i, Bundle bundle) {
        Intent intent;
        if (i == 1) {
            if (BindMContactUI.h(this.eGA)) {
                x.i("MicroMsg.BindMContactUI", "to startMySafedeviceListUI");
                if (!q.GN()) {
                    sf sfVar = new sf();
                    sfVar.ccY.ccZ = true;
                    sfVar.ccY.cda = true;
                    com.tencent.mm.sdk.b.a.sFg.m(sfVar);
                }
                BindMContactUI.i(this.eGA);
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.account.a.a.ezn.e(this.eGA, intent);
            } else if (BindMContactUI.j(this.eGA)) {
                x.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for change mobile");
                h.bA(this.eGA, this.eGA.getString(a$j.app_finish));
                MMWizardActivity.D(this.eGA, new Intent(this.eGA, BindMContactStatusUI.class));
            } else if (BindMContactUI.k(this.eGA) == 5) {
                x.i("MicroMsg.BindMContactUI", "to finish  finishWizard for get phone number");
                BindMContactUI.l(this.eGA);
            } else if (BindMContactUI.m(this.eGA)) {
                x.i("MicroMsg.BindMContactUI", "to RegByMobileSetPwdUI for reset pwd");
                this.eGA.finish();
                intent = new Intent();
                intent.addFlags(603979776);
                intent.putExtra("setpwd_ticket", bundle.getString("setpwd_ticket", ""));
                d.b(this.eGA, "account", ".ui.RegByMobileSetPwdUI", intent);
            } else {
                if (BindMContactUI.n(this.eGA)) {
                    if (BindMContactUI.o(this.eGA)) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11002, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11002, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                    }
                }
                x.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for contact sync or other");
                MMWizardActivity.D(this.eGA, new Intent(this.eGA, BindMContactStatusUI.class));
            }
        } else if (i == 2) {
            x.i("MicroMsg.BindMContactUI", "reg next to BindMContactVerifyUI for bind mobile");
            intent = new Intent(this.eGA, BindMContactVerifyUI.class);
            intent.putExtra("bindmcontact_mobile", this.eGk);
            intent.putExtra("is_bind_for_safe_device", BindMContactUI.h(this.eGA));
            intent.putExtra("is_bind_for_contact_sync", BindMContactUI.o(this.eGA));
            intent.putExtra("is_bind_for_change_mobile", BindMContactUI.j(this.eGA));
            intent.putExtra("is_bind_for_reset_pwd", BindMContactUI.m(this.eGA));
            intent.putExtra("KEnterFromBanner", BindMContactUI.n(this.eGA));
            if (BindMContactUI.p(this.eGA) != null) {
                intent.putExtra("BIND_FIND_ME_BY_MOBILE", BindMContactUI.p(this.eGA).isChecked());
            }
            intent.putExtra("BIND_FOR_QQ_REG", BindMContactUI.q(this.eGA));
            intent.putExtra("bind_scene", BindMContactUI.k(this.eGA));
            MMWizardActivity.D(this.eGA, intent);
        }
    }
}
