package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.wallet_core.ui.e;

class SnsLuckyMoneyPrepareUI$6 implements OnClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;
    final /* synthetic */ x kTz;

    SnsLuckyMoneyPrepareUI$6(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, x xVar) {
        this.kTy = snsLuckyMoneyPrepareUI;
        this.kTz = xVar;
    }

    public final void onClick(View view) {
        e.l(this.kTy.mController.tml, this.kTz.kRf, false);
    }
}
