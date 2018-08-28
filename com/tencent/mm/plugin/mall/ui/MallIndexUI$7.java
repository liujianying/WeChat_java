package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.s.c;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.ui.e;

class MallIndexUI$7 implements OnClickListener {
    final /* synthetic */ MallIndexUI lab;

    MallIndexUI$7(MallIndexUI mallIndexUI) {
        this.lab = mallIndexUI;
    }

    public final void onClick(View view) {
        MallIndexUI mallIndexUI = this.lab;
        if (q.GS()) {
            d.A(mallIndexUI, "wallet_payu", ".bind.ui.WalletPayUBankcardManageUI");
        } else {
            d.A(mallIndexUI, "wallet", ".bind.ui.WalletBankcardManageUI");
        }
        e.He(5);
        h.mEJ.h(14419, new Object[]{this.lab.fMk, Integer.valueOf(3)});
        c.Cp().c(a.sYd, a.sYe);
    }
}
