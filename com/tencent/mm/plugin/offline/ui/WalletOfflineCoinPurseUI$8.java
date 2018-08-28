package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class WalletOfflineCoinPurseUI$8 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ ImageView lMp;

    WalletOfflineCoinPurseUI$8(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMp = imageView;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
        h.mEJ.h(14021, new Object[]{Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.lMe))});
        d.A(this.lMe.mController.tml, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
        if (c.Cp().b(a.sZe, a.sYe)) {
            c.Cp().c(a.sZe, a.sYe);
            this.lMp.setVisibility(8);
            h.mEJ.h(14396, new Object[]{Integer.valueOf(5)});
        }
    }
}
