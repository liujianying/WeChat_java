package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.d;

class WalletDigitalCertUI$4 extends d {
    final /* synthetic */ WalletDigitalCertUI phy;

    WalletDigitalCertUI$4(WalletDigitalCertUI walletDigitalCertUI) {
        this.phy = walletDigitalCertUI;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            h.a(this.phy, this.phy.getString(i.wallet_password_setting_digitalcert_del_alert, new Object[]{rVar.sxq}), "", this.phy.getString(i.app_delete), this.phy.getString(i.app_cancel), true, new 1(this, rVar), null);
        }
    }
}
