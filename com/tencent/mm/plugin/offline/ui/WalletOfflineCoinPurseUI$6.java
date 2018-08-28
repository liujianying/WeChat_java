package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.s.c;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.d.i;

class WalletOfflineCoinPurseUI$6 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ ImageView lMk;
    final /* synthetic */ TextView lMl;
    final /* synthetic */ ImageView lMm;

    WalletOfflineCoinPurseUI$6(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, ImageView imageView, TextView textView, ImageView imageView2) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMk = imageView;
        this.lMl = textView;
        this.lMm = imageView2;
    }

    public final void onClick(View view) {
        if (c.Cp().b(a.sZd, a.sYe)) {
            c.Cp().c(a.sZd, a.sYe);
            this.lMk.setVisibility(8);
            this.lMl.setVisibility(8);
            this.lMm.setVisibility(8);
            g.Ek();
            g.Ei().DT().a(a.sYu, "");
            h.mEJ.h(14396, new Object[]{Integer.valueOf(3)});
        }
        if (o.bOW().bPs()) {
            WalletOfflineCoinPurseUI.m(this.lMe);
            return;
        }
        o.bOR();
        WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = this.lMe;
        i n = WalletOfflineCoinPurseUI.n(this.lMe);
        1 1 = new 1(this);
        if (!o.b(walletOfflineCoinPurseUI, n)) {
            this.lMe.a(new f("collect"), true, false);
        }
    }
}
