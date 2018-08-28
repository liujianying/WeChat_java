package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$2 implements OnLayoutChangeListener {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$2(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "adlanding onLayoutChange %d, %d", new Object[]{Integer.valueOf(SnsAdNativeLandingPagesUI.c(this.nSR).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.d(this.nSR))});
        if (SnsAdNativeLandingPagesUI.c(this.nSR).getHeight() >= SnsAdNativeLandingPagesUI.d(this.nSR)) {
            SnsAdNativeLandingPagesUI.c(this.nSR).removeOnLayoutChangeListener(this);
            SnsAdNativeLandingPagesUI.e(this.nSR);
            SnsAdNativeLandingPagesUI.f(this.nSR);
        }
    }
}
