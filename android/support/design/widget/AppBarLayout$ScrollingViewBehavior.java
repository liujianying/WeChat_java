package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a$i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public final /* bridge */ /* synthetic */ int T() {
        return super.T();
    }

    public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        return super.a(coordinatorLayout, view, i);
    }

    public final /* bridge */ /* synthetic */ boolean p(int i) {
        return super.p(i);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$i.ScrollingViewBehavior_Params);
        this.gb = obtainStyledAttributes.getDimensionPixelSize(a$i.ScrollingViewBehavior_Params_behavior_overlapTop, 0);
        obtainStyledAttributes.recycle();
    }

    public final boolean d(View view) {
        return view instanceof AppBarLayout;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Behavior behavior = ((d) view2.getLayoutParams()).eO;
        if (behavior instanceof AppBarLayout.Behavior) {
            int bottom = view2.getBottom() - view.getTop();
            z.j(view, ((AppBarLayout.Behavior.a((AppBarLayout.Behavior) behavior) + bottom) + this.ga) - o(view2));
        }
        return false;
    }

    final float e(View view) {
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int b = AppBarLayout.b(appBarLayout);
            Behavior behavior = ((d) appBarLayout.getLayoutParams()).eO;
            int R = behavior instanceof AppBarLayout.Behavior ? ((AppBarLayout.Behavior) behavior).R() : 0;
            if (b != 0 && totalScrollRange + R <= b) {
                return 0.0f;
            }
            totalScrollRange -= b;
            if (totalScrollRange != 0) {
                return (((float) R) / ((float) totalScrollRange)) + 1.0f;
            }
        }
        return 0.0f;
    }

    final View e(List<View> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = (View) list.get(i);
            if (view instanceof AppBarLayout) {
                return view;
            }
        }
        return null;
    }

    final int f(View view) {
        if (view instanceof AppBarLayout) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }
        return super.f(view);
    }
}
