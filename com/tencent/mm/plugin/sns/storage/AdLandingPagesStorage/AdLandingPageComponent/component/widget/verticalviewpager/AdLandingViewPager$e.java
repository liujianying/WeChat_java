package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.database.DataSetObserver;

class AdLandingViewPager$e extends DataSetObserver {
    final /* synthetic */ AdLandingViewPager nGY;

    private AdLandingViewPager$e(AdLandingViewPager adLandingViewPager) {
        this.nGY = adLandingViewPager;
    }

    /* synthetic */ AdLandingViewPager$e(AdLandingViewPager adLandingViewPager, byte b) {
        this(adLandingViewPager);
    }

    public final void onChanged() {
        this.nGY.ce();
    }

    public final void onInvalidated() {
        this.nGY.ce();
    }
}
