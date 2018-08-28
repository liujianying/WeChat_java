package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyNewYearReceiveUI$3 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI kWg;

    LuckyMoneyNewYearReceiveUI$3(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.kWg = luckyMoneyNewYearReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyNewYearReceiveUI.b(this.kWg) != null && LuckyMoneyNewYearReceiveUI.b(this.kWg).isShowing()) {
            LuckyMoneyNewYearReceiveUI.b(this.kWg).dismiss();
        }
        this.kWg.kUg.baT();
        if (LuckyMoneyNewYearReceiveUI.c(this.kWg).getVisibility() == 8 || LuckyMoneyNewYearReceiveUI.d(this.kWg).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
            this.kWg.finish();
        }
    }
}
