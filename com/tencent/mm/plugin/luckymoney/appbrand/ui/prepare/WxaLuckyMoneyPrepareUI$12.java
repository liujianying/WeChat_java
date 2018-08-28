package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class WxaLuckyMoneyPrepareUI$12 implements OnTouchListener {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$12(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI) {
        this.kMq = wxaLuckyMoneyPrepareUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kMq.Wq();
            this.kMq.YC();
        }
        return false;
    }
}
