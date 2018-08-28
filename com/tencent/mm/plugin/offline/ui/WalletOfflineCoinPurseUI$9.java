package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.g;

class WalletOfflineCoinPurseUI$9 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ ImageView lMq;

    WalletOfflineCoinPurseUI$9(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMq = imageView;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
        h.mEJ.h(14021, new Object[]{Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.lMe))});
        if (c.Cp().b(a.sZf, a.sYe)) {
            c.Cp().c(a.sZf, a.sYe);
            this.lMq.setVisibility(8);
        }
        if (o.bOW().bPs()) {
            d.A(this.lMe.mController.tml, "collect", ".reward.ui.QrRewardMainUI");
            return;
        }
        WalletOfflineCoinPurseUI.a(this.lMe, g.a(this.lMe.mController.tml, false, new 1(this)));
        o.bOR();
        WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = this.lMe;
        i r = WalletOfflineCoinPurseUI.r(this.lMe);
        2 2 = new 2(this);
        if (!o.b(walletOfflineCoinPurseUI, r)) {
            this.lMe.a(new f("reward"), true, false);
        }
    }
}
