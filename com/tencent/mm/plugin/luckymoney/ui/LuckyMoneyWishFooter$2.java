package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyWishFooter$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyWishFooter kXP;

    LuckyMoneyWishFooter$2(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.kXP = luckyMoneyWishFooter;
    }

    public final void onClick(View view) {
        this.kXP.setModeClick(true);
        x.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.b(this.kXP));
        if (LuckyMoneyWishFooter.b(this.kXP) == 0) {
            LuckyMoneyWishFooter.c(this.kXP).YC();
            LuckyMoneyWishFooter.a(this.kXP).requestFocus();
            LuckyMoneyWishFooter.d(this.kXP);
            LuckyMoneyWishFooter.e(this.kXP).setImageResource(h.textfield_icon_emoji_pressed);
            LuckyMoneyWishFooter.a(this.kXP, 1);
            LuckyMoneyWishFooter.f(this.kXP);
            return;
        }
        LuckyMoneyWishFooter.f(this.kXP);
        LuckyMoneyWishFooter.a(this.kXP).requestFocus();
        LuckyMoneyWishFooter.g(this.kXP).setVisibility(8);
        LuckyMoneyWishFooter.c(this.kXP).showVKB();
        LuckyMoneyWishFooter.e(this.kXP).setImageResource(h.textfield_icon_emoji_normal);
        LuckyMoneyWishFooter.a(this.kXP, 0);
    }
}
