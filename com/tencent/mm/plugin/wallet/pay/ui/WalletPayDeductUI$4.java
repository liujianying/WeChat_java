package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.wallet_core.model.Orders$DeductShowInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayDeductUI$4 implements OnClickListener {
    final /* synthetic */ WalletPayDeductUI pgf;
    final /* synthetic */ Orders$DeductShowInfo pgi;

    WalletPayDeductUI$4(WalletPayDeductUI walletPayDeductUI, Orders$DeductShowInfo orders$DeductShowInfo) {
        this.pgf = walletPayDeductUI;
        this.pgi = orders$DeductShowInfo;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[]{Integer.valueOf(this.pgi.ppN)});
        if (this.pgi.ppN == 1) {
            if (!bi.oW(this.pgi.ppQ)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.pgi.ppQ);
                intent.putExtra("showShare", false);
                d.b(this.pgf, "webview", ".ui.tools.WebViewUI", intent);
            }
        } else if (this.pgi.ppN == 2) {
            qu quVar = new qu();
            quVar.cbq.userName = this.pgi.ppO;
            quVar.cbq.cbs = bi.aG(this.pgi.ppP, "");
            quVar.cbq.scene = 1097;
            quVar.cbq.cbt = 0;
            a.sFg.m(quVar);
        }
    }
}
