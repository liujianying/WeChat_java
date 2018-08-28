package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.x;

class WalletSwitchVerifyPhoneUI$1 implements a {
    final /* synthetic */ WalletSwitchVerifyPhoneUI pyw;

    WalletSwitchVerifyPhoneUI$1(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        this.pyw = walletSwitchVerifyPhoneUI;
    }

    public final void cZ(View view) {
        if (view.getTag() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue == -1) {
                x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                WalletSwitchVerifyPhoneUI.a(this.pyw);
            } else if (intValue == -2) {
                x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
                this.pyw.sy.putBoolean("key_forward_to_id_verify", true);
                com.tencent.mm.wallet_core.a.j(this.pyw, this.pyw.sy);
            } else {
                fd fdVar = (fd) WalletSwitchVerifyPhoneUI.b(this.pyw).get(intValue);
                this.pyw.sy.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[]{Boolean.valueOf(fdVar.rfW.equals("wx"))});
                this.pyw.cDL().m(new Object[]{fdVar});
            }
        }
    }
}
