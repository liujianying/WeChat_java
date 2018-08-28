package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final e Bu;
    private int Bf;
    private int Bg;
    private Drawable Bh;
    private Drawable Bi;
    private final int Bj;
    private boolean Bk;
    private View Bl;
    private float Bm;
    private float Bn;
    private int Bo;
    private int Bp;
    private d Bq;
    private final u Br;
    private boolean Bs;
    private final ArrayList<b> Bt;
    private final Rect ea;
    private float vm;
    private float vn;
    private boolean wF;
    private boolean wt;

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] vA = new int[]{16843137};
        boolean Bx;
        boolean By;
        Paint Bz;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vA);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean BA;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.BA = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.BA ? 1 : 0);
        }
    }

    private class b implements Runnable {
        final View Bw;

        b(View view) {
            this.Bw = view;
        }

        public final void run() {
            if (this.Bw.getParent() == SlidingPaneLayout.this) {
                z.a(this.Bw, 0, null);
                SlidingPaneLayout.this.aE(this.Bw);
            }
            SlidingPaneLayout.this.Bt.remove(this);
        }
    }

    public interface d {
    }

    interface e {
        void b(SlidingPaneLayout slidingPaneLayout, View view);
    }

    class a extends android.support.v4.view.a {
        private final Rect ea = new Rect();

        a() {
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
            super.a(view, a);
            Rect rect = this.ea;
            a.getBoundsInParent(rect);
            bVar.setBoundsInParent(rect);
            a.getBoundsInScreen(rect);
            bVar.setBoundsInScreen(rect);
            bVar.setVisibleToUser(a.isVisibleToUser());
            bVar.setPackageName(a.getPackageName());
            bVar.setClassName(a.getClassName());
            bVar.setContentDescription(a.getContentDescription());
            bVar.setEnabled(a.isEnabled());
            bVar.setClickable(a.isClickable());
            bVar.setFocusable(a.isFocusable());
            bVar.setFocused(a.isFocused());
            bVar.setAccessibilityFocused(a.isAccessibilityFocused());
            bVar.setSelected(a.isSelected());
            bVar.setLongClickable(a.isLongClickable());
            bVar.addAction(a.getActions());
            android.support.v4.view.a.b.xr.c(bVar.xs, android.support.v4.view.a.b.xr.D(a.xs));
            a.recycle();
            bVar.setClassName(SlidingPaneLayout.class.getName());
            bVar.setSource(view);
            ViewParent J = z.J(view);
            if (J instanceof View) {
                bVar.setParent((View) J);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!aG(childAt) && childAt.getVisibility() == 0) {
                    z.i(childAt, 1);
                    bVar.addChild(childAt);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (aG(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        private boolean aG(View view) {
            return SlidingPaneLayout.this.aF(view);
        }
    }

    private class c extends android.support.v4.widget.u.a {
        private c() {
        }

        /* synthetic */ c(SlidingPaneLayout slidingPaneLayout, byte b) {
            this();
        }

        public final boolean b(View view, int i) {
            if (SlidingPaneLayout.this.wt) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).Bx;
        }

        public final void t(int i) {
            if (SlidingPaneLayout.this.Br.Cu != 0) {
                return;
            }
            SlidingPaneLayout slidingPaneLayout;
            if (SlidingPaneLayout.this.Bm == 0.0f) {
                SlidingPaneLayout.this.aD(SlidingPaneLayout.this.Bl);
                slidingPaneLayout = SlidingPaneLayout.this;
                SlidingPaneLayout.this.Bl;
                slidingPaneLayout.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.Bs = false;
                return;
            }
            slidingPaneLayout = SlidingPaneLayout.this;
            SlidingPaneLayout.this.Bl;
            slidingPaneLayout.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.Bs = true;
        }

        public final void f(View view, int i) {
            SlidingPaneLayout.this.cR();
        }

        public final void a(View view, int i, int i2) {
            SlidingPaneLayout.a(SlidingPaneLayout.this, i);
            SlidingPaneLayout.this.invalidate();
        }

        public final void a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.cT()) {
                paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.Bm > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.Bo;
                }
                paddingRight = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.Bl.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.Bm > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.Bo;
                }
            }
            SlidingPaneLayout.this.Br.w(paddingRight, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public final int s(View view) {
            return SlidingPaneLayout.this.Bo;
        }

        public final int d(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.Bl.getLayoutParams();
            int width;
            if (SlidingPaneLayout.this.cT()) {
                width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.Bl.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.Bo);
            }
            width = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, width), SlidingPaneLayout.this.Bo + width);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void t(int i, int i2) {
            SlidingPaneLayout.this.Br.n(SlidingPaneLayout.this.Bl, i2);
        }
    }

    static class f implements e {
        f() {
        }

        public void b(SlidingPaneLayout slidingPaneLayout, View view) {
            z.b(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class g extends f {
        private Method BB;
        private Field BC;

        g() {
            try {
                this.BB = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.BC = View.class.getDeclaredField("mRecreateDisplayList");
                this.BC.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.BB == null || this.BC == null) {
                view.invalidate();
                return;
            }
            try {
                this.BC.setBoolean(view, true);
                this.BB.invoke(view, null);
            } catch (Exception e) {
            }
            super.b(slidingPaneLayout, view);
        }
    }

    static class h extends f {
        h() {
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            z.a(view, ((LayoutParams) view.getLayoutParams()).Bz);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            Bu = new h();
        } else if (i >= 16) {
            Bu = new g();
        } else {
            Bu = new f();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bf = -858993460;
        this.wF = true;
        this.ea = new Rect();
        this.Bt = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.Bj = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        z.a((View) this, new a());
        z.i(this, 1);
        this.Br = u.a((ViewGroup) this, 0.5f, new c(this, (byte) 0));
        this.Br.CE = f * 400.0f;
    }

    public void setParallaxDistance(int i) {
        this.Bp = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.Bp;
    }

    public void setSliderFadeColor(int i) {
        this.Bf = i;
    }

    public int getSliderFadeColor() {
        return this.Bf;
    }

    public void setCoveredFadeColor(int i) {
        this.Bg = i;
    }

    public int getCoveredFadeColor() {
        return this.Bg;
    }

    public void setPanelSlideListener(d dVar) {
        this.Bq = dVar;
    }

    final void aD(View view) {
        int left;
        int right;
        int bottom;
        int i;
        int childCount;
        int i2;
        boolean cT = cT();
        int width = cT ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = cT ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null) {
            Object obj;
            if (z.K(view)) {
                obj = 1;
            } else {
                if (VERSION.SDK_INT < 18) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        obj = background.getOpacity() == -1 ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                left = view.getLeft();
                right = view.getRight();
                int top = view.getTop();
                bottom = view.getBottom();
                i = top;
                childCount = getChildCount();
                i2 = 0;
                while (i2 < childCount) {
                    View childAt = getChildAt(i2);
                    if (childAt != view) {
                        if (cT) {
                            top = paddingLeft;
                        } else {
                            top = width;
                        }
                        int max = Math.max(top, childAt.getLeft());
                        int max2 = Math.max(paddingTop, childAt.getTop());
                        if (cT) {
                            top = width;
                        } else {
                            top = paddingLeft;
                        }
                        top = Math.min(top, childAt.getRight());
                        int min = Math.min(height, childAt.getBottom());
                        if (max < left || max2 < i || top > right || min > bottom) {
                            top = 0;
                        } else {
                            top = 4;
                        }
                        childAt.setVisibility(top);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
        bottom = 0;
        i = 0;
        right = 0;
        left = 0;
        childCount = getChildCount();
        i2 = 0;
        while (i2 < childCount) {
            View childAt2 = getChildAt(i2);
            if (childAt2 != view) {
                if (cT) {
                    top = paddingLeft;
                } else {
                    top = width;
                }
                int max3 = Math.max(top, childAt2.getLeft());
                int max22 = Math.max(paddingTop, childAt2.getTop());
                if (cT) {
                    top = width;
                } else {
                    top = paddingLeft;
                }
                top = Math.min(top, childAt2.getRight());
                int min2 = Math.min(height, childAt2.getBottom());
                if (max3 < left || max22 < i || top > right || min2 > bottom) {
                    top = 0;
                } else {
                    top = 4;
                }
                childAt2.setVisibility(top);
                i2++;
            } else {
                return;
            }
        }
    }

    final void cR() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.wF = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wF = true;
        int size = this.Bt.size();
        for (int i = 0; i < size; i++) {
            ((b) this.Bt.get(i)).run();
        }
        this.Bt.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        LayoutParams layoutParams;
        int makeMeasureSpec;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    size2 = l.CTRL_BYTE;
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                }
            }
            i3 = mode2;
            i4 = size;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i3 = mode2;
                i4 = l.CTRL_BYTE;
            }
            i3 = mode2;
            i4 = size;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        size = 0;
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = (size2 - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                mode2 = (size2 - getPaddingTop()) - getPaddingBottom();
                size2 = mode2;
                size = mode2;
                break;
            default:
                size2 = -1;
                break;
        }
        float f = 0.0f;
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.Bl = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size;
        while (i5 < childCount) {
            float f2;
            View childAt = getChildAt(i5);
            layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.By = false;
                mode2 = i6;
                f2 = f;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f2 = layoutParams.weight + f;
                    if (layoutParams.width == 0) {
                        mode2 = i6;
                    }
                } else {
                    f2 = f;
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                } else {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, makeMeasureSpec);
                mode = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && makeMeasureSpec > i7) {
                    i7 = Math.min(makeMeasureSpec, size2);
                }
                makeMeasureSpec = i6 - mode;
                boolean z2 = makeMeasureSpec < 0;
                layoutParams.Bx = z2;
                z2 |= z;
                if (layoutParams.Bx) {
                    this.Bl = childAt;
                }
                mode2 = makeMeasureSpec;
                z = z2;
            }
            i5++;
            i6 = mode2;
            f = f2;
        }
        if (z || f > 0.0f) {
            int i8 = paddingLeft - this.Bj;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.Bl) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    size = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    size = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    size = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                } else {
                                    size = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    mode2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                    if (makeMeasureSpec != mode2) {
                                        childAt2.measure(i5, size);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.weight * ((float) Math.max(0, i6))) / f)) + makeMeasureSpec, 1073741824), size);
                                }
                            }
                        } else if (layoutParams.width < 0 && (makeMeasureSpec > i8 || layoutParams.weight > 0.0f)) {
                            if (obj == null) {
                                mode2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                            } else {
                                mode2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), mode2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.Bk = z;
        if (this.Br.Cu != 0 && !z) {
            this.Br.abort();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean cT = cT();
        if (cT) {
            this.Br.CG = 2;
        } else {
            this.Br.CG = 1;
        }
        int i6 = i3 - i;
        int paddingRight = cT ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = cT ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.wF) {
            float f = (this.Bk && this.Bs) ? 1.0f : 0.0f;
            this.Bm = f;
        }
        int i7 = 0;
        int i8 = paddingRight;
        int i9 = paddingRight;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.Bx) {
                    int min = (Math.min(i8, (i6 - paddingLeft) - this.Bj) - i9) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.Bo = min;
                    paddingRight = cT ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.By = ((i9 + paddingRight) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.Bm);
                    i10 = i9 + (paddingRight + i5);
                    this.Bm = ((float) i5) / ((float) this.Bo);
                } else {
                    if (!this.Bk || this.Bp == 0) {
                        i5 = 0;
                    } else {
                        i5 = (int) ((1.0f - this.Bm) * ((float) this.Bp));
                    }
                    i11 = i5;
                    i10 = i8;
                }
                if (cT) {
                    paddingRight = (i6 - i10) + i11;
                    i5 = paddingRight - measuredWidth;
                } else {
                    i5 = i10 - i11;
                    paddingRight = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, paddingRight, childAt.getMeasuredHeight() + paddingTop);
                i5 = childAt.getWidth() + i8;
                paddingRight = i10;
            } else {
                i5 = i8;
                paddingRight = i9;
            }
            i7++;
            i8 = i5;
            i9 = paddingRight;
        }
        if (this.wF) {
            if (this.Bk) {
                if (this.Bp != 0) {
                    G(this.Bm);
                }
                if (((LayoutParams) this.Bl.getLayoutParams()).By) {
                    a(this.Bl, this.Bm, this.Bf);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    a(getChildAt(i5), 0.0f, this.Bf);
                }
            }
            aD(this.Bl);
        }
        this.wF = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.wF = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.Bk) {
            this.Bs = view == this.Bl;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.o.d(r7);
        r0 = r6.Bk;
        if (r0 != 0) goto L_0x002b;
    L_0x000a:
        if (r3 != 0) goto L_0x002b;
    L_0x000c:
        r0 = r6.getChildCount();
        if (r0 <= r1) goto L_0x002b;
    L_0x0012:
        r0 = r6.getChildAt(r1);
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r0 = android.support.v4.widget.u.e(r0, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r6.Bs = r0;
    L_0x002b:
        r0 = r6.Bk;
        if (r0 == 0) goto L_0x0035;
    L_0x002f:
        r0 = r6.wt;
        if (r0 == 0) goto L_0x0041;
    L_0x0033:
        if (r3 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r6.Br;
        r0.cancel();
        r2 = super.onInterceptTouchEvent(r7);
    L_0x003e:
        return r2;
    L_0x003f:
        r0 = r2;
        goto L_0x0029;
    L_0x0041:
        r0 = 3;
        if (r3 == r0) goto L_0x0046;
    L_0x0044:
        if (r3 != r1) goto L_0x004c;
    L_0x0046:
        r0 = r6.Br;
        r0.cancel();
        goto L_0x003e;
    L_0x004c:
        switch(r3) {
            case 0: goto L_0x005c;
            case 1: goto L_0x004f;
            case 2: goto L_0x007e;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r2;
    L_0x0050:
        r3 = r6.Br;
        r3 = r3.j(r7);
        if (r3 != 0) goto L_0x005a;
    L_0x0058:
        if (r0 == 0) goto L_0x003e;
    L_0x005a:
        r2 = r1;
        goto L_0x003e;
    L_0x005c:
        r6.wt = r2;
        r0 = r7.getX();
        r3 = r7.getY();
        r6.vm = r0;
        r6.vn = r3;
        r4 = r6.Bl;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = android.support.v4.widget.u.e(r4, r0, r3);
        if (r0 == 0) goto L_0x004f;
    L_0x0074:
        r0 = r6.Bl;
        r0 = r6.aF(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x007c:
        r0 = r1;
        goto L_0x0050;
    L_0x007e:
        r0 = r7.getX();
        r3 = r7.getY();
        r4 = r6.vm;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r6.vn;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r6.Br;
        r4 = r4.fW;
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004f;
    L_0x009d:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004f;
    L_0x00a1:
        r0 = r6.Br;
        r0.cancel();
        r6.wt = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.Bk) {
            return super.onTouchEvent(motionEvent);
        }
        this.Br.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.vm = x;
                this.vn = y;
                break;
            case 1:
                if (aF(this.Bl)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.vm;
                    float f2 = y - this.vn;
                    int i = this.Br.fW;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && u.e(this.Bl, (int) x, (int) y)) {
                        cS();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean cS() {
        if (!this.wF && !F(0.0f)) {
            return false;
        }
        this.Bs = false;
        return true;
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.Bz == null) {
                layoutParams.Bz = new Paint();
            }
            layoutParams.Bz.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (z.H(view) != 2) {
                z.a(view, 2, layoutParams.Bz);
            }
            aE(view);
        } else if (z.H(view) != 0) {
            if (layoutParams.Bz != null) {
                layoutParams.Bz.setColorFilter(null);
            }
            Runnable bVar = new b(view);
            this.Bt.add(bVar);
            z.a((View) this, bVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.Bk || layoutParams.Bx || this.Bl == null)) {
            canvas.getClipBounds(this.ea);
            if (cT()) {
                this.ea.left = Math.max(this.ea.left, this.Bl.getRight());
            } else {
                this.ea.right = Math.min(this.ea.right, this.Bl.getLeft());
            }
            canvas.clipRect(this.ea);
        }
        if (VERSION.SDK_INT < 11) {
            if (layoutParams.By && this.Bm > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.Bz);
                    z = false;
                    canvas.restoreToCount(save);
                    return z;
                }
                new StringBuilder("drawChild: child view ").append(view).append(" returned null drawing cache");
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    private void aE(View view) {
        Bu.b(this, view);
    }

    private boolean F(float f) {
        if (!this.Bk) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.Bl.getLayoutParams();
        if (cT()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.Bo) * f)) + ((float) this.Bl.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.Bo) * f));
        }
        if (!this.Br.d(this.Bl, width, this.Bl.getTop())) {
            return false;
        }
        cR();
        z.E(this);
        return true;
    }

    public void computeScroll() {
        if (!this.Br.cX()) {
            return;
        }
        if (this.Bk) {
            z.E(this);
        } else {
            this.Br.abort();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.Bh = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.Bi = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (cT()) {
            drawable = this.Bi;
        } else {
            drawable = this.Bh;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (cT()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void G(float f) {
        Object obj;
        int childCount;
        int i;
        boolean cT = cT();
        LayoutParams layoutParams = (LayoutParams) this.Bl.getLayoutParams();
        if (layoutParams.By) {
            if ((cT ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != this.Bl) {
                        int i2 = (int) ((1.0f - this.Bn) * ((float) this.Bp));
                        this.Bn = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.Bp));
                        if (cT) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj != null) {
                            float f2;
                            if (cT) {
                                f2 = this.Bn - 1.0f;
                            } else {
                                f2 = 1.0f - this.Bn;
                            }
                            a(childAt, f2, this.Bg);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            View childAt2 = getChildAt(i);
            if (childAt2 != this.Bl) {
                int i22 = (int) ((1.0f - this.Bn) * ((float) this.Bp));
                this.Bn = f;
                i22 -= (int) ((1.0f - f) * ((float) this.Bp));
                if (cT) {
                    i22 = -i22;
                }
                childAt2.offsetLeftAndRight(i22);
                if (obj != null) {
                    float f22;
                    if (cT) {
                        f22 = this.Bn - 1.0f;
                    } else {
                        f22 = 1.0f - this.Bn;
                    }
                    a(childAt2, f22, this.Bg);
                }
            }
        }
    }

    final boolean aF(View view) {
        if (view == null) {
            return false;
        }
        return this.Bk && ((LayoutParams) view.getLayoutParams()).By && this.Bm > 0.0f;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.Bk ? !this.Bk || this.Bm == 1.0f : this.Bs;
        savedState.BA = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (!savedState.BA) {
                cS();
            } else if (this.wF || F(1.0f)) {
                this.Bs = true;
            }
            this.Bs = savedState.BA;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean cT() {
        return z.I(this) == 1;
    }
}
