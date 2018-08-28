package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.a;

class SnsTimeLineUI$47 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$47(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        SnsTimeLineUI.h(this.odw).kww.setSelection(0);
        a D = SnsTimeLineUI.D(this.odw);
        if (D.odR) {
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.m(D.odw).getLayoutParams();
            layoutParams.y = D.odS;
            SnsTimeLineUI.m(D.odw).setLayoutParams(layoutParams);
            D.odL = D.odT;
            D.odN = D.odU;
        }
        SnsTimeLineUI.D(this.odw).bEj();
        SnsTimeLineUI.k(this.odw).onl.b(SnsTimeLineUI.q(this.odw), SnsTimeLineUI.i(this.odw), SnsTimeLineUI.j(this.odw), SnsTimeLineUI.r(this.odw));
    }
}
