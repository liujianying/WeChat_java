package com.tencent.mm.plugin.offline.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.sdk.b.a;

class WalletOfflineCoinPurseUI$33 implements OnMenuItemClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$33(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        gg ggVar = new gg();
        ggVar.bPt.bPu = "ok";
        a.sFg.m(ggVar);
        if (WalletOfflineCoinPurseUI.c(this.lMe) == 8) {
            com.tencent.mm.plugin.offline.c.a.Jl(this.lMe.getIntent().getStringExtra("key_appid"));
        }
        this.lMe.finish();
        return false;
    }
}
