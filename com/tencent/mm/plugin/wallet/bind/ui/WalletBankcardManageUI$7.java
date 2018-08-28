package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class WalletBankcardManageUI$7 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI pdm;
    final /* synthetic */ f pdo;

    WalletBankcardManageUI$7(WalletBankcardManageUI walletBankcardManageUI, f fVar) {
        this.pdm = walletBankcardManageUI;
        this.pdo = fVar;
    }

    public final void onClick(View view) {
        qu quVar = new qu();
        quVar.cbq.userName = this.pdo.pmw;
        quVar.cbq.cbs = bi.aG(this.pdo.pmx, "");
        quVar.cbq.scene = 1071;
        quVar.cbq.cbt = 0;
        a.sFg.m(quVar);
    }
}
