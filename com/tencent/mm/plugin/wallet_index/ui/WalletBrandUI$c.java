package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;

class WalletBrandUI$c implements WalletBrandUI$b {
    final /* synthetic */ WalletBrandUI pDC;

    WalletBrandUI$c(WalletBrandUI walletBrandUI) {
        this.pDC = walletBrandUI;
    }

    public final l bRg() {
        WalletBrandUI.a(this.pDC, this.pDC.getIntent().getStringExtra("appId"));
        String stringExtra = this.pDC.getIntent().getStringExtra("signtype");
        String stringExtra2 = this.pDC.getIntent().getStringExtra("nonceStr");
        String stringExtra3 = this.pDC.getIntent().getStringExtra("timeStamp");
        String stringExtra4 = this.pDC.getIntent().getStringExtra("packageExt");
        String stringExtra5 = this.pDC.getIntent().getStringExtra("paySignature");
        String stringExtra6 = this.pDC.getIntent().getStringExtra("url");
        WalletBrandUI.b(this.pDC, this.pDC.getIntent().getStringExtra("bizUsername"));
        l aVar = new a(WalletBrandUI.c(this.pDC), stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.d(this.pDC), this.pDC.getIntent().getIntExtra("pay_channel", 0));
        g.Ek();
        g.Eh().dpP.a(aVar, 0);
        return aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a aVar = (a) lVar;
        String str2 = aVar.pCN;
        x.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = str2;
        payInfo.appId = WalletBrandUI.c(this.pDC);
        payInfo.pCO = aVar.pCO;
        payInfo.bVY = WalletBrandUI.e(this.pDC);
        payInfo.Yy = str;
        payInfo.bVU = this.pDC.getIntent().getIntExtra("pay_channel", 0);
        h.a(this.pDC, payInfo, 1);
    }

    public final int bRf() {
        return 1521;
    }
}
