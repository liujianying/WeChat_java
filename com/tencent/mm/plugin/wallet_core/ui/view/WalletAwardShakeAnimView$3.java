package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.as;

class WalletAwardShakeAnimView$3 implements OnClickListener {
    final /* synthetic */ WalletAwardShakeAnimView pzP;

    WalletAwardShakeAnimView$3(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        this.pzP = walletAwardShakeAnimView;
    }

    public final void onClick(View view) {
        if (!WalletAwardShakeAnimView.e(this.pzP)) {
            WalletAwardShakeAnimView.f(this.pzP);
            as.I(this.pzP.getContext(), i.shake_sound_male);
            WalletAwardShakeAnimView.h(this.pzP);
            if (WalletAwardShakeAnimView.i(this.pzP) != null) {
                WalletAwardShakeAnimView.i(this.pzP).jE(false);
            }
        }
    }
}
