package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.28;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyPrepareUI$28$1 implements OnCancelListener {
    final /* synthetic */ 28 kXf;

    LuckyMoneyPrepareUI$28$1(28 28) {
        this.kXf = 28;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyPrepareUI.m(this.kXf.kWX) != null && LuckyMoneyPrepareUI.m(this.kXf.kWX).isShowing()) {
            LuckyMoneyPrepareUI.m(this.kXf.kWX).dismiss();
        }
        if (LuckyMoneyPrepareUI.n(this.kXf.kWX).getVisibility() == 8 || LuckyMoneyPrepareUI.o(this.kXf.kWX).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
            this.kXf.kWX.finish();
        }
        this.kXf.kWX.kUg.baT();
    }
}
