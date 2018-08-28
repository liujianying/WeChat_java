package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class WalletOfflineCoinPurseUI$7 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ ImageView lMo;

    WalletOfflineCoinPurseUI$7(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMo = imageView;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
        h.mEJ.h(14021, new Object[]{Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.lMe))});
        d.A(this.lMe.mController.tml, "aa", ".ui.AAEntranceUI");
        if (c.Cp().b(a.sZc, a.sYe)) {
            c.Cp().c(a.sZc, a.sYe);
            this.lMo.setVisibility(8);
            h.mEJ.h(14396, new Object[]{Integer.valueOf(4)});
        }
    }
}
