package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.tf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletPwdConfirmUI$6 extends c<tf> {
    final /* synthetic */ WalletPwdConfirmUI pxf;

    WalletPwdConfirmUI$6(WalletPwdConfirmUI walletPwdConfirmUI) {
        this.pxf = walletPwdConfirmUI;
        this.sFo = tf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((tf) bVar) instanceof tf) {
            x.d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
            WalletPwdConfirmUI.d(this.pxf);
            WalletPwdConfirmUI.e(this.pxf);
        }
        return false;
    }
}
