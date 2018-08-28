package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyReceiveUI$2 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyReceiveUI kXr;

    LuckyMoneyReceiveUI$2(LuckyMoneyReceiveUI luckyMoneyReceiveUI) {
        this.kXr = luckyMoneyReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyReceiveUI.a(this.kXr) != null && LuckyMoneyReceiveUI.a(this.kXr).isShowing()) {
            LuckyMoneyReceiveUI.a(this.kXr).dismiss();
        }
        this.kXr.kUg.baT();
        if (LuckyMoneyReceiveUI.b(this.kXr).getVisibility() == 8 || LuckyMoneyReceiveUI.c(this.kXr).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyReceiveUI", "user cancel & finish");
            this.kXr.finish();
        }
    }
}
