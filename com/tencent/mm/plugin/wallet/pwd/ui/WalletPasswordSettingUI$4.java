package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.a;

class WalletPasswordSettingUI$4 implements a {
    final /* synthetic */ WalletPasswordSettingUI pif;

    WalletPasswordSettingUI$4(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.pif = walletPasswordSettingUI;
    }

    public final Intent n(int i, Bundle bundle) {
        x.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        sz szVar = new sz();
        if (i == -1) {
            szVar.cdR.scene = 17;
        } else if (i == 0) {
            szVar.cdR.scene = 18;
        } else {
            szVar.cdR.scene = 0;
        }
        szVar.cdS.cdN = new 1(this);
        com.tencent.mm.sdk.b.a.sFg.m(szVar);
        return null;
    }
}
