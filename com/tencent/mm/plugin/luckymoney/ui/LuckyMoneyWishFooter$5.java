package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.b;

class LuckyMoneyWishFooter$5 implements OnClickListener {
    final /* synthetic */ LuckyMoneyWishFooter kXP;
    final /* synthetic */ b kXQ;

    LuckyMoneyWishFooter$5(LuckyMoneyWishFooter luckyMoneyWishFooter, b bVar) {
        this.kXP = luckyMoneyWishFooter;
        this.kXQ = bVar;
    }

    public final void onClick(View view) {
        this.kXQ.Gf(LuckyMoneyWishFooter.a(this.kXP).getText().toString());
        LuckyMoneyWishFooter.a(this.kXP).setText("");
    }
}
