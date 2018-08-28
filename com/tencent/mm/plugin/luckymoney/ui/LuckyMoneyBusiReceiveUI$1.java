package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyBusiReceiveUI$1 implements OnCancelListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI kUO;

    LuckyMoneyBusiReceiveUI$1(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        this.kUO = luckyMoneyBusiReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (LuckyMoneyBusiReceiveUI.a(this.kUO) != null && LuckyMoneyBusiReceiveUI.a(this.kUO).isShowing()) {
            LuckyMoneyBusiReceiveUI.a(this.kUO).dismiss();
        }
        this.kUO.kUg.baT();
        if (LuckyMoneyBusiReceiveUI.b(this.kUO).getVisibility() == 8 || LuckyMoneyBusiReceiveUI.c(this.kUO).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
            this.kUO.finish();
        }
    }
}
