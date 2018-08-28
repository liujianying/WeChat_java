package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.8;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.ui.base.n.d;

class MobileVerifyUI$8$2 implements d {
    final /* synthetic */ 8 eUt;

    MobileVerifyUI$8$2(8 8) {
        this.eUt = 8;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                MobileVerifyUI.g(this.eUt.eUo);
                return;
            case 1:
                this.eUt.eUo.YC();
                if (MobileVerifyUI.f(this.eUt.eUo) == 2) {
                    a.pU("R200_500");
                } else if (MobileVerifyUI.f(this.eUt.eUo) == 3) {
                    a.pU("F200_300");
                }
                Intent intent = new Intent(this.eUt.eUo, RegByMobileVoiceVerifyUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", this.eUt.eUo.bTi);
                bundle.putInt("voice_verify_type", MobileVerifyUI.h(this.eUt.eUo));
                intent.putExtras(bundle);
                this.eUt.eUo.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
