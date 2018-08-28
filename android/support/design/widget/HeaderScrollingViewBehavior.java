package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.f;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private final Rect ex = new Rect();
    private final Rect ey = new Rect();
    int ga = 0;
    int gb;

    abstract View e(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View e = e(coordinatorLayout.m(view));
            if (e != null) {
                if (z.Z(e) && !z.Z(view)) {
                    z.a(view, true);
                    if (z.Z(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (z.ai(e)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(f(e) + (size - e.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    protected final void d(CoordinatorLayout coordinatorLayout, View view, int i) {
        View e = e(coordinatorLayout.m(view));
        if (e != null) {
            d dVar = (d) view.getLayoutParams();
            Rect rect = this.ex;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, e.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + e.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            Rect rect2 = this.ey;
            int i2 = dVar.gravity;
            if (i2 == 0) {
                i2 = 8388659;
            }
            f.apply(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i2 = o(e);
            view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
            this.ga = rect2.top - e.getBottom();
            return;
        }
        super.d(coordinatorLayout, view, i);
        this.ga = 0;
    }

    float e(View view) {
        return 1.0f;
    }

    final int o(View view) {
        return this.gb == 0 ? 0 : n.e(Math.round(e(view) * ((float) this.gb)), 0, this.gb);
    }

    int f(View view) {
        return view.getMeasuredHeight();
    }
}
