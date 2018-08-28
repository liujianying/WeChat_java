package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$14 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$14(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void onClick(View view) {
        if (view.getId() != f.wallet_qrcode_iv && view.getId() != f.wallet_barcode_iv && view.getId() != f.wallet_barcode_tv) {
            return;
        }
        if (view.getId() == f.wallet_qrcode_iv && WalletOfflineCoinPurseUI.u(this.lMe) != null && WalletOfflineCoinPurseUI.u(this.lMe).isShowing()) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if ((WalletOfflineCoinPurseUI.u(this.lMe) == null || !WalletOfflineCoinPurseUI.u(this.lMe).isShowing()) && currentTimeMillis - WalletOfflineCoinPurseUI.v(this.lMe) >= 400 && a.bly() && !WalletOfflineCoinPurseUI.w(this.lMe)) {
            if (view.getId() == f.wallet_qrcode_iv) {
                WalletOfflineCoinPurseUI.a(this.lMe, false);
            } else if (view.getId() == f.wallet_barcode_iv || view.getId() == f.wallet_barcode_tv) {
                h.mEJ.h(13958, new Object[]{Integer.valueOf(4)});
                WalletOfflineCoinPurseUI.a(this.lMe, true);
            }
            if (WalletOfflineCoinPurseUI.x(this.lMe) != null) {
                WalletOfflineCoinPurseUI.y(this.lMe);
                WalletOfflineCoinPurseUI.x(this.lMe).v(view, WalletOfflineCoinPurseUI.z(this.lMe));
            }
            WalletOfflineCoinPurseUI.a(this.lMe, currentTimeMillis);
        }
    }
}
