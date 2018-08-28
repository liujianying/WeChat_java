package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.ol;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.ndk.Encrypt;

class WalletBankcardIdUI$2 extends c<ol> {
    final /* synthetic */ WalletBankcardIdUI psW;

    WalletBankcardIdUI$2(WalletBankcardIdUI walletBankcardIdUI) {
        this.psW = walletBankcardIdUI;
        this.sFo = ol.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ol olVar = (ol) bVar;
        if (olVar instanceof ol) {
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletBankcardIdUI.a(this.psW, encrypt.desedeEncode(olVar.bZo.cardId, randomKey), randomKey, olVar.bZo.bZp);
            this.psW.finish();
            return true;
        }
        x.f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
        return false;
    }
}
