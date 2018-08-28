package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.wxpay.a$e;

class LuckyMoneyWishFooter$3 implements OnTouchListener {
    final /* synthetic */ LuckyMoneyWishFooter kXP;

    LuckyMoneyWishFooter$3(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.kXP = luckyMoneyWishFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        LuckyMoneyWishFooter.f(this.kXP);
        LuckyMoneyWishFooter.g(this.kXP).setVisibility(8);
        LuckyMoneyWishFooter.g(this.kXP).onPause();
        LuckyMoneyWishFooter.e(this.kXP).setImageResource(a$e.chatting_setmode_biaoqing_btn);
        LuckyMoneyWishFooter.a(this.kXP, 0);
        return false;
    }
}
