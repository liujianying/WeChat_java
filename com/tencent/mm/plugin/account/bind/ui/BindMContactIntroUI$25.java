package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.ui.i$a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMWizardActivity;

class BindMContactIntroUI$25 implements i$a {
    final /* synthetic */ BindMContactIntroUI eGe;
    final /* synthetic */ String eGk;

    BindMContactIntroUI$25(BindMContactIntroUI bindMContactIntroUI, String str) {
        this.eGe = bindMContactIntroUI;
        this.eGk = str;
    }

    public final void e(int i, Bundle bundle) {
        Intent intent;
        if (i == 1) {
            if (BindMContactIntroUI.f(this.eGe)) {
                if (!q.GN()) {
                    sf sfVar = new sf();
                    sfVar.ccY.ccZ = true;
                    sfVar.ccY.cda = true;
                    a.sFg.m(sfVar);
                }
                BindMContactIntroUI.g(this.eGe);
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.account.a.a.ezn.e(this.eGe, intent);
                return;
            }
            MMWizardActivity.D(this.eGe, new Intent(this.eGe, BindMContactStatusUI.class).putExtra("is_bind_for_contact_sync", BindMContactIntroUI.h(this.eGe)));
            if (!BindMContactIntroUI.i(this.eGe)) {
                return;
            }
            if (BindMContactIntroUI.h(this.eGe)) {
                h.mEJ.h(11002, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
                return;
            }
            h.mEJ.h(11002, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
        } else if (i == 2) {
            intent = new Intent(this.eGe, BindMContactVerifyUI.class);
            intent.putExtra("bindmcontact_mobile", this.eGk);
            intent.putExtra("is_bind_for_safe_device", BindMContactIntroUI.f(this.eGe));
            intent.putExtra("is_bind_for_contact_sync", BindMContactIntroUI.h(this.eGe));
            intent.putExtra("KEnterFromBanner", BindMContactIntroUI.i(this.eGe));
            MMWizardActivity.D(this.eGe, intent);
        }
    }
}
