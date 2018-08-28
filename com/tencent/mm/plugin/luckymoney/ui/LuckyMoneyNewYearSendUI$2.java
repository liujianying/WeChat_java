package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyNewYearSendUI$2 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyNewYearSendUI kWx;

    LuckyMoneyNewYearSendUI$2(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        this.kWx = luckyMoneyNewYearSendUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyNewYearSendUI.k(this.kWx) != null && LuckyMoneyNewYearSendUI.k(this.kWx).isShowing()) {
            LuckyMoneyNewYearSendUI.k(this.kWx).hide();
        }
        if (LuckyMoneyNewYearSendUI.q(this.kWx).getVisibility() == 8 || LuckyMoneyNewYearSendUI.r(this.kWx).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            this.kWx.finish();
        }
        this.kWx.kUg.baT();
    }
}
