package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMWizardActivity;

class FacebookLoginUI$3 implements Runnable {
    final /* synthetic */ FacebookLoginUI eQv;

    FacebookLoginUI$3(FacebookLoginUI facebookLoginUI) {
        this.eQv = facebookLoginUI;
    }

    public final void run() {
        Intent be;
        if ((bi.a((Integer) g.Ei().DT().get(65833, null), 0) > 0 ? 1 : 0) != 0) {
            be = a.ezn.be(this.eQv);
            be.addFlags(67108864);
            Intent intent = new Intent(this.eQv.mController.tml, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 1);
            MMWizardActivity.b(this.eQv, intent, be);
        } else {
            be = a.ezn.be(this.eQv);
            be.addFlags(67108864);
            this.eQv.startActivity(be);
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eQv.getClass().getName()).append(",L14,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("L14")).append(",4").toString());
        }
        this.eQv.finish();
    }
}
