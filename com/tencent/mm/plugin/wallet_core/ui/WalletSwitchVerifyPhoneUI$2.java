package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.protocal.c.fd;
import java.util.Comparator;

class WalletSwitchVerifyPhoneUI$2 implements Comparator<fd> {
    final /* synthetic */ WalletSwitchVerifyPhoneUI pyw;

    WalletSwitchVerifyPhoneUI$2(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        this.pyw = walletSwitchVerifyPhoneUI;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        fd fdVar = (fd) obj;
        fd fdVar2 = (fd) obj2;
        if (fdVar.rfW.equals("wx") && fdVar2.rfW.equals("cft")) {
            return -1;
        }
        return (fdVar.rfW.equals("cft") && fdVar2.rfW.equals("wx")) ? 1 : 0;
    }
}
