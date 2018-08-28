package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c.g;

class WalletIdCardCheckUI$2 implements OnClickListener {
    final /* synthetic */ WalletIdCardCheckUI phR;

    WalletIdCardCheckUI$2(WalletIdCardCheckUI walletIdCardCheckUI) {
        this.phR = walletIdCardCheckUI;
    }

    public final void onClick(View view) {
        if (WalletIdCardCheckUI.a(this.phR)) {
            h.mEJ.h(13731, new Object[]{Integer.valueOf(2)});
            this.phR.a(new g(WalletIdCardCheckUI.b(this.phR).getText(), WalletIdCardCheckUI.c(this.phR), o.bOW().aCl()), true, true);
        }
    }
}
