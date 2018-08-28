package com.tencent.mm.plugin.wallet_core.ui;

import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$15 implements Runnable {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$15(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
    }

    public final void run() {
        int i;
        int i2;
        int height = WalletOrderInfoNewUI.e(this.pwh).getHeight();
        int height2 = this.pwh.findViewById(f.root_layout).getHeight();
        int i3 = WalletOrderInfoNewUI.f(this.pwh).getVisibility() == 0 ? 1 : 0;
        if (WalletOrderInfoNewUI.g(this.pwh).getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (WalletOrderInfoNewUI.h(this.pwh).getVisibility() == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i != 0) {
            i = WalletOrderInfoNewUI.g(this.pwh).getBottom();
        } else {
            i = -1;
        }
        if (i3 != 0) {
            i3 = WalletOrderInfoNewUI.f(this.pwh).getBottom();
        } else {
            i3 = i;
        }
        if (i2 != 0) {
            i3 = WalletOrderInfoNewUI.h(this.pwh).getBottom();
        }
        if (i3 <= 0) {
            i3 = this.pwh.findViewById(f.pay_info_layout).getBottom();
        }
        if (WalletOrderInfoNewUI.i(this.pwh).getVisibility() == 0 || WalletOrderInfoNewUI.c(this.pwh).getVisibility() == 0) {
            i = height;
        } else {
            i = a.fromDPToPix(this.pwh, 70) + height;
        }
        height = (height2 - i3) - i;
        int fromDPToPix = a.fromDPToPix(this.pwh, 50);
        x.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(height2), Integer.valueOf(height), Integer.valueOf(fromDPToPix)});
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WalletOrderInfoNewUI.e(this.pwh).getLayoutParams();
        if (height > fromDPToPix) {
            marginLayoutParams.topMargin = height;
        } else {
            marginLayoutParams.topMargin = fromDPToPix;
        }
        WalletOrderInfoNewUI.e(this.pwh).setLayoutParams(marginLayoutParams);
        WalletOrderInfoNewUI.e(this.pwh).setVisibility(0);
    }
}
