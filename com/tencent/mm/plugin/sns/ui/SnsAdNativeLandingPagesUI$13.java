package com.tencent.mm.plugin.sns.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;

class SnsAdNativeLandingPagesUI$13 extends h {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$13(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void a(int i, float f, int i2) {
        super.a(i, f, i2);
        b g = SnsAdNativeLandingPagesUI.g(this.nSR);
        if (g.nHl != null) {
            g.nHl.bAn();
        }
        if (this.nSR.mController.tmG == 1) {
            this.nSR.YC();
        }
    }

    public final void N(int i) {
        super.N(i);
        SnsAdNativeLandingPagesUI.g(this.nSR).nHs = i;
        Fragment fragment;
        if (i == 1) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.nSR.nRW.size()) {
                    fragment = (Fragment) SnsAdNativeLandingPagesUI.h(this.nSR).get(Integer.valueOf(((c) this.nSR.nRW.get(i3)).id));
                    if (fragment != null) {
                        ((b) fragment).bAv();
                    }
                    i2 = i3 + 1;
                } else {
                    ad.ef(this.nSR.mController.tml);
                    return;
                }
            }
        } else if (i == 0) {
            fragment = (Fragment) SnsAdNativeLandingPagesUI.h(this.nSR).get(Integer.valueOf(((c) this.nSR.nRW.get(SnsAdNativeLandingPagesUI.a(this.nSR).getCurrentItem())).id));
            if (fragment != null) {
                ((b) fragment).bAw();
            }
        }
    }

    public final void O(int i) {
        super.O(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.nSR.nRW.size()) {
                Fragment fragment = (Fragment) SnsAdNativeLandingPagesUI.h(this.nSR).get(Integer.valueOf(((c) this.nSR.nRW.get(i3)).id));
                if (fragment != null) {
                    if (i3 == i) {
                        ((b) fragment).bAw();
                    } else {
                        ((b) fragment).bAv();
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
