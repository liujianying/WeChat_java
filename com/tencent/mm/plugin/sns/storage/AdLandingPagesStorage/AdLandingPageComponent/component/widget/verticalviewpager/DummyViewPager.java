package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.h;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b.a;
import java.io.Serializable;

public class DummyViewPager extends AdLandingViewPager implements Serializable {
    protected int nHc;

    public DummyViewPager(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        a aVar = new a();
        if (VERSION.SDK_INT >= 11) {
            if (true != (this.wN != null)) {
                z = true;
            }
            this.wN = aVar;
            setChildrenDrawingOrderEnabledCompat(true);
            this.wP = 1;
            if (z) {
                cf();
            }
        }
        setOnPageChangeListener(new h() {
            public final void N(int i) {
                super.N(i);
                if (i == 0) {
                    DummyViewPager.this.nHc = DummyViewPager.this.getScrollX();
                }
            }
        });
    }

    public int getBaseScrollX() {
        return this.nHc;
    }

    public void setBaseScrollX(int i) {
        this.nHc = i;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
