package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a;
import com.tencent.mm.sdk.platformtools.bi;

class WalletOrderInfoOldUI$a$2 implements OnClickListener {
    final /* synthetic */ a pwE;
    final /* synthetic */ Commodity pwF;

    WalletOrderInfoOldUI$a$2(a aVar, Commodity commodity) {
        this.pwE = aVar;
        this.pwF = commodity;
    }

    public final void onClick(View view) {
        qu quVar = new qu();
        quVar.cbq.userName = this.pwF.ppD.paD;
        quVar.cbq.cbs = bi.aG(this.pwF.ppD.paE, "");
        quVar.cbq.scene = 1034;
        quVar.cbq.cbt = 0;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        h.mEJ.h(14118, new Object[]{this.pwE.pwD.lJJ, this.pwE.pwD.bNs(), Integer.valueOf(1)});
    }
}
