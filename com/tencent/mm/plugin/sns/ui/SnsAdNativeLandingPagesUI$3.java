package com.tencent.mm.plugin.sns.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$3 implements b {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$3(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void onAnimationStart() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim start, isFirstAnimStart %s", new Object[]{Boolean.valueOf(SnsAdNativeLandingPagesUI.E(this.nSR))});
        if (SnsAdNativeLandingPagesUI.E(this.nSR)) {
            SnsAdNativeLandingPagesUI.F(this.nSR);
            long currentTimeMillis = System.currentTimeMillis() - SnsAdNativeLandingPagesUI.G(this.nSR);
            h.mEJ.h(14830, new Object[]{Long.valueOf(SnsAdNativeLandingPagesUI.G(this.nSR)), Long.valueOf(currentTimeMillis)});
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "launch time %d", new Object[]{Long.valueOf(currentTimeMillis)});
        }
    }

    public final void onAnimationEnd() {
        int i = 0;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim end");
        if (SnsAdNativeLandingPagesUI.H(this.nSR)) {
            SnsAdNativeLandingPagesUI.I(this.nSR);
            SnsAdNativeLandingPagesUI.n(this.nSR);
        }
        SnsAdNativeLandingPagesUI.J(this.nSR).setVisibility(0);
        if (SnsAdNativeLandingPagesUI.K(this.nSR)) {
            SnsAdNativeLandingPagesUI.D(this.nSR).setVisibility(0);
        }
        ImageView L = SnsAdNativeLandingPagesUI.L(this.nSR);
        if (!SnsAdNativeLandingPagesUI.B(this.nSR)) {
            i = 4;
        }
        L.setVisibility(i);
        this.nSR.setRequestedOrientation(1);
        SnsAdNativeLandingPagesUI.bCS();
        SnsAdNativeLandingPagesUI.M(this.nSR);
    }
}
