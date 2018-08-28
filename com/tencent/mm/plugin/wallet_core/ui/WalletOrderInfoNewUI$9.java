package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.am;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$9 extends c<am> {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$9(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
        this.sFo = am.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        am amVar = (am) bVar;
        String str = amVar.bHP.bHR;
        boolean z = amVar.bHP.bHS;
        x.i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(amVar.bHP.bHT), Boolean.valueOf(amVar.bHP.bHU)});
        if (amVar.bHP.bHU && !bi.oW(WalletOrderInfoNewUI.b(this.pwh))) {
            WalletOrderInfoNewUI.c(this.pwh).setVisibility(8);
        }
        if (!bi.oW(WalletOrderInfoNewUI.b(this.pwh))) {
            WalletOrderInfoNewUI.d(this.pwh).setClickable(z);
            WalletOrderInfoNewUI.d(this.pwh).setEnabled(z);
            WalletOrderInfoNewUI.d(this.pwh).setOnClickListener(null);
            if (r2) {
                WalletOrderInfoNewUI.d(this.pwh).setVisibility(8);
            }
        }
        amVar.bHQ.bGZ = true;
        return false;
    }
}
