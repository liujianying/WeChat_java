package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.g.a.ol;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.ndk.Encrypt;

class WalletForgotPwdUI$7 extends c<ol> {
    final /* synthetic */ WalletForgotPwdUI phK;

    WalletForgotPwdUI$7(WalletForgotPwdUI walletForgotPwdUI) {
        this.phK = walletForgotPwdUI;
        this.sFo = ol.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ol olVar = (ol) bVar;
        if (olVar instanceof ol) {
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletForgotPwdUI.a(this.phK, encrypt.desedeEncode(olVar.bZo.cardId, randomKey), randomKey, olVar.bZo.bZp);
            return true;
        }
        x.f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
        return false;
    }
}
