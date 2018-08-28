package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.a.d;

class SnsAdNativeLandingPagesUI$18 implements OnClickListener {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$18(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void onClick(View view) {
        d dVar = new d(this.nSR, 1, false);
        dVar.ofp = new 1(this);
        dVar.uJQ = new 2(this);
        dVar.ofq = new 3(this);
        if (SnsAdNativeLandingPagesUI.B(this.nSR)) {
            dVar.qgK = true;
        }
        if (SnsAdNativeLandingPagesUI.C(this.nSR)) {
            dVar.bXO();
            return;
        }
        this.nSR.YC();
        SnsAdNativeLandingPagesUI.D(this.nSR).postDelayed(new 4(this, dVar), 300);
    }
}
