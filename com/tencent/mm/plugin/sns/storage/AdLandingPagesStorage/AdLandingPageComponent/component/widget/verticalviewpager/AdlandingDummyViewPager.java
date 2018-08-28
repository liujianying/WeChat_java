package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;

public class AdlandingDummyViewPager extends DummyViewPager {
    private a nGZ = new a(this, (byte) 0);
    public Set<e> nHa = new HashSet();

    public AdlandingDummyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnPageChangeListener(this.nGZ);
    }
}
