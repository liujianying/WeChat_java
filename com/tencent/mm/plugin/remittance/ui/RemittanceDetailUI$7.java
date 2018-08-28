package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

class RemittanceDetailUI$7 implements a {
    final /* synthetic */ RemittanceDetailUI mCf;
    final /* synthetic */ boolean mCm;

    RemittanceDetailUI$7(RemittanceDetailUI remittanceDetailUI, boolean z) {
        this.mCf = remittanceDetailUI;
        this.mCm = z;
    }

    public final void onClick(View view) {
        if (this.mCm) {
            d.A(this.mCf, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        } else {
            h.ab(this.mCf, 0);
        }
    }
}
