package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class WalletBrandUI$a implements WalletBrandUI$b {
    final /* synthetic */ WalletBrandUI pDC;
    private int pDD = 0;

    public WalletBrandUI$a(WalletBrandUI walletBrandUI) {
        this.pDC = walletBrandUI;
    }

    public final int bRf() {
        return 1563;
    }

    public final l bRg() {
        WalletBrandUI.a(this.pDC, this.pDC.getIntent().getStringExtra("appId"));
        String stringExtra = this.pDC.getIntent().getStringExtra("signtype");
        String stringExtra2 = this.pDC.getIntent().getStringExtra("nonceStr");
        String stringExtra3 = this.pDC.getIntent().getStringExtra("timeStamp");
        String stringExtra4 = this.pDC.getIntent().getStringExtra("packageExt");
        String stringExtra5 = this.pDC.getIntent().getStringExtra("paySignature");
        String stringExtra6 = this.pDC.getIntent().getStringExtra("url");
        this.pDD = this.pDC.getIntent().getIntExtra("result_jump_mode", 0);
        WalletBrandUI.b(this.pDC, this.pDC.getIntent().getStringExtra("bizUsername"));
        l aVar = new a(WalletBrandUI.c(this.pDC), stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra, stringExtra6, WalletBrandUI.d(this.pDC), this.pDC.getIntent().getIntExtra("pay_channel", 0));
        g.Ek();
        g.Eh().dpP.a(aVar, 0);
        return aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof a)) {
            String str2 = ((a) lVar).jumpUrl;
            x.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", str2);
            String str3 = ((a) lVar).pCZ;
            Intent intent;
            if (this.pDD == 1) {
                intent = new Intent();
                intent.putExtra("url", str2);
                intent.putExtra("jsInjectCode", str3);
                this.pDC.setResult(-1, intent);
            } else {
                intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                if (!bi.oW(str3)) {
                    intent.putExtra("shouldForceViewPort", true);
                    intent.putExtra("view_port_code", str3);
                }
                d.b(this.pDC, "webview", ".ui.tools.WebViewUI", intent);
                this.pDC.setResult(-1);
            }
            this.pDC.finish();
            return;
        }
        x.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        h.a(this.pDC, str, "", new 1(this), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletBrandUI$a.this.pDC.setResult(0);
                WalletBrandUI$a.this.pDC.finish();
            }
        });
    }
}
