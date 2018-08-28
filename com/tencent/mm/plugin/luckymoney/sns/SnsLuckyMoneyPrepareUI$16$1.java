package com.tencent.mm.plugin.luckymoney.sns;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.16;
import com.tencent.mm.sdk.platformtools.x;

class SnsLuckyMoneyPrepareUI$16$1 implements OnCancelListener {
    final /* synthetic */ 16 kTC;

    SnsLuckyMoneyPrepareUI$16$1(16 16) {
        this.kTC = 16;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.kTC.kTy.eXG != null && this.kTC.kTy.eXG.isShowing()) {
            this.kTC.kTy.eXG.hide();
        }
        if (SnsLuckyMoneyPrepareUI.g(this.kTC.kTy).getVisibility() == 8 || SnsLuckyMoneyPrepareUI.h(this.kTC.kTy).getVisibility() == 4) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
            this.kTC.kTy.finish();
        }
        this.kTC.kTy.kUg.baT();
    }
}
