package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.ol;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.ndk.Encrypt;

class WalletCardElementUI$6 extends c<ol> {
    final /* synthetic */ WalletCardElementUI pun;

    WalletCardElementUI$6(WalletCardElementUI walletCardElementUI) {
        this.pun = walletCardElementUI;
        this.sFo = ol.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ol olVar = (ol) bVar;
        if (olVar instanceof ol) {
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletCardElementUI.a(this.pun, encrypt.desedeEncode(olVar.bZo.cardId, randomKey), randomKey, olVar.bZo.bZp);
            return true;
        }
        x.f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
        return false;
    }
}
