package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.af;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements h {
    private static final int[] vV = new int[]{16842931};
    static final c zI;
    private static final boolean zd = (VERSION.SDK_INT >= 19);
    private static final boolean ze;
    List<f> bX;
    private boolean eJ;
    private Drawable eK;
    private boolean mInLayout;
    private float vm;
    private float vn;
    private boolean wF;
    CharSequence zA;
    CharSequence zB;
    private Object zC;
    private Drawable zD;
    private Drawable zE;
    private Drawable zF;
    private Drawable zG;
    private final ArrayList<View> zH;
    private final b zf;
    private float zg;
    private int zh;
    private int zi;
    private float zj;
    private Paint zk;
    final u zl;
    final u zm;
    private final g zn;
    private final g zo;
    int zp;
    private int zq;
    private int zr;
    private int zt;
    private int zu;
    private boolean zv;
    boolean zw;
    @Deprecated
    private f zx;
    private Drawable zy;
    private Drawable zz;

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity = 0;
        private float zK;
        private boolean zL;
        private int zM;

        static /* synthetic */ int b(LayoutParams layoutParams, int i) {
            int i2 = layoutParams.zM | i;
            layoutParams.zM = i2;
            return i2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.vV);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int zN = 0;
        int zO;
        int zP;
        int zQ;
        int zR;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.zN = parcel.readInt();
            this.zO = parcel.readInt();
            this.zP = parcel.readInt();
            this.zQ = parcel.readInt();
            this.zR = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.zN);
            parcel.writeInt(this.zO);
            parcel.writeInt(this.zP);
            parcel.writeInt(this.zQ);
            parcel.writeInt(this.zR);
        }
    }

    interface c {
        int I(Object obj);

        Drawable P(Context context);

        void a(View view, Object obj, int i);

        void a(MarginLayoutParams marginLayoutParams, Object obj, int i);

        void aA(View view);
    }

    public interface f {
        void cE();

        void cF();

        void z(float f);
    }

    class a extends android.support.v4.view.a {
        private final Rect ea = new Rect();

        a() {
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            if (DrawerLayout.zd) {
                super.a(view, bVar);
            } else {
                android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
                super.a(view, a);
                bVar.setSource(view);
                ViewParent J = z.J(view);
                if (J instanceof View) {
                    bVar.setParent((View) J);
                }
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
                a.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.az(childAt)) {
                        bVar.addChild(childAt);
                    }
                }
            }
            bVar.setClassName(DrawerLayout.class.getName());
            bVar.setFocusable(false);
            bVar.setFocused(false);
            bVar.a(android.support.v4.view.a.b.a.xt);
            bVar.a(android.support.v4.view.a.b.a.xu);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = DrawerLayout.this.cC();
            if (a != null) {
                int au = DrawerLayout.this.au(a);
                View view2 = DrawerLayout.this;
                au = android.support.v4.view.f.getAbsoluteGravity(au, z.I(view2));
                Object obj = au == 3 ? view2.zA : au == 5 ? view2.zB : null;
                if (obj != null) {
                    text.add(obj);
                }
            }
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.zd || DrawerLayout.az(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    final class b extends android.support.v4.view.a {
        b() {
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            if (!DrawerLayout.az(view)) {
                bVar.setParent(null);
            }
        }
    }

    static class d implements c {
        d() {
        }

        public final void aA(View view) {
            g.aA(view);
        }

        public final void a(View view, Object obj, int i) {
            g.a(view, obj, i);
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            g.a(marginLayoutParams, obj, i);
        }

        public final int I(Object obj) {
            return g.I(obj);
        }

        public final Drawable P(Context context) {
            return g.P(context);
        }
    }

    static class e implements c {
        e() {
        }

        public final void aA(View view) {
        }

        public final void a(View view, Object obj, int i) {
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public final int I(Object obj) {
            return 0;
        }

        public final Drawable P(Context context) {
            return null;
        }
    }

    private class g extends android.support.v4.widget.u.a {
        final int zS;
        u zT;
        private final Runnable zU = new Runnable() {
            public final void run() {
                View as;
                int i = 0;
                g gVar = g.this;
                int i2 = gVar.zT.CF;
                boolean z = gVar.zS == 3;
                if (z) {
                    as = DrawerLayout.this.as(3);
                    i2 = (as != null ? -as.getWidth() : 0) + i2;
                } else {
                    as = DrawerLayout.this.as(5);
                    i2 = DrawerLayout.this.getWidth() - i2;
                }
                if (as == null) {
                    return;
                }
                if (((z && as.getLeft() < i2) || (!z && as.getLeft() > i2)) && DrawerLayout.this.as(as) == 0) {
                    LayoutParams layoutParams = (LayoutParams) as.getLayoutParams();
                    gVar.zT.d(as, i2, as.getTop());
                    layoutParams.zL = true;
                    DrawerLayout.this.invalidate();
                    gVar.cG();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.zw) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        i2 = drawerLayout.getChildCount();
                        while (i < i2) {
                            drawerLayout.getChildAt(i).dispatchTouchEvent(obtain);
                            i++;
                        }
                        obtain.recycle();
                        drawerLayout.zw = true;
                    }
                }
            }
        };

        public g(int i) {
            this.zS = i;
        }

        public final void cA() {
            DrawerLayout.this.removeCallbacks(this.zU);
        }

        public final boolean b(View view, int i) {
            return DrawerLayout.aw(view) && DrawerLayout.this.m(view, this.zS) && DrawerLayout.this.as(view) == 0;
        }

        public final void t(int i) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            View view = this.zT.CI;
            int i2 = drawerLayout.zl.Cu;
            int i3 = drawerLayout.zm.Cu;
            i3 = (i2 == 1 || i3 == 1) ? 1 : (i2 == 2 || i3 == 2) ? 2 : 0;
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.zK == 0.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.zM & 1) == 1) {
                        layoutParams.zM = 0;
                        if (drawerLayout.bX != null) {
                            for (i2 = drawerLayout.bX.size() - 1; i2 >= 0; i2--) {
                                ((f) drawerLayout.bX.get(i2)).cF();
                            }
                        }
                        drawerLayout.c(view, false);
                        if (drawerLayout.hasWindowFocus()) {
                            View rootView = drawerLayout.getRootView();
                            if (rootView != null) {
                                rootView.sendAccessibilityEvent(32);
                            }
                        }
                    }
                } else if (layoutParams.zK == 1.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.zM & 1) == 0) {
                        layoutParams.zM = 1;
                        if (drawerLayout.bX != null) {
                            for (i2 = drawerLayout.bX.size() - 1; i2 >= 0; i2--) {
                                ((f) drawerLayout.bX.get(i2)).cE();
                            }
                        }
                        drawerLayout.c(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                        view.requestFocus();
                    }
                }
            }
            if (i3 != drawerLayout.zp) {
                drawerLayout.zp = i3;
                if (drawerLayout.bX != null) {
                    for (int size = drawerLayout.bX.size() - 1; size >= 0; size--) {
                        drawerLayout.bX.get(size);
                    }
                }
            }
        }

        public final void a(View view, int i, int i2) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.m(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (DrawerLayout.this.getWidth() - i)) / ((float) width);
            }
            DrawerLayout.this.i(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public final void f(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).zL = false;
            cG();
        }

        final void cG() {
            int i = 3;
            if (this.zS == 3) {
                i = 5;
            }
            View as = DrawerLayout.this.as(i);
            if (as != null) {
                DrawerLayout.this.ay(as);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            float at = DrawerLayout.at(view);
            int width = view.getWidth();
            if (DrawerLayout.this.m(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && at > 0.5f)) ? 0 : -width;
            } else {
                i = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && at > 0.5f)) {
                    i -= width;
                }
            }
            this.zT.w(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public final void cH() {
            DrawerLayout.this.postDelayed(this.zU, 160);
        }

        public final void t(int i, int i2) {
            View as;
            if ((i & 1) == 1) {
                as = DrawerLayout.this.as(3);
            } else {
                as = DrawerLayout.this.as(5);
            }
            if (as != null && DrawerLayout.this.as(as) == 0) {
                this.zT.n(as, i2);
            }
        }

        public final int s(View view) {
            return DrawerLayout.aw(view) ? view.getWidth() : 0;
        }

        public final int d(View view, int i) {
            if (DrawerLayout.this.m(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int c(View view, int i) {
            return view.getTop();
        }
    }

    static /* synthetic */ boolean az(View view) {
        return (z.F(view) == 4 || z.F(view) == 2) ? false : true;
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        ze = z;
        if (VERSION.SDK_INT >= 21) {
            zI = new d();
        } else {
            zI = new e();
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zf = new b();
        this.zi = -1728053248;
        this.zk = new Paint();
        this.wF = true;
        this.zq = 3;
        this.zr = 3;
        this.zt = 3;
        this.zu = 3;
        this.zD = null;
        this.zE = null;
        this.zF = null;
        this.zG = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.zh = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.zn = new g(3);
        this.zo = new g(5);
        this.zl = u.a((ViewGroup) this, 1.0f, this.zn);
        this.zl.CG = 1;
        this.zl.CE = f2;
        this.zn.zT = this.zl;
        this.zm = u.a((ViewGroup) this, 1.0f, this.zo);
        this.zm.CG = 2;
        this.zm.CE = f2;
        this.zo.zT = this.zm;
        setFocusableInTouchMode(true);
        z.i(this, 1);
        z.a((View) this, new a());
        af.d(this);
        if (z.Z(this)) {
            zI.aA(this);
            this.eK = zI.P(context);
        }
        this.zg = f * 10.0f;
        this.zH = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.zg = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (aw(childAt)) {
                z.g(childAt, this.zg);
            }
        }
    }

    public float getDrawerElevation() {
        if (ze) {
            return this.zg;
        }
        return 0.0f;
    }

    public final void k(Object obj, boolean z) {
        this.zC = obj;
        this.eJ = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.zi = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(f fVar) {
        if (this.zx != null) {
            f fVar2 = this.zx;
            if (!(fVar2 == null || this.bX == null)) {
                this.bX.remove(fVar2);
            }
        }
        if (!(fVar == null || fVar == null)) {
            if (this.bX == null) {
                this.bX = new ArrayList();
            }
            this.bX.add(fVar);
        }
        this.zx = fVar;
    }

    public void setDrawerLockMode(int i) {
        s(i, 3);
        s(i, 5);
    }

    private void s(int i, int i2) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i2, z.I(this));
        switch (i2) {
            case 3:
                this.zq = i;
                break;
            case 5:
                this.zr = i;
                break;
            case 8388611:
                this.zt = i;
                break;
            case 8388613:
                this.zu = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.zl : this.zm).cancel();
        }
        View as;
        switch (i) {
            case 1:
                as = as(absoluteGravity);
                if (as != null) {
                    ay(as);
                    return;
                }
                return;
            case 2:
                as = as(absoluteGravity);
                if (as != null) {
                    ax(as);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int as(View view) {
        if (aw(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).gravity;
            int I = z.I(this);
            switch (i) {
                case 3:
                    if (this.zq != 3) {
                        return this.zq;
                    }
                    i = I == 0 ? this.zt : this.zu;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.zr != 3) {
                        return this.zr;
                    }
                    i = I == 0 ? this.zu : this.zt;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.zt != 3) {
                        return this.zt;
                    }
                    i = I == 0 ? this.zq : this.zr;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.zu != 3) {
                        return this.zu;
                    }
                    i = I == 0 ? this.zr : this.zq;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    final void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || aw(childAt)) && !(z && childAt == view)) {
                z.i(childAt, 4);
            } else {
                z.i(childAt, 1);
            }
        }
    }

    final void i(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.zK) {
            layoutParams.zK = f;
            if (this.bX != null) {
                for (int size = this.bX.size() - 1; size >= 0; size--) {
                    ((f) this.bX.get(size)).z(f);
                }
            }
        }
    }

    static float at(View view) {
        return ((LayoutParams) view.getLayoutParams()).zK;
    }

    final int au(View view) {
        return android.support.v4.view.f.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, z.I(this));
    }

    final boolean m(View view, int i) {
        return (au(view) & i) == i;
    }

    private View cB() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).zM & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    final View as(int i) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, z.I(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((au(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wF = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.wF = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int I;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = l.CTRL_BYTE;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    mode = l.CTRL_BYTE;
                    setMeasuredDimension(size, mode);
                    if (this.zC == null && z.Z(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    I = z.I(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            MarginLayoutParams marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(marginLayoutParams.gravity, I);
                                if (z.Z(childAt)) {
                                    zI.a(childAt, this.zC, absoluteGravity);
                                } else {
                                    zI.a(marginLayoutParams, this.zC, absoluteGravity);
                                }
                            }
                            if (av(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((size - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                            } else if (aw(childAt)) {
                                if (ze && z.W(childAt) != this.zg) {
                                    z.g(childAt, this.zg);
                                }
                                int au = au(childAt) & 7;
                                Object obj4 = au == 3 ? 1 : null;
                                if ((obj4 == null || obj2 == null) && (obj4 != null || obj3 == null)) {
                                    if (obj4 != null) {
                                        obj2 = 1;
                                    } else {
                                        obj3 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.zh + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                                    String toHexString = (au & 3) == 3 ? "LEFT" : (au & 5) == 5 ? "RIGHT" : Integer.toHexString(au);
                                    throw new IllegalStateException(stringBuilder.append(toHexString).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                                }
                            } else {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size2;
        setMeasuredDimension(size, mode);
        if (this.zC == null) {
        }
        obj = null;
        I = z.I(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                MarginLayoutParams marginLayoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (obj != null) {
                    int absoluteGravity2 = android.support.v4.view.f.getAbsoluteGravity(marginLayoutParams2.gravity, I);
                    if (z.Z(childAt2)) {
                        zI.a(childAt2, this.zC, absoluteGravity2);
                    } else {
                        zI.a(marginLayoutParams2, this.zC, absoluteGravity2);
                    }
                }
                if (av(childAt2)) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((size - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((mode - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin, 1073741824));
                } else if (aw(childAt2)) {
                    if (ze && z.W(childAt2) != this.zg) {
                        z.g(childAt2, this.zg);
                    }
                    int au2 = au(childAt2) & 7;
                    Object obj42 = au2 == 3 ? 1 : null;
                    if ((obj42 == null || obj2 == null) && (obj42 != null || obj3 == null)) {
                        if (obj42 != null) {
                            obj2 = 1;
                        } else {
                            obj3 = 1;
                        }
                        childAt2.measure(getChildMeasureSpec(i, (this.zh + marginLayoutParams2.leftMargin) + marginLayoutParams2.rightMargin, marginLayoutParams2.width), getChildMeasureSpec(i2, marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin, marginLayoutParams2.height));
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder("Child drawer has absolute gravity ");
                        String toHexString2 = (au2 & 3) == 3 ? "LEFT" : (au2 & 5) == 5 ? "RIGHT" : Integer.toHexString(au2);
                        throw new IllegalStateException(stringBuilder2.append(toHexString2).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt2 + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    private static boolean c(Drawable drawable, int i) {
        if (drawable == null || !android.support.v4.b.a.a.c(drawable)) {
            return false;
        }
        android.support.v4.b.a.a.b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (av(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * layoutParams.zK)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * layoutParams.zK));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.zK ? 1 : null;
                    int i7;
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < layoutParams.topMargin) {
                                i7 = layoutParams.topMargin;
                            } else if (i7 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i7 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case 80:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, layoutParams.topMargin, measuredWidth + a, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        i(childAt, f);
                    }
                    int i9 = layoutParams.zK > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.wF = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).zK);
        }
        this.zj = f;
        if ((this.zl.cX() | this.zm.cX()) != 0) {
            z.E(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.eK = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.eK;
    }

    public void setStatusBarBackground(int i) {
        this.eK = i != 0 ? android.support.v4.content.a.f(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.eK = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        if (!ze) {
            Drawable drawable;
            int I = z.I(this);
            if (I == 0) {
                if (this.zD != null) {
                    c(this.zD, I);
                    drawable = this.zD;
                }
                drawable = this.zF;
            } else {
                if (this.zE != null) {
                    c(this.zE, I);
                    drawable = this.zE;
                }
                drawable = this.zF;
            }
            this.zy = drawable;
            I = z.I(this);
            if (I == 0) {
                if (this.zE != null) {
                    c(this.zE, I);
                    drawable = this.zE;
                }
                drawable = this.zG;
            } else {
                if (this.zD != null) {
                    c(this.zD, I);
                    drawable = this.zD;
                }
                drawable = this.zG;
            }
            this.zz = drawable;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eJ && this.eK != null) {
            int I = zI.I(this.zC);
            if (I > 0) {
                this.eK.setBounds(0, 0, getWidth(), I);
                this.eK.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean av = av(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (av) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    Object obj = background != null ? background.getOpacity() == -1 ? 1 : null : null;
                    if (obj != null && aw(childAt) && childAt.getHeight() >= height) {
                        if (m(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                                width = right;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float max;
        if (this.zj > 0.0f && av) {
            this.zk.setColor((((int) (((float) ((this.zi & -16777216) >>> 24)) * this.zj)) << 24) | (this.zi & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.zk);
        } else if (this.zy != null && m(view, 3)) {
            right = this.zy.getIntrinsicWidth();
            i = view.getRight();
            max = Math.max(0.0f, Math.min(((float) i) / ((float) this.zl.CF), 1.0f));
            this.zy.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.zy.setAlpha((int) (255.0f * max));
            this.zy.draw(canvas);
        } else if (this.zz != null && m(view, 5)) {
            right = this.zz.getIntrinsicWidth();
            i = view.getLeft();
            max = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.zm.CF), 1.0f));
            this.zz.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.zz.setAlpha((int) (255.0f * max));
            this.zz.draw(canvas);
        }
        return drawChild;
    }

    private static boolean av(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    static boolean aw(View view) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, z.I(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.o.d(r10);
        r3 = r9.zl;
        r3 = r3.j(r10);
        r4 = r9.zm;
        r4 = r4.j(r10);
        r4 = r4 | r3;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x00ad;
            case 2: goto L_0x0064;
            case 3: goto L_0x00ad;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r4 != 0) goto L_0x0039;
    L_0x0019:
        if (r0 != 0) goto L_0x0039;
    L_0x001b:
        r4 = r9.getChildCount();
        r3 = r2;
    L_0x0020:
        if (r3 >= r4) goto L_0x00bb;
    L_0x0022:
        r0 = r9.getChildAt(r3);
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        r0 = r0.zL;
        if (r0 == 0) goto L_0x00b6;
    L_0x0032:
        r0 = r1;
    L_0x0033:
        if (r0 != 0) goto L_0x0039;
    L_0x0035:
        r0 = r9.zw;
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        return r2;
    L_0x003b:
        r0 = r10.getX();
        r3 = r10.getY();
        r9.vm = r0;
        r9.vn = r3;
        r5 = r9.zj;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00be;
    L_0x004e:
        r5 = r9.zl;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r5.x(r0, r3);
        if (r0 == 0) goto L_0x00be;
    L_0x0058:
        r0 = av(r0);
        if (r0 == 0) goto L_0x00be;
    L_0x005e:
        r0 = r1;
    L_0x005f:
        r9.zv = r2;
        r9.zw = r2;
        goto L_0x0017;
    L_0x0064:
        r5 = r9.zl;
        r0 = r5.Cv;
        r6 = r0.length;
        r0 = r2;
    L_0x006a:
        if (r0 >= r6) goto L_0x00ab;
    L_0x006c:
        r3 = r5.aA(r0);
        if (r3 == 0) goto L_0x00a6;
    L_0x0072:
        r3 = r5.Cx;
        r3 = r3[r0];
        r7 = r5.Cv;
        r7 = r7[r0];
        r3 = r3 - r7;
        r7 = r5.Cy;
        r7 = r7[r0];
        r8 = r5.Cw;
        r8 = r8[r0];
        r7 = r7 - r8;
        r3 = r3 * r3;
        r7 = r7 * r7;
        r3 = r3 + r7;
        r7 = r5.fW;
        r8 = r5.fW;
        r7 = r7 * r8;
        r7 = (float) r7;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x00a4;
    L_0x0091:
        r3 = r1;
    L_0x0092:
        if (r3 == 0) goto L_0x00a8;
    L_0x0094:
        r0 = r1;
    L_0x0095:
        if (r0 == 0) goto L_0x0016;
    L_0x0097:
        r0 = r9.zn;
        r0.cA();
        r0 = r9.zo;
        r0.cA();
        r0 = r2;
        goto L_0x0017;
    L_0x00a4:
        r3 = r2;
        goto L_0x0092;
    L_0x00a6:
        r3 = r2;
        goto L_0x0092;
    L_0x00a8:
        r0 = r0 + 1;
        goto L_0x006a;
    L_0x00ab:
        r0 = r2;
        goto L_0x0095;
    L_0x00ad:
        r9.z(r1);
        r9.zv = r2;
        r9.zw = r2;
        goto L_0x0016;
    L_0x00b6:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0020;
    L_0x00bb:
        r0 = r2;
        goto L_0x0033;
    L_0x00be:
        r0 = r2;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.zl.k(motionEvent);
        this.zm.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.vm = x;
                this.vn = y;
                this.zv = false;
                this.zw = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View x2 = this.zl.x((int) x, (int) y);
                if (x2 != null && av(x2)) {
                    x -= this.vm;
                    y -= this.vn;
                    int i = this.zl.fW;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View cB = cB();
                        if (cB != null) {
                            z = as(cB) == 2;
                            z(z);
                            this.zv = false;
                            break;
                        }
                    }
                }
                z = true;
                z(z);
                this.zv = false;
            case 3:
                z(true);
                this.zv = false;
                this.zw = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.zv = z;
        if (z) {
            z(true);
        }
    }

    private void z(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (aw(childAt) && (!z || layoutParams.zL)) {
                int width = childAt.getWidth();
                if (m(childAt, 3)) {
                    i |= this.zl.d(childAt, -width, childAt.getTop());
                } else {
                    i |= this.zm.d(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.zL = false;
            }
        }
        this.zn.cA();
        this.zo.cA();
        if (i != 0) {
            invalidate();
        }
    }

    private void ax(View view) {
        if (aw(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.wF) {
                layoutParams.zK = 1.0f;
                layoutParams.zM = 1;
                c(view, true);
            } else {
                LayoutParams.b(layoutParams, 2);
                if (m(view, 3)) {
                    this.zl.d(view, 0, view.getTop());
                } else {
                    this.zm.d(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void ay(View view) {
        if (aw(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.wF) {
                layoutParams.zK = 0.0f;
                layoutParams.zM = 0;
            } else {
                LayoutParams.b(layoutParams, 4);
                if (m(view, 3)) {
                    this.zl.d(view, -view.getWidth(), view.getTop());
                } else {
                    this.zm.d(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            Object obj = null;
            while (i3 < childCount) {
                Object obj2;
                View childAt = getChildAt(i3);
                if (!aw(childAt)) {
                    this.zH.add(childAt);
                    obj2 = obj;
                } else if (aw(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).zM & 1) == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        childAt.addFocusables(arrayList, i, i2);
                        obj2 = 1;
                    }
                    obj2 = obj;
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                i3++;
                obj = obj2;
            }
            if (obj == null) {
                int size = this.zH.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.zH.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.zH.clear();
        }
    }

    private View cC() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (aw(childAt)) {
                if (aw(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).zK > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cC() != null) {
                android.support.v4.view.g.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View cC = cC();
        if (cC != null && as(cC) == 0) {
            z(false);
        }
        if (cC != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.zN != 0) {
                View as = as(savedState.zN);
                if (as != null) {
                    ax(as);
                }
            }
            if (savedState.zO != 3) {
                s(savedState.zO, 3);
            }
            if (savedState.zP != 3) {
                s(savedState.zP, 5);
            }
            if (savedState.zQ != 3) {
                s(savedState.zQ, 8388611);
            }
            if (savedState.zR != 3) {
                s(savedState.zR, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.zM == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.zM == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || obj2 != null) {
                savedState.zN = layoutParams.gravity;
                break;
            }
        }
        savedState.zO = this.zq;
        savedState.zP = this.zr;
        savedState.zQ = this.zt;
        savedState.zR = this.zu;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (cB() != null || aw(view)) {
            z.i(view, 4);
        } else {
            z.i(view, 1);
        }
        if (!zd) {
            z.a(view, this.zf);
        }
    }
}
