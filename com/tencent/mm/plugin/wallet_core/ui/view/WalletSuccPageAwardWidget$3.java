package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Color;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$3 implements a {
    final /* synthetic */ WalletSuccPageAwardWidget pAM;

    WalletSuccPageAwardWidget$3(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.pAM = walletSuccPageAwardWidget;
    }

    public final void jE(boolean z) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(WalletSuccPageAwardWidget.e(this.pAM))});
        h hVar;
        Object[] objArr;
        if (z) {
            hVar = h.mEJ;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.e(this.pAM) ? 2 : 1);
            hVar.h(15225, objArr);
        } else {
            hVar = h.mEJ;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(7);
            objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.e(this.pAM) ? 2 : 1);
            hVar.h(15225, objArr);
        }
        WalletSuccPageAwardWidget.d(this.pAM).setShakeHintWording(this.pAM.getContext().getString(a$i.wallet_shake_award_shaking_wording));
        WalletSuccPageAwardWidget.d(this.pAM).setShakeHintWordingColor(Color.parseColor("#9C9C9C"));
        WalletSuccPageAwardWidget.a(this.pAM, 2, false);
        WalletSuccPageAwardWidget.f(this.pAM);
    }
}
