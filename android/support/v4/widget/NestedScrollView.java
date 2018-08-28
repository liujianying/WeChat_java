package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.f;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements p, r, w {
    private static final a AP = new a();
    private static final int[] AQ = new int[]{16843130};
    private long AD;
    private i AE;
    private i AF;
    private boolean AG;
    private boolean AH;
    private View AI;
    private boolean AJ;
    private boolean AK;
    private final int[] AL;
    private final int[] AM;
    private int AN;
    private SavedState AO;
    private final s AR;
    private final q AS;
    private float AT;
    private b AU;
    private final Rect bJ;
    private VelocityTracker cE;
    private int cF;
    private q fT;
    private boolean fU;
    private int fV;
    private int fW;
    private int wy;
    private int wz;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int AV;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.AV = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.AV);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.AV + "}";
        }
    }

    public interface b {
        void b(NestedScrollView nestedScrollView);
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.ax(min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.ax(min);
                    return true;
                default:
                    return false;
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    bVar.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bVar.addAction(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        bVar.addAction(4096);
                    }
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setScrollable(nestedScrollView.getScrollRange() > 0);
            f.xX.f(a.xY, nestedScrollView.getScrollX());
            f.xX.g(a.xY, nestedScrollView.getScrollY());
            f.xX.i(a.xY, nestedScrollView.getScrollX());
            f.xX.j(a.xY, nestedScrollView.getScrollRange());
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJ = new Rect();
        this.AG = true;
        this.AH = false;
        this.AI = null;
        this.fU = false;
        this.AK = true;
        this.cF = -1;
        this.AL = new int[2];
        this.AM = new int[2];
        this.fT = q.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.fW = viewConfiguration.getScaledTouchSlop();
        this.wy = viewConfiguration.getScaledMinimumFlingVelocity();
        this.wz = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AQ, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.AR = new s(this);
        this.AS = new q(this);
        setNestedScrollingEnabled(true);
        z.a((View) this, AP);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.AS.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.AS.uU;
    }

    public boolean startNestedScroll(int i) {
        return this.AS.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.AS.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.AS.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.AS.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.AS.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.AS.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.AS.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.AR.uX = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.AR.uX = 0;
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        ay((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.AR.uX;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.AU = bVar;
    }

    public void setFillViewport(boolean z) {
        if (z != this.AJ) {
            this.AJ = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.AK = z;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.AU != null) {
            this.AU.b(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.AJ && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean z;
        this.bJ.setEmpty();
        View childAt = getChildAt(0);
        if (childAt != null) {
            z = getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        } else {
            z = false;
        }
        View childAt2;
        if (z) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(33);
                    }
                    return arrowScroll(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(130);
                    }
                    return arrowScroll(130);
                case 62:
                    int i = keyEvent.isShiftPressed() ? 33 : 130;
                    boolean z2 = i == 130;
                    int height = getHeight();
                    if (z2) {
                        this.bJ.top = getScrollY() + height;
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            childAt2 = getChildAt(childCount - 1);
                            if (this.bJ.top + height > childAt2.getBottom()) {
                                this.bJ.top = childAt2.getBottom() - height;
                            }
                        }
                    } else {
                        this.bJ.top = getScrollY() - height;
                        if (this.bJ.top < 0) {
                            this.bJ.top = 0;
                        }
                    }
                    this.bJ.bottom = height + this.bJ.top;
                    h(i, this.bJ.top, this.bJ.bottom);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            childAt2 = findFocus();
            if (childAt2 == this) {
                childAt2 = null;
            }
            childAt2 = FocusFinder.getInstance().findNextFocus(this, childAt2, 130);
            if (childAt2 == null || childAt2 == this || !childAt2.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private void cN() {
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
    }

    private void cO() {
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            cO();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.fU) {
            return true;
        }
        int y;
        switch (action & 255) {
            case 0:
                boolean z2;
                y = (int) motionEvent.getY();
                action = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z2 = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && action >= childAt.getLeft() && action < childAt.getRight();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.fU = false;
                    cO();
                    break;
                }
                this.fV = y;
                this.cF = o.c(motionEvent, 0);
                if (this.cE == null) {
                    this.cE = VelocityTracker.obtain();
                } else {
                    this.cE.clear();
                }
                this.cE.addMovement(motionEvent);
                this.fT.computeScrollOffset();
                if (this.fT.isFinished()) {
                    z = false;
                }
                this.fU = z;
                startNestedScroll(2);
                break;
                break;
            case 1:
            case 3:
                this.fU = false;
                this.cF = -1;
                cO();
                if (this.fT.i(getScrollX(), getScrollY(), getScrollRange())) {
                    z.E(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.cF;
                if (action != -1) {
                    y = o.b(motionEvent, action);
                    if (y != -1) {
                        action = (int) o.e(motionEvent, y);
                        if (Math.abs(action - this.fV) > this.fW && (getNestedScrollAxes() & 2) == 0) {
                            this.fU = true;
                            this.fV = action;
                            cN();
                            this.cE.addMovement(motionEvent);
                            this.AN = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Invalid pointerId=").append(action).append(" in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        return this.fU;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        cN();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int d = o.d(motionEvent);
        if (d == 0) {
            this.AN = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.AN);
        switch (d) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.fT.isFinished();
                    this.fU = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.fT.isFinished()) {
                        this.fT.abortAnimation();
                    }
                    this.fV = (int) motionEvent.getY();
                    this.cF = o.c(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.fU) {
                    VelocityTracker velocityTracker = this.cE;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.wz);
                    d = (int) y.b(velocityTracker, this.cF);
                    if (Math.abs(d) > this.wy) {
                        ay(-d);
                    } else if (this.fT.i(getScrollX(), getScrollY(), getScrollRange())) {
                        z.E(this);
                    }
                }
                this.cF = -1;
                cP();
                break;
            case 2:
                int b = o.b(motionEvent, this.cF);
                if (b != -1) {
                    int i;
                    int e = (int) o.e(motionEvent, b);
                    d = this.fV - e;
                    if (dispatchNestedPreScroll(0, d, this.AM, this.AL)) {
                        d -= this.AM[1];
                        obtain.offsetLocation(0.0f, (float) this.AL[1]);
                        this.AN += this.AL[1];
                    }
                    if (this.fU || Math.abs(d) <= this.fW) {
                        i = d;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.fU = true;
                        if (d > 0) {
                            i = d - this.fW;
                        } else {
                            i = d + this.fW;
                        }
                    }
                    if (this.fU) {
                        Object obj;
                        this.fV = e - this.AL[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        d = z.B(this);
                        if (d == 0 || (d == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (d(0, i, 0, getScrollY(), scrollRange) && !hasNestedScrollingParent()) {
                            this.cE.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.AL)) {
                            if (obj != null) {
                                cQ();
                                d = scrollY + i;
                                if (d < 0) {
                                    this.AE.s(((float) i) / ((float) getHeight()), o.d(motionEvent, b) / ((float) getWidth()));
                                    if (!this.AF.isFinished()) {
                                        this.AF.cI();
                                    }
                                } else if (d > scrollRange) {
                                    this.AF.s(((float) i) / ((float) getHeight()), 1.0f - (o.d(motionEvent, b) / ((float) getWidth())));
                                    if (!this.AE.isFinished()) {
                                        this.AE.cI();
                                    }
                                }
                                if (!(this.AE == null || (this.AE.isFinished() && this.AF.isFinished()))) {
                                    z.E(this);
                                    break;
                                }
                            }
                        }
                        this.fV -= this.AL[1];
                        obtain.offsetLocation(0.0f, (float) this.AL[1]);
                        this.AN += this.AL[1];
                        break;
                    }
                }
                new StringBuilder("Invalid pointerId=").append(this.cF).append(" in onTouchEvent");
                break;
                break;
            case 3:
                if (this.fU && getChildCount() > 0 && this.fT.i(getScrollX(), getScrollY(), getScrollRange())) {
                    z.E(this);
                }
                this.cF = -1;
                cP();
                break;
            case 5:
                d = o.e(motionEvent);
                this.fV = (int) o.e(motionEvent, d);
                this.cF = o.c(motionEvent, d);
                break;
            case 6:
                h(motionEvent);
                this.fV = (int) o.e(motionEvent, o.b(motionEvent, this.cF));
                break;
        }
        if (this.cE != null) {
            this.cE.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (o.c(motionEvent, action) == this.cF) {
            action = action == 0 ? 1 : 0;
            this.fV = (int) o.e(motionEvent, action);
            this.cF = o.c(motionEvent, action);
            if (this.cE != null) {
                this.cE.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((o.g(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.fU) {
                    return false;
                }
                float f = o.f(motionEvent, 9);
                if (f == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (f * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.AT == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.AT = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.AT;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean d(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        boolean z2;
        z.B(this);
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i7 = i3 + i;
        int i8 = i4 + i2;
        int i9 = i5 + 0;
        if (i7 > 0) {
            z = true;
            i6 = 0;
        } else if (i7 < 0) {
            z = true;
            i6 = 0;
        } else {
            z = false;
            i6 = i7;
        }
        if (i8 > i9) {
            z2 = true;
        } else if (i8 < 0) {
            z2 = true;
            i9 = 0;
        } else {
            z2 = false;
            i9 = i8;
        }
        if (z2) {
            this.fT.i(i6, i9, getScrollRange());
        }
        onOverScrolled(i6, i9, z, z2);
        if (z || z2) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private boolean fullScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.bJ.top = 0;
        this.bJ.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.bJ.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.bJ.top = this.bJ.bottom - height;
            }
        }
        return h(i, this.bJ.top, this.bJ.bottom);
    }

    private boolean h(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        Object obj = i == 33 ? 1 : null;
        List focusables = getFocusables(2);
        View view = null;
        Object obj2 = null;
        int size = focusables.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj3;
            View view2 = (View) focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                obj3 = (i2 >= top || bottom >= i3) ? null : 1;
                if (view != null) {
                    Object obj4 = ((obj == null || top >= view.getTop()) && (obj != null || bottom <= view.getBottom())) ? null : 1;
                    if (obj2 != null) {
                        if (!(obj3 == null || obj4 == null)) {
                            obj3 = obj2;
                        }
                    } else if (obj3 != null) {
                        obj3 = 1;
                    } else if (obj4 != null) {
                        obj3 = obj2;
                    }
                }
                i5++;
                obj2 = obj3;
                view = view2;
            }
            obj3 = obj2;
            view2 = view;
            i5++;
            obj2 = obj3;
            view = view2;
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            aw(obj != null ? i2 - scrollY : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    private boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !c(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            aw(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.bJ);
            offsetDescendantRectToMyCoords(findNextFocus, this.bJ);
            aw(computeScrollDeltaToGetChildRectOnScreen(this.bJ));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && aB(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean aB(View view) {
        return !c(view, 0, getHeight());
    }

    private boolean c(View view, int i, int i2) {
        view.getDrawingRect(this.bJ);
        offsetDescendantRectToMyCoords(view, this.bJ);
        return this.bJ.bottom + i >= getScrollY() && this.bJ.top - i <= getScrollY() + i2;
    }

    private void aw(int i) {
        if (i == 0) {
            return;
        }
        if (this.AK) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.AD > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                max = Math.max(0, Math.min(scrollY + i2, max)) - scrollY;
                q qVar = this.fT;
                qVar.Be.a(qVar.Bd, getScrollX(), scrollY, max);
                z.E(this);
            } else {
                if (!this.fT.isFinished()) {
                    this.fT.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.AD = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void ax(int i) {
        smoothScrollBy(0 - getScrollX(), i - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.fT.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.fT.getCurrX();
            int currY = this.fT.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                int B = z.B(this);
                Object obj = (B == 0 || (B == 1 && scrollRange > 0)) ? 1 : null;
                d(currX - scrollX, currY - scrollY, scrollX, scrollY, scrollRange);
                if (obj != null) {
                    cQ();
                    if (currY <= 0 && scrollY > 0) {
                        this.AE.at((int) this.fT.getCurrVelocity());
                    } else if (currY >= scrollRange && scrollY < scrollRange) {
                        this.AF.at((int) this.fT.getCurrVelocity());
                    }
                }
            }
        }
    }

    private void aC(View view) {
        view.getDrawingRect(this.bJ);
        offsetDescendantRectToMyCoords(view, this.bJ);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.bJ);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.AG) {
            this.AI = view2;
        } else {
            aC(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || aB(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.AG = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.AG = false;
        if (this.AI != null && a(this.AI, this)) {
            aC(this.AI);
        }
        this.AI = null;
        if (!this.AH) {
            if (this.AO != null) {
                scrollTo(getScrollX(), this.AO.AV);
                this.AO = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.AH = true;
    }

    public void onAttachedToWindow() {
        this.AH = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && c(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.bJ);
            offsetDescendantRectToMyCoords(findFocus, this.bJ);
            aw(computeScrollDeltaToGetChildRectOnScreen(this.bJ));
        }
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            q qVar = this.fT;
            qVar.Be.b(qVar.Bd, getScrollX(), getScrollY(), i, Math.max(0, height2 - height), height / 2);
            z.E(this);
        }
    }

    private void ay(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                fling(i);
            }
        }
    }

    private void cP() {
        this.fU = false;
        cO();
        stopNestedScroll();
        if (this.AE != null) {
            this.AE.cI();
            this.AF.cI();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    private void cQ() {
        if (z.B(this) == 2) {
            this.AE = null;
            this.AF = null;
        } else if (this.AE == null) {
            Context context = getContext();
            this.AE = new i(context);
            this.AF = new i(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.AE != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.AE.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.AE.setSize(width, getHeight());
                if (this.AE.draw(canvas)) {
                    z.E(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.AF.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.AF.setSize(width, height);
                if (this.AF.draw(canvas)) {
                    z.E(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int clamp(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.AO = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.AV = getScrollY();
        return savedState;
    }
}
