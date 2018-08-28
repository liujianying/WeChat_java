package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.b;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

@b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int bQ = -1;
    private int bR = -1;
    private int bS = -1;
    boolean bT;
    private float bU;
    private int bV = 0;
    private ap bW;
    final List<a> bX;

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        int co = 1;
        Interpolator cp;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.AppBarLayout_LayoutParams);
            this.co = obtainStyledAttributes.getInt(i.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(i.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
                this.cp = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    static /* synthetic */ ap a(AppBarLayout appBarLayout, ap apVar) {
        ap apVar2 = null;
        if (z.Z(appBarLayout)) {
            apVar2 = apVar;
        }
        if (apVar2 != appBarLayout.bW) {
            appBarLayout.bW = apVar2;
            appBarLayout.Q();
        }
        return apVar;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        t.G(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.AppBarLayout, 0, h.Widget_Design_AppBarLayout);
        this.bU = (float) obtainStyledAttributes.getDimensionPixelSize(i.AppBarLayout_elevation, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(i.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(i.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        aa.u(this);
        this.bX = new ArrayList();
        z.g(this, this.bU);
        z.b(this, new t() {
            public final ap a(View view, ap apVar) {
                return AppBarLayout.a(AppBarLayout.this, apVar);
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Q();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Q();
        this.bT = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).cp != null) {
                this.bT = true;
                return;
            }
        }
    }

    private void Q() {
        this.bQ = -1;
        this.bR = -1;
        this.bS = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        boolean ai = z.ai(this);
        this.bV = (ai ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int getTotalScrollRange() {
        if (this.bQ != -1) {
            return this.bQ;
        }
        int T;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.co;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                T = i - z.T(childAt);
                break;
            }
        }
        T = i;
        T = Math.max(0, T - getTopInset());
        this.bQ = T;
        return T;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    private int getDownNestedPreScrollRange() {
        if (this.bR != -1) {
            return this.bR;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.co;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
                i = i2;
            } else {
                i = (layoutParams.bottomMargin + layoutParams.topMargin) + i2;
                if ((i3 & 8) != 0) {
                    i += z.T(childAt);
                } else if ((i3 & 2) != 0) {
                    i += measuredHeight - z.T(childAt);
                } else {
                    i += measuredHeight;
                }
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.bR = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.bS != -1) {
            return this.bS;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.co;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (z.T(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.bS = i;
        return i;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int T = z.T(this);
        if (T != 0) {
            return topInset + (T * 2);
        }
        T = getChildCount();
        return T > 0 ? topInset + (z.T(getChildAt(T - 1)) * 2) : 0;
    }

    public void setTargetElevation(float f) {
        this.bU = f;
    }

    public float getTargetElevation() {
        return this.bU;
    }

    private int getPendingAction() {
        return this.bV;
    }

    private int getTopInset() {
        return this.bW != null ? this.bW.getSystemWindowInsetTop() : 0;
    }
}
