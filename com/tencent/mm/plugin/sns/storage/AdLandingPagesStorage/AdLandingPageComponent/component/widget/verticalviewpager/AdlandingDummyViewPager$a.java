package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.support.v4.view.ViewPager.e;

class AdlandingDummyViewPager$a implements e {
    final /* synthetic */ AdlandingDummyViewPager nHb;

    private AdlandingDummyViewPager$a(AdlandingDummyViewPager adlandingDummyViewPager) {
        this.nHb = adlandingDummyViewPager;
    }

    /* synthetic */ AdlandingDummyViewPager$a(AdlandingDummyViewPager adlandingDummyViewPager, byte b) {
        this(adlandingDummyViewPager);
    }

    public final void a(int i, float f, int i2) {
        for (e a : AdlandingDummyViewPager.a(this.nHb)) {
            a.a(i, f, i2);
        }
    }

    public final void O(int i) {
        for (e O : AdlandingDummyViewPager.a(this.nHb)) {
            O.O(i);
        }
    }

    public final void N(int i) {
        if (i == 0) {
            this.nHb.nHc = this.nHb.getScrollX();
        }
        for (e N : AdlandingDummyViewPager.a(this.nHb)) {
            N.N(i);
        }
    }
}
