package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

class ViewPager$4 implements t {
    private final Rect bJ = new Rect();
    final /* synthetic */ ViewPager wT;

    ViewPager$4(ViewPager viewPager) {
        this.wT = viewPager;
    }

    public final ap a(View view, ap apVar) {
        ap a = z.a(view, apVar);
        if (a.isConsumed()) {
            return a;
        }
        Rect rect = this.bJ;
        rect.left = a.getSystemWindowInsetLeft();
        rect.top = a.getSystemWindowInsetTop();
        rect.right = a.getSystemWindowInsetRight();
        rect.bottom = a.getSystemWindowInsetBottom();
        int childCount = this.wT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ap b = z.b(this.wT.getChildAt(i), a);
            rect.left = Math.min(b.getSystemWindowInsetLeft(), rect.left);
            rect.top = Math.min(b.getSystemWindowInsetTop(), rect.top);
            rect.right = Math.min(b.getSystemWindowInsetRight(), rect.right);
            rect.bottom = Math.min(b.getSystemWindowInsetBottom(), rect.bottom);
        }
        return a.f(rect.left, rect.top, rect.right, rect.bottom);
    }
}
