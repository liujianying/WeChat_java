package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.report.service.h;

class SnsLuckyMoneyPrepareUI$5 implements OnClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;

    SnsLuckyMoneyPrepareUI$5(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.kTy = snsLuckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.kTy)), Integer.valueOf(9)});
        Intent intent = new Intent();
        intent.setClass(this.kTy.mController.tml, LuckyMoneyCanShareListUI.class);
        this.kTy.startActivity(intent);
    }
}
