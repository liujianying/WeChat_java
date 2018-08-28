package com.tencent.mm.plugin.wallet_core.ui;

import android.os.CountDownTimer;
import com.tencent.mm.plugin.wxpay.a.i;

class WalletVerifyCodeUI$a extends CountDownTimer {
    final /* synthetic */ WalletVerifyCodeUI pyT;

    public WalletVerifyCodeUI$a(WalletVerifyCodeUI walletVerifyCodeUI, long j) {
        this.pyT = walletVerifyCodeUI;
        super(j, 1000);
    }

    public final void onTick(long j) {
        WalletVerifyCodeUI.f(this.pyT).setText(this.pyT.getString(i.wallet_verify_get_more_one) + "(" + (j / 1000) + ")");
    }

    public final void onFinish() {
        WalletVerifyCodeUI.f(this.pyT).setClickable(true);
        WalletVerifyCodeUI.f(this.pyT).setEnabled(true);
        WalletVerifyCodeUI.f(this.pyT).setText(this.pyT.getString(i.wallet_verify_get_more_one));
    }
}
