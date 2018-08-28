package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$19 implements OnClickListener {
    final /* synthetic */ x kTz;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$19(LuckyMoneyPrepareUI luckyMoneyPrepareUI, x xVar) {
        this.kWX = luckyMoneyPrepareUI;
        this.kTz = xVar;
    }

    public final void onClick(View view) {
        e.l(this.kWX.mController.tml, this.kTz.kRf, false);
    }
}
