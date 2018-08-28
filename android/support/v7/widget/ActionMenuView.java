package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements android.support.v7.view.menu.f.b, m {
    private Context Jn;
    private int KA;
    private int KP;
    ActionMenuPresenter KQ;
    private android.support.v7.view.menu.l.a KR;
    private android.support.v7.view.menu.f.a KS;
    private boolean KT;
    private int KU;
    private int KV;
    private d KW;
    boolean Kr;
    f bq;

    public interface a {
        boolean dA();

        boolean dz();
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean KY;
        @ExportedProperty
        public int KZ;
        @ExportedProperty
        public int La;
        @ExportedProperty
        public boolean Lb;
        @ExportedProperty
        public boolean Lc;
        boolean Ld;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.KY = layoutParams.KY;
        }

        public LayoutParams() {
            super(-2, -2);
            this.KY = false;
        }
    }

    private class b implements android.support.v7.view.menu.l.a {
        private b() {
        }

        /* synthetic */ b(ActionMenuView actionMenuView, byte b) {
            this();
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean d(f fVar) {
            return false;
        }
    }

    private class c implements android.support.v7.view.menu.f.a {
        private c() {
        }

        /* synthetic */ c(ActionMenuView actionMenuView, byte b) {
            this();
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return ActionMenuView.this.KW != null && ActionMenuView.this.KW.onMenuItemClick(menuItem);
        }

        public final void b(f fVar) {
            if (ActionMenuView.this.KS != null) {
                ActionMenuView.this.KS.b(fVar);
            }
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.KA = (int) (56.0f * f);
        this.KV = (int) (f * 4.0f);
        this.Jn = context;
        this.KP = 0;
    }

    public void setPopupTheme(int i) {
        if (this.KP != i) {
            this.KP = i;
            if (i == 0) {
                this.Jn = getContext();
            } else {
                this.Jn = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.KP;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.KQ = actionMenuPresenter;
        this.KQ.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.KQ != null) {
            this.KQ.n(false);
            if (this.KQ.isOverflowMenuShowing()) {
                this.KQ.hideOverflowMenu();
                this.KQ.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.KW = dVar;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.KT;
        this.KT = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.KT) {
            this.KU = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.KT || this.bq == null || size == this.KU)) {
            this.KU = size;
            this.bq.p(true);
        }
        int childCount = getChildCount();
        int i3;
        LayoutParams layoutParams;
        if (!this.KT || childCount <= 0) {
            for (i3 = 0; i3 < childCount; i3++) {
                layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        i3 = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - i3;
        int i5 = i4 / this.KA;
        size = i4 % this.KA;
        if (i5 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        View childAt;
        int i6;
        int d;
        Object obj;
        int i7;
        int i8 = this.KA + (size / i5);
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        i3 = 0;
        Object obj2 = null;
        long j = 0;
        int childCount2 = getChildCount();
        int i12 = 0;
        while (i12 < childCount2) {
            childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i6 = i3 + 1;
                if (z2) {
                    childAt.setPadding(this.KV, 0, this.KV, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.Ld = false;
                layoutParams.La = 0;
                layoutParams.KZ = 0;
                layoutParams.Lb = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                z = z2 && ((ActionMenuItemView) childAt).hasText();
                layoutParams.Lc = z;
                d = d(childAt, i8, layoutParams.KY ? 1 : i5, childMeasureSpec, paddingTop);
                i10 = Math.max(i10, d);
                if (layoutParams.Lb) {
                    i3 = i11 + 1;
                } else {
                    i3 = i11;
                }
                if (layoutParams.KY) {
                    obj = 1;
                } else {
                    obj = obj2;
                }
                i7 = i5 - d;
                int max = Math.max(i9, childAt.getMeasuredHeight());
                if (d == 1) {
                    j = ((long) (1 << i12)) | j;
                    i11 = i3;
                    i9 = max;
                } else {
                    i11 = i3;
                    i9 = max;
                }
            } else {
                obj = obj2;
                i6 = i3;
                i7 = i5;
            }
            i12++;
            obj2 = obj;
            i3 = i6;
            i5 = i7;
        }
        Object obj3 = (obj2 == null || i3 != 2) ? null : 1;
        Object obj4 = null;
        long j2 = j;
        d = i5;
        while (i11 > 0 && d > 0) {
            i6 = Integer.MAX_VALUE;
            j = 0;
            i5 = 0;
            size = 0;
            while (true) {
                int i13 = size;
                if (i13 >= childCount2) {
                    break;
                }
                layoutParams = (LayoutParams) getChildAt(i13).getLayoutParams();
                if (layoutParams.Lb) {
                    if (layoutParams.KZ < i6) {
                        i5 = layoutParams.KZ;
                        j = (long) (1 << i13);
                        size = 1;
                        i6 = i5;
                    } else if (layoutParams.KZ == i6) {
                        j |= (long) (1 << i13);
                        size = i5 + 1;
                    }
                    i13++;
                }
                size = i5;
                i13++;
            }
            j2 |= j;
            if (i5 > d) {
                break;
            }
            i7 = i6 + 1;
            i6 = 0;
            i5 = d;
            while (i6 < childCount2) {
                View childAt2 = getChildAt(i6);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i6)) & j) != 0) {
                    if (obj3 != null && layoutParams.Lc && i5 == 1) {
                        childAt2.setPadding(this.KV + i8, 0, this.KV, 0);
                    }
                    layoutParams.KZ++;
                    layoutParams.Ld = true;
                    size = i5 - 1;
                } else if (layoutParams.KZ == i7) {
                    j2 |= (long) (1 << i6);
                    size = i5;
                } else {
                    size = i5;
                }
                i6++;
                i5 = size;
            }
            obj4 = 1;
            d = i5;
        }
        j = j2;
        obj = (obj2 == null && i3 == 1) ? 1 : null;
        if (d <= 0 || j == 0 || (d >= i3 - 1 && obj == null && i10 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).Lc)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount2 - 1))) & j) == 0 || ((LayoutParams) getChildAt(childCount2 - 1).getLayoutParams()).Lc)) {
                    f = bitCount - 0.5f;
                    i3 = f <= 0.0f ? (int) (((float) (d * i8)) / f) : 0;
                    i5 = 0;
                    obj3 = obj4;
                    while (i5 < childCount2) {
                        if ((((long) (1 << i5)) & j) != 0) {
                            View childAt3 = getChildAt(i5);
                            layoutParams = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams.La = i3;
                                layoutParams.Ld = true;
                                if (i5 == 0 && !layoutParams.Lc) {
                                    layoutParams.leftMargin = (-i3) / 2;
                                }
                                obj = 1;
                            } else if (layoutParams.KY) {
                                layoutParams.La = i3;
                                layoutParams.Ld = true;
                                layoutParams.rightMargin = (-i3) / 2;
                                obj = 1;
                            } else {
                                if (i5 != 0) {
                                    layoutParams.leftMargin = i3 / 2;
                                }
                                if (i5 != childCount2 - 1) {
                                    layoutParams.rightMargin = i3 / 2;
                                }
                            }
                            i5++;
                            obj3 = obj;
                        }
                        obj = obj3;
                        i5++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i5 = 0;
            obj3 = obj4;
            while (i5 < childCount2) {
                if ((((long) (1 << i5)) & j) != 0) {
                    View childAt32 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt32.getLayoutParams();
                    if (childAt32 instanceof ActionMenuItemView) {
                        layoutParams.La = i3;
                        layoutParams.Ld = true;
                        if (i5 == 0 && !layoutParams.Lc) {
                            layoutParams.leftMargin = (-i3) / 2;
                        }
                        obj = 1;
                    } else if (layoutParams.KY) {
                        layoutParams.La = i3;
                        layoutParams.Ld = true;
                        layoutParams.rightMargin = (-i3) / 2;
                        obj = 1;
                    } else {
                        if (i5 != 0) {
                            layoutParams.leftMargin = i3 / 2;
                        }
                        if (i5 != childCount2 - 1) {
                            layoutParams.rightMargin = i3 / 2;
                        }
                    }
                    i5++;
                    obj3 = obj;
                }
                obj = obj3;
                i5++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            size = 0;
            while (true) {
                i3 = size;
                if (i3 >= childCount2) {
                    break;
                }
                childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Ld) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.La + (layoutParams.KZ * i8), 1073741824), childMeasureSpec);
                }
                size = i3 + 1;
            }
        }
        if (mode == 1073741824) {
            i9 = size2;
        }
        setMeasuredDimension(i4, i9);
    }

    static int d(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && i5 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.KY && z) {
            z2 = true;
        }
        layoutParams.Lb = z2;
        layoutParams.KZ = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.KT) {
            LayoutParams layoutParams;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean bv = at.bv(this);
            int i8 = 0;
            while (i8 < childCount) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.KY) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (aK(i8)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (bv) {
                            paddingLeft = layoutParams.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i9 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i9, i5, measuredHeight + i9);
                        paddingLeft = paddingRight - measuredWidth;
                        obj = 1;
                        measuredWidth = i7;
                    } else {
                        paddingLeft = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                        aK(i8);
                        measuredWidth = i7 + 1;
                    }
                } else {
                    paddingLeft = paddingRight;
                    measuredWidth = i7;
                }
                i8++;
                paddingRight = paddingLeft;
                i7 = measuredWidth;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i7 = i6 - (i5 / 2);
                childAt2.layout(paddingRight, i7, measuredWidth + paddingRight, i5 + i7);
                return;
            }
            paddingLeft = i7 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            int i10;
            if (bv) {
                measuredWidth = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || layoutParams.KY) {
                        paddingLeft = measuredWidth;
                    } else {
                        measuredWidth -= layoutParams.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        dividerWidth = childAt3.getMeasuredHeight();
                        i10 = i6 - (dividerWidth / 2);
                        childAt3.layout(measuredWidth - i8, i10, measuredWidth, dividerWidth + i10);
                        paddingLeft = measuredWidth - ((layoutParams.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    measuredWidth = paddingLeft;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams.KY) {
                    paddingLeft = measuredWidth;
                } else {
                    measuredWidth += layoutParams.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    dividerWidth = childAt3.getMeasuredHeight();
                    i10 = i6 - (dividerWidth / 2);
                    childAt3.layout(measuredWidth, i10, measuredWidth + i8, dividerWidth + i10);
                    paddingLeft = ((layoutParams.rightMargin + i8) + paddingRight) + measuredWidth;
                }
                i5++;
                measuredWidth = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.KQ;
        if (actionMenuPresenter.Ko != null) {
            actionMenuPresenter.Ko.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.Kq = true;
        actionMenuPresenter.Kp = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.KQ;
        if (actionMenuPresenter.Ko != null) {
            return actionMenuPresenter.Ko.getDrawable();
        }
        return actionMenuPresenter.Kq ? actionMenuPresenter.Kp : null;
    }

    public void setOverflowReserved(boolean z) {
        this.Kr = z;
    }

    private static LayoutParams en() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    private LayoutParams c(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams c(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return en();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public static LayoutParams eo() {
        LayoutParams en = en();
        en.KY = true;
        return en;
    }

    public final boolean f(h hVar) {
        return this.bq.a((MenuItem) hVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void a(f fVar) {
        this.bq = fVar;
    }

    public Menu getMenu() {
        if (this.bq == null) {
            Context context = getContext();
            this.bq = new f(context);
            this.bq.a(new c(this, (byte) 0));
            this.KQ = new ActionMenuPresenter(context);
            this.KQ.ej();
            this.KQ.bp = this.KR != null ? this.KR : new b(this, (byte) 0);
            this.bq.a(this.KQ, this.Jn);
            this.KQ.a(this);
        }
        return this.bq;
    }

    public final void a(android.support.v7.view.menu.l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        this.KR = aVar;
        this.KS = aVar2;
    }

    public final void dismissPopupMenus() {
        if (this.KQ != null) {
            this.KQ.ek();
        }
    }

    private boolean aK(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = ((a) childAt).dA() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : ((a) childAt2).dz() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.KQ.Kz = z;
    }
}
