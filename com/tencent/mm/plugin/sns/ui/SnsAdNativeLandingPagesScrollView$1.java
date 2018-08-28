package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesScrollView$1 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesScrollView nRV;

    SnsAdNativeLandingPagesScrollView$1(SnsAdNativeLandingPagesScrollView snsAdNativeLandingPagesScrollView) {
        this.nRV = snsAdNativeLandingPagesScrollView;
    }

    public final void run() {
        int scrollY = this.nRV.getScrollY();
        x.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[]{Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.nRV)), Integer.valueOf(scrollY)});
        if (scrollY != SnsAdNativeLandingPagesScrollView.a(this.nRV)) {
            if (SnsAdNativeLandingPagesScrollView.b(this.nRV) != null) {
                SnsAdNativeLandingPagesScrollView.b(this.nRV);
                SnsAdNativeLandingPagesScrollView.c(this.nRV);
            }
            SnsAdNativeLandingPagesScrollView.a(this.nRV, System.currentTimeMillis());
        }
        if (SnsAdNativeLandingPagesScrollView.a(this.nRV) - scrollY == 0) {
            if (SnsAdNativeLandingPagesScrollView.b(this.nRV) != null) {
                SnsAdNativeLandingPagesScrollView.b(this.nRV);
                SnsAdNativeLandingPagesScrollView.a(this.nRV);
                SnsAdNativeLandingPagesScrollView.c(this.nRV);
            }
            SnsAdNativeLandingPagesScrollView.a(this.nRV, SnsAdNativeLandingPagesScrollView.a(this.nRV));
        }
        SnsAdNativeLandingPagesScrollView.b(this.nRV, this.nRV.getScrollY());
        x.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[]{Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.nRV)), Integer.valueOf(scrollY)});
        this.nRV.postDelayed(SnsAdNativeLandingPagesScrollView.d(this.nRV), (long) SnsAdNativeLandingPagesScrollView.e(this.nRV));
    }
}
