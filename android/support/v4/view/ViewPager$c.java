package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewPager$c extends a {
    final /* synthetic */ ViewPager wT;

    ViewPager$c(ViewPager viewPager) {
        this.wT = viewPager;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        f a = a.a(accessibilityEvent);
        a.setScrollable(cm());
        if (accessibilityEvent.getEventType() == 4096 && ViewPager.b(this.wT) != null) {
            a.setItemCount(ViewPager.b(this.wT).getCount());
            a.setFromIndex(ViewPager.c(this.wT));
            a.setToIndex(ViewPager.c(this.wT));
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(ViewPager.class.getName());
        bVar.setScrollable(cm());
        if (this.wT.canScrollHorizontally(1)) {
            bVar.addAction(4096);
        }
        if (this.wT.canScrollHorizontally(-1)) {
            bVar.addAction(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.wT.canScrollHorizontally(1)) {
                    return false;
                }
                this.wT.setCurrentItem(ViewPager.c(this.wT) + 1);
                return true;
            case 8192:
                if (!this.wT.canScrollHorizontally(-1)) {
                    return false;
                }
                this.wT.setCurrentItem(ViewPager.c(this.wT) - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean cm() {
        return ViewPager.b(this.wT) != null && ViewPager.b(this.wT).getCount() > 1;
    }
}
