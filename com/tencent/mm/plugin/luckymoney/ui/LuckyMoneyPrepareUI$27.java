package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.ui.a.a.a;

class LuckyMoneyPrepareUI$27 implements OnClickListener {
    final /* synthetic */ SpannableString kMw;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;
    final /* synthetic */ h kXd;
    final /* synthetic */ h kXe;

    LuckyMoneyPrepareUI$27(LuckyMoneyPrepareUI luckyMoneyPrepareUI, SpannableString spannableString, h hVar, h hVar2) {
        this.kWX = luckyMoneyPrepareUI;
        this.kMw = spannableString;
        this.kXd = hVar;
        this.kXe = hVar2;
    }

    public final void onClick(View view) {
        if (!a.cqX().cqW()) {
            return;
        }
        if (LuckyMoneyPrepareUI.e(this.kWX).getText().toString().equals(this.kMw.toString())) {
            this.kXd.onClick(view);
        } else {
            this.kXe.onClick(view);
        }
    }
}
