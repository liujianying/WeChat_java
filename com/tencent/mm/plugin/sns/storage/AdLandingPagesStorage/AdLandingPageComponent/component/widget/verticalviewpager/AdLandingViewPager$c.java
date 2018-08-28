package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.map.lib.gl.model.GLIcon;

class AdLandingViewPager$c extends a {
    final /* synthetic */ AdLandingViewPager nGY;

    AdLandingViewPager$c(AdLandingViewPager adLandingViewPager) {
        this.nGY = adLandingViewPager;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(AdLandingViewPager.class.getName());
        f cw = f.cw();
        cw.setScrollable(cm());
        if (accessibilityEvent.getEventType() == GLIcon.LEFT && AdLandingViewPager.b(this.nGY) != null) {
            cw.setItemCount(AdLandingViewPager.b(this.nGY).getCount());
            cw.setFromIndex(AdLandingViewPager.c(this.nGY));
            cw.setToIndex(AdLandingViewPager.c(this.nGY));
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(AdLandingViewPager.class.getName());
        bVar.setScrollable(cm());
        if (this.nGY.canScrollHorizontally(1)) {
            bVar.addAction(GLIcon.LEFT);
        }
        if (this.nGY.canScrollHorizontally(-1)) {
            bVar.addAction(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case GLIcon.LEFT /*4096*/:
                if (!this.nGY.canScrollHorizontally(1)) {
                    return false;
                }
                this.nGY.setCurrentItem(AdLandingViewPager.c(this.nGY) + 1);
                return true;
            case 8192:
                if (!this.nGY.canScrollHorizontally(-1)) {
                    return false;
                }
                this.nGY.setCurrentItem(AdLandingViewPager.c(this.nGY) - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean cm() {
        return AdLandingViewPager.b(this.nGY) != null && AdLandingViewPager.b(this.nGY).getCount() > 1;
    }
}
