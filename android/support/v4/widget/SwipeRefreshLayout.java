package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements p, r {
    private static final String BD = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] vV = new int[]{16842766};
    private a BE;
    private boolean BF = false;
    private float BG = -1.0f;
    private float BH;
    private final q BI;
    private final int[] BJ = new int[2];
    private final int[] BK = new int[2];
    private boolean BL;
    private int BM;
    private int BN;
    private boolean BO = false;
    private float BP;
    private boolean BQ;
    private boolean BR;
    private final DecelerateInterpolator BS;
    private b BT;
    private int BU = -1;
    protected int BV;
    private float BW;
    protected int BX;
    private l BY;
    private Animation BZ;
    private Animation Ca;
    private Animation Cb;
    private Animation Cc;
    private Animation Cd;
    private float Ce;
    private boolean Cf;
    private int Cg;
    private int Ch;
    private boolean Ci;
    private AnimationListener Cj = new 1(this);
    private final Animation Ck = new 6(this);
    private final Animation Cl = new 7(this);
    private int cF = -1;
    private final s eM;
    private boolean fU;
    private int fW;
    private View me;
    private float vn;

    private void reset() {
        this.BT.clearAnimation();
        this.BY.stop();
        this.BT.setVisibility(8);
        setColorViewAlpha(255);
        if (this.BQ) {
            setAnimationProgress(0.0f);
        } else {
            l(this.BX - this.BN, true);
        }
        this.BN = this.BT.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int i) {
        this.BT.getBackground().setAlpha(i);
        this.BY.setAlpha(i);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.Cg = i2;
                this.Ch = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.Cg = i2;
                this.Ch = i2;
            }
            this.BT.setImageDrawable(null);
            this.BY.au(i);
            this.BT.setImageDrawable(this.BY);
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fW = ViewConfiguration.get(context).getScaledTouchSlop();
        this.BM = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.BS = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vV);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.Cg = (int) (displayMetrics.density * 40.0f);
        this.Ch = (int) (displayMetrics.density * 40.0f);
        this.BT = new b(getContext());
        this.BY = new l(getContext(), this);
        this.BY.setBackgroundColor(-328966);
        this.BT.setImageDrawable(this.BY);
        this.BT.setVisibility(8);
        addView(this.BT);
        z.c(this);
        this.Ce = displayMetrics.density * 64.0f;
        this.BG = this.Ce;
        this.eM = new s(this);
        this.BI = new q(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.BU < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.BU;
        }
        if (i2 >= this.BU) {
            return i2 + 1;
        }
        return i2;
    }

    public void setOnRefreshListener(a aVar) {
        this.BE = aVar;
    }

    private static boolean cU() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.BF == z) {
            d(z, false);
            return;
        }
        int i;
        this.BF = z;
        if (this.Ci) {
            i = (int) this.Ce;
        } else {
            i = (int) (this.Ce + ((float) this.BX));
        }
        l(i - this.BN, true);
        this.Cf = false;
        AnimationListener animationListener = this.Cj;
        this.BT.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.BY.setAlpha(255);
        }
        this.BZ = new 2(this);
        this.BZ.setDuration((long) this.BM);
        if (animationListener != null) {
            this.BT.yF = animationListener;
        }
        this.BT.clearAnimation();
        this.BT.startAnimation(this.BZ);
    }

    private void setAnimationProgress(float f) {
        if (cU()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        z.e(this.BT, f);
        z.f(this.BT, f);
    }

    private void d(boolean z, boolean z2) {
        if (this.BF != z) {
            this.Cf = z2;
            cV();
            this.BF = z;
            if (this.BF) {
                int i = this.BN;
                AnimationListener animationListener = this.Cj;
                this.BV = i;
                this.Ck.reset();
                this.Ck.setDuration(200);
                this.Ck.setInterpolator(this.BS);
                if (animationListener != null) {
                    this.BT.yF = animationListener;
                }
                this.BT.clearAnimation();
                this.BT.startAnimation(this.Ck);
                return;
            }
            a(this.Cj);
        }
    }

    private void a(AnimationListener animationListener) {
        this.Ca = new 3(this);
        this.Ca.setDuration(150);
        this.BT.yF = animationListener;
        this.BT.clearAnimation();
        this.BT.startAnimation(this.Ca);
    }

    private Animation v(int i, int i2) {
        if (this.BQ && cU()) {
            return null;
        }
        4 4 = new 4(this, i, i2);
        4.setDuration(300);
        this.BT.yF = null;
        this.BT.clearAnimation();
        this.BT.startAnimation(4);
        return 4;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.BT.setBackgroundColor(i);
        this.BY.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        cV();
        l lVar = this.BY;
        lVar.Ac.setColors(iArr);
        lVar.Ac.av(0);
    }

    private void cV() {
        if (this.me == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.BT)) {
                    i++;
                } else {
                    this.me = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.BG = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.me == null) {
                cV();
            }
            if (this.me != null) {
                View view = this.me;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.BT.getMeasuredWidth();
                this.BT.layout((measuredWidth / 2) - (measuredHeight / 2), this.BN, (measuredWidth / 2) + (measuredHeight / 2), this.BN + this.BT.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.me == null) {
            cV();
        }
        if (this.me != null) {
            int i3;
            this.me.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.BT.measure(MeasureSpec.makeMeasureSpec(this.Cg, 1073741824), MeasureSpec.makeMeasureSpec(this.Ch, 1073741824));
            if (!(this.Ci || this.BO)) {
                this.BO = true;
                i3 = -this.BT.getMeasuredHeight();
                this.BX = i3;
                this.BN = i3;
            }
            this.BU = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.BT) {
                    this.BU = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.BT != null ? this.BT.getMeasuredHeight() : 0;
    }

    private boolean cW() {
        if (VERSION.SDK_INT >= 14) {
            return z.h(this.me, -1);
        }
        if (!(this.me instanceof AbsListView)) {
            return z.h(this.me, -1) || this.me.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.me;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        cV();
        int d = o.d(motionEvent);
        if (this.BR && d == 0) {
            this.BR = false;
        }
        if (!isEnabled() || this.BR || cW() || this.BF || this.BL) {
            return false;
        }
        float g;
        switch (d) {
            case 0:
                l(this.BX - this.BT.getTop(), true);
                this.cF = o.c(motionEvent, 0);
                this.fU = false;
                g = g(motionEvent, this.cF);
                if (g != -1.0f) {
                    this.BP = g;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.fU = false;
                this.cF = -1;
                break;
            case 2:
                if (this.cF == -1) {
                    return false;
                }
                g = g(motionEvent, this.cF);
                if (g != -1.0f) {
                    if (g - this.BP > ((float) this.fW) && !this.fU) {
                        this.vn = this.BP + ((float) this.fW);
                        this.fU = true;
                        this.BY.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return this.fU;
    }

    private static float g(MotionEvent motionEvent, int i) {
        int b = o.b(motionEvent, i);
        if (b < 0) {
            return -1.0f;
        }
        return o.e(motionEvent, b);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.me instanceof AbsListView)) {
            return;
        }
        if (this.me == null || z.ag(this.me)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.BR || this.BF || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.eM.uX = i;
        startNestedScroll(i & 2);
        this.BH = 0.0f;
        this.BL = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.BH > 0.0f) {
            if (((float) i2) > this.BH) {
                iArr[1] = i2 - ((int) this.BH);
                this.BH = 0.0f;
            } else {
                this.BH -= (float) i2;
                iArr[1] = i2;
            }
            H(this.BH);
        }
        if (this.Ci && i2 > 0 && this.BH == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.BT.setVisibility(8);
        }
        int[] iArr2 = this.BJ;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.eM.uX;
    }

    public void onStopNestedScroll(View view) {
        this.eM.uX = 0;
        this.BL = false;
        if (this.BH > 0.0f) {
            I(this.BH);
            this.BH = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.BK);
        int i5 = this.BK[1] + i4;
        if (i5 < 0 && !cW()) {
            this.BH = ((float) Math.abs(i5)) + this.BH;
            H(this.BH);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.BI.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.BI.uU;
    }

    public boolean startNestedScroll(int i) {
        return this.BI.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.BI.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.BI.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.BI.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.BI.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.BI.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.BI.dispatchNestedPreFling(f, f2);
    }

    private static boolean f(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void H(float f) {
        this.BY.A(true);
        float min = Math.min(1.0f, Math.abs(f / this.BG));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.BG;
        float f2 = this.Ci ? this.Ce - ((float) this.BX) : this.Ce;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.BX;
        if (this.BT.getVisibility() != 0) {
            this.BT.setVisibility(0);
        }
        if (!this.BQ) {
            z.e(this.BT, 1.0f);
            z.f(this.BT, 1.0f);
        }
        if (this.BQ) {
            setAnimationProgress(Math.min(1.0f, f / this.BG));
        }
        if (f < this.BG) {
            if (this.BY.getAlpha() > 76 && !f(this.Cb)) {
                this.Cb = v(this.BY.getAlpha(), 76);
            }
        } else if (this.BY.getAlpha() < 255 && !f(this.Cc)) {
            this.Cc = v(this.BY.getAlpha(), 255);
        }
        this.BY.C(Math.min(0.8f, max * 0.8f));
        this.BY.B(Math.min(1.0f, max));
        this.BY.Ac.setRotation(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        l(i - this.BN, true);
    }

    private void I(float f) {
        if (f > this.BG) {
            d(true, true);
            return;
        }
        this.BF = false;
        this.BY.C(0.0f);
        AnimationListener animationListener = null;
        if (!this.BQ) {
            animationListener = new 5(this);
        }
        int i = this.BN;
        if (this.BQ) {
            this.BV = i;
            if (cU()) {
                this.BW = (float) this.BY.getAlpha();
            } else {
                this.BW = z.V(this.BT);
            }
            this.Cd = new 8(this);
            this.Cd.setDuration(150);
            if (animationListener != null) {
                this.BT.yF = animationListener;
            }
            this.BT.clearAnimation();
            this.BT.startAnimation(this.Cd);
        } else {
            this.BV = i;
            this.Cl.reset();
            this.Cl.setDuration(200);
            this.Cl.setInterpolator(this.BS);
            if (animationListener != null) {
                this.BT.yF = animationListener;
            }
            this.BT.clearAnimation();
            this.BT.startAnimation(this.Cl);
        }
        this.BY.A(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (this.BR && d == 0) {
            this.BR = false;
        }
        if (!isEnabled() || this.BR || cW() || this.BL) {
            return false;
        }
        float e;
        switch (d) {
            case 0:
                this.cF = o.c(motionEvent, 0);
                this.fU = false;
                break;
            case 1:
                d = o.b(motionEvent, this.cF);
                if (d < 0) {
                    return false;
                }
                e = (o.e(motionEvent, d) - this.vn) * 0.5f;
                this.fU = false;
                I(e);
                this.cF = -1;
                return false;
            case 2:
                d = o.b(motionEvent, this.cF);
                if (d < 0) {
                    return false;
                }
                e = (o.e(motionEvent, d) - this.vn) * 0.5f;
                if (this.fU) {
                    if (e > 0.0f) {
                        H(e);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                d = o.e(motionEvent);
                if (d >= 0) {
                    this.cF = o.c(motionEvent, d);
                    break;
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return true;
    }

    private void l(int i, boolean z) {
        this.BT.bringToFront();
        this.BT.offsetTopAndBottom(i);
        this.BN = this.BT.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.cF) {
            this.cF = o.c(motionEvent, e == 0 ? 1 : 0);
        }
    }
}
