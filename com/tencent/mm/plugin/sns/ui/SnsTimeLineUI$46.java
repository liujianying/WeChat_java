package com.tencent.mm.plugin.sns.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;

class SnsTimeLineUI$46 implements OnClickListener {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$46(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void onClick(View view) {
        if (SystemClock.elapsedRealtime() - SnsTimeLineUI.K(this.odw) < 300) {
            SnsTimeLineUI.I(this.odw);
        }
        SnsTimeLineUI.c(this.odw, SystemClock.elapsedRealtime());
        af.aRu().removeCallbacks(SnsTimeLineUI.L(this.odw));
        SnsTimeLineUI.L(this.odw).run();
    }
}
