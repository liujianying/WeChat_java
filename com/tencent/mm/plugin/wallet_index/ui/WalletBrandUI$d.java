package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class WalletBrandUI$d implements b {
    final /* synthetic */ WalletBrandUI pDC;

    WalletBrandUI$d(WalletBrandUI walletBrandUI) {
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
        c cVar = new c(WalletBrandUI.c(this.pDC), stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.d(this.pDC), this.pDC.getIntent().getIntExtra("pay_channel", 0), WalletBrandUI.e(this.pDC), this.pDC.getIntent().getIntExtra("key_wx_app_scene", 0), this.pDC.getIntent().getStringExtra("cookie"));
        cVar.iNJ = System.currentTimeMillis();
        cVar.dox = "PayProcess";
        cVar.fdx = WalletBrandUI.e(this.pDC);
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
        return cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            c cVar = (c) lVar;
            String str2 = cVar.pCN;
            x.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
            PayInfo payInfo = new PayInfo();
            payInfo.bOd = str2;
            payInfo.appId = WalletBrandUI.c(this.pDC);
            payInfo.pCO = cVar.pCO;
            payInfo.bVY = WalletBrandUI.e(this.pDC);
            payInfo.Yy = str;
            payInfo.bVU = this.pDC.getIntent().getIntExtra("pay_channel", 0);
            payInfo.qUN = cVar.iNJ;
            u.j(payInfo.bVY, str2, i2);
            h.a(this.pDC, payInfo, 1);
            return;
        }
        u.j(WalletBrandUI.e(this.pDC), "", i2);
        Intent intent = new Intent();
        if (i != 0) {
            i2 = -1;
        }
        intent.putExtra("key_jsapi_pay_err_code", i2);
        String str3 = "key_jsapi_pay_err_msg";
        if (bi.oW(str)) {
            str = this.pDC.getString(i.wallet_net_err);
        }
        intent.putExtra(str3, str);
        this.pDC.setResult(5, intent);
        this.pDC.finish();
    }

    public final int bRf() {
        return 398;
    }
}
