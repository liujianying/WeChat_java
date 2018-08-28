package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyMyRecordUI$6 implements OnClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;

    LuckyMoneyMyRecordUI$6(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.kVL = luckyMoneyMyRecordUI;
    }

    public final void onClick(View view) {
        if (bi.oW(this.kVL.kRo)) {
            x.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
        } else {
            e.l(this.kVL, this.kVL.kRo, true);
        }
    }
}
