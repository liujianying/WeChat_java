package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class WalletBrandUI$e implements b {
    final /* synthetic */ WalletBrandUI pDC;

    WalletBrandUI$e(WalletBrandUI walletBrandUI) {
        this.pDC = walletBrandUI;
    }

    public final int bRf() {
        return 2755;
    }

    public final l bRg() {
        WalletBrandUI.a(this.pDC, this.pDC.getIntent().getStringExtra("appId"));
        String stringExtra = this.pDC.getIntent().getStringExtra("signtype");
        String stringExtra2 = this.pDC.getIntent().getStringExtra("nonceStr");
        String stringExtra3 = this.pDC.getIntent().getStringExtra("timeStamp");
        String stringExtra4 = this.pDC.getIntent().getStringExtra("packageExt");
        String stringExtra5 = this.pDC.getIntent().getStringExtra("paySignature");
        String stringExtra6 = this.pDC.getIntent().getStringExtra("url");
        String stringExtra7 = this.pDC.getIntent().getStringExtra("ext_info");
        WalletBrandUI.b(this.pDC, this.pDC.getIntent().getStringExtra("bizUsername"));
        com.tencent.mm.plugin.wallet_index.c.b bVar = new com.tencent.mm.plugin.wallet_index.c.b(WalletBrandUI.c(this.pDC), stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.d(this.pDC), this.pDC.getIntent().getIntExtra("pay_channel", 0), WalletBrandUI.e(this.pDC), stringExtra7);
        bVar.iNJ = System.currentTimeMillis();
        bVar.dox = "PayProcess";
        bVar.fdx = WalletBrandUI.e(this.pDC);
        g.Ek();
        g.Eh().dpP.a(bVar, 0);
        return bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet_index.c.b bVar = (com.tencent.mm.plugin.wallet_index.c.b) lVar;
            String str2 = bVar.pCN;
            x.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
            PayInfo payInfo = new PayInfo();
            payInfo.bOd = str2;
            payInfo.appId = WalletBrandUI.c(this.pDC);
            payInfo.pCO = bVar.pCO;
            payInfo.bVY = WalletBrandUI.e(this.pDC);
            payInfo.Yy = str;
            payInfo.bVU = this.pDC.getIntent().getIntExtra("pay_channel", 16);
            payInfo.qUN = bVar.iNJ;
            u.j(payInfo.bVY, str2, i2);
            h.a(this.pDC, payInfo, 1);
            return;
        }
        this.pDC.finish();
    }
}
