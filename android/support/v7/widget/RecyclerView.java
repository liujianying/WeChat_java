package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.e;
import android.support.v4.view.ae;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.d.a.c;
import android.support.v7.widget.as.b;
import android.support.v7.widget.s.a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup implements p, w {
    private static final int[] QI = new int[]{16843830};
    private static final boolean QJ;
    static final boolean QK;
    private static final Class<?>[] QL = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final Interpolator RO = new 3();
    private final int[] AL;
    private final int[] AM;
    private final o QM;
    final m QN;
    private SavedState QO;
    e QP;
    s QQ;
    final as QR;
    private boolean QS;
    private final Runnable QT;
    private a QU;
    public h QV;
    private n QW;
    public final ArrayList<g> QX;
    public final ArrayList<j> QY;
    public j QZ;
    private final s RA;
    final q RB;
    private k RC;
    public List<k> RD;
    boolean RE;
    boolean RF;
    private b RG;
    private boolean RH;
    private ac RI;
    private d RJ;
    private final int[] RK;
    private q RL;
    private final int[] RM;
    private Runnable RN;
    private final b RP;
    private boolean Ra;
    private boolean Rb;
    boolean Rc;
    private int Rd;
    private boolean Re;
    public boolean Rf;
    private boolean Rg;
    private int Rh;
    private boolean Ri;
    private final boolean Rj;
    public List<i> Rk;
    boolean Rl;
    private int Rm;
    android.support.v4.widget.i Rn;
    android.support.v4.widget.i Ro;
    android.support.v4.widget.i Rp;
    android.support.v4.widget.i Rq;
    e Rr;
    private int Rs;
    private int Rt;
    private int Ru;
    private int Rv;
    private int Rw;
    private final int Rx;
    private final int Ry;
    private float Rz;
    private final Rect bJ;
    private VelocityTracker cE;
    private int fW;
    private final AccessibilityManager gD;
    private int if;

    public interface d {
        int af(int i, int i2);
    }

    public interface i {
        void bl(View view);
    }

    public interface j {
        void S(boolean z);

        boolean n(MotionEvent motionEvent);

        void o(MotionEvent motionEvent);
    }

    static /* synthetic */ void b(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        tVar.T(false);
        if (recyclerView.Rr.e(tVar, cVar, cVar2)) {
            recyclerView.fL();
        }
    }

    static /* synthetic */ void d(RecyclerView recyclerView, int i) {
        if (recyclerView.QV != null) {
            recyclerView.QV.bg(i);
            recyclerView.awakenScrollBars();
        }
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.Rl) {
            int i;
            recyclerView.Rl = true;
            int eO = recyclerView.QQ.eO();
            for (i = 0; i < eO; i++) {
                t aY = aY(recyclerView.QQ.aW(i));
                if (!(aY == null || aY.gk())) {
                    aY.addFlags(512);
                }
            }
            m mVar = recyclerView.QN;
            int size = mVar.Sp.size();
            for (i = 0; i < size; i++) {
                t tVar = (t) mVar.Sp.get(i);
                if (tVar != null) {
                    tVar.addFlags(512);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        QJ = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        QK = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.QM = new o(this, (byte) 0);
        this.QN = new m(this);
        this.QR = new as();
        this.QT = new Runnable() {
            public final void run() {
                if (RecyclerView.this.Rc && !RecyclerView.this.isLayoutRequested()) {
                    if (RecyclerView.this.Rf) {
                        RecyclerView.this.Re = true;
                    } else {
                        RecyclerView.this.fw();
                    }
                }
            }
        };
        this.bJ = new Rect();
        this.QX = new ArrayList();
        this.QY = new ArrayList();
        this.Rd = 0;
        this.Rl = false;
        this.Rm = 0;
        this.Rr = new v();
        this.if = 0;
        this.Rs = -1;
        this.Rz = Float.MIN_VALUE;
        this.RA = new s(this);
        this.RB = new q();
        this.RE = false;
        this.RF = false;
        this.RG = new f(this, (byte) 0);
        this.RH = false;
        this.RK = new int[2];
        this.AL = new int[2];
        this.AM = new int[2];
        this.RM = new int[2];
        this.RN = new Runnable() {
            public final void run() {
                if (RecyclerView.this.Rr != null) {
                    RecyclerView.this.Rr.eR();
                }
                RecyclerView.this.RH = false;
            }
        };
        this.RP = new 4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.Rj = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.fW = viewConfiguration.getScaledTouchSlop();
        this.Rx = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Ry = viewConfiguration.getScaledMaximumFlingVelocity();
        if (z.B(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.Rr.RT = this.RG;
        this.QP = new e(new 6(this));
        this.QQ = new s(new 5(this));
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        this.gD = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ac(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(c.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    string = trim.charAt(0) == '.' ? context.getPackageName() + trim : trim.contains(".") ? trim : RecyclerView.class.getPackage().getName() + '.' + trim;
                    try {
                        Constructor constructor;
                        Object[] objArr;
                        Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(string).asSubclass(h.class);
                        try {
                            constructor = asSubclass.getConstructor(QL);
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((h) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string, e32222);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, QI, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public ac getCompatAccessibilityDelegate() {
        return this.RI;
    }

    public void setAccessibilityDelegateCompat(ac acVar) {
        this.RI = acVar;
        z.a(this, this.RI);
    }

    public void setHasFixedSize(boolean z) {
        this.Rb = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.QS) {
            fE();
        }
        this.QS = z;
        super.setClipToPadding(z);
        if (this.Rc) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.fW = ae.a(viewConfiguration);
                return;
            default:
                new StringBuilder("setScrollingTouchSlop(): bad argument constant ").append(i).append("; using default value");
                break;
        }
        this.fW = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        if (this.QU != null) {
            this.QU.b(this.QM);
        }
        if (this.Rr != null) {
            this.Rr.eT();
        }
        if (this.QV != null) {
            this.QV.d(this.QN);
            this.QV.c(this.QN);
        }
        this.QN.clear();
        this.QP.reset();
        a aVar2 = this.QU;
        this.QU = aVar;
        if (aVar != null) {
            aVar.a(this.QM);
        }
        m mVar = this.QN;
        a aVar3 = this.QU;
        mVar.clear();
        l recycledViewPool = mVar.getRecycledViewPool();
        if (aVar2 != null) {
            recycledViewPool.detach();
        }
        if (recycledViewPool.Sm == 0) {
            recycledViewPool.Sk.clear();
        }
        if (aVar3 != null) {
            recycledViewPool.ge();
        }
        this.RB.SK = true;
        fT();
        requestLayout();
    }

    public a getAdapter() {
        return this.QU;
    }

    public void setRecyclerListener(n nVar) {
        this.QW = nVar;
    }

    public int getBaseline() {
        if (this.QV != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void setLayoutManager(h hVar) {
        if (hVar != this.QV) {
            fy();
            if (this.QV != null) {
                if (this.Ra) {
                    this.QV.b(this, this.QN);
                }
                this.QV.y(null);
            }
            this.QN.clear();
            s sVar = this.QQ;
            a aVar = sVar.NB;
            while (true) {
                aVar.ND = 0;
                if (aVar.NE == null) {
                    break;
                }
                aVar = aVar.NE;
            }
            for (int size = sVar.NC.size() - 1; size >= 0; size--) {
                sVar.NA.aR((View) sVar.NC.get(size));
                sVar.NC.remove(size);
            }
            sVar.NA.removeAllViews();
            this.QV = hVar;
            if (hVar != null) {
                if (hVar.Sa != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.Sa);
                }
                this.QV.y(this);
                if (this.Ra) {
                    this.QV.eC = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.QO != null) {
            SavedState.a(savedState, this.QO);
        } else if (this.QV != null) {
            savedState.Su = this.QV.onSaveInstanceState();
        } else {
            savedState.Su = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.QO = (SavedState) parcelable;
            super.onRestoreInstanceState(this.QO.getSuperState());
            if (this.QV != null && this.QO.Su != null) {
                this.QV.onRestoreInstanceState(this.QO.Su);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void f(t tVar) {
        View view = tVar.SU;
        boolean z = view.getParent() == this;
        this.QN.p(aP(view));
        if (tVar.gu()) {
            this.QQ.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            s sVar = this.QQ;
            int indexOfChild = sVar.NA.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            sVar.NB.set(indexOfChild);
            sVar.aM(view);
        } else {
            this.QQ.a(view, -1, true);
        }
    }

    public h getLayoutManager() {
        return this.QV;
    }

    public l getRecycledViewPool() {
        return this.QN.getRecycledViewPool();
    }

    public void setRecycledViewPool(l lVar) {
        m mVar = this.QN;
        if (mVar.Ss != null) {
            mVar.Ss.detach();
        }
        mVar.Ss = lVar;
        if (lVar != null) {
            l lVar2 = mVar.Ss;
            mVar.RQ.getAdapter();
            lVar2.ge();
        }
    }

    public void setViewCacheExtension(r rVar) {
        this.QN.St = rVar;
    }

    public void setItemViewCacheSize(int i) {
        m mVar = this.QN;
        mVar.Sr = i;
        for (int size = mVar.Sp.size() - 1; size >= 0 && mVar.Sp.size() > i; size--) {
            mVar.bu(size);
        }
    }

    public int getScrollState() {
        return this.if;
    }

    private void setScrollState(int i) {
        if (i != this.if) {
            this.if = i;
            if (i != 2) {
                fz();
            }
            if (this.QV != null) {
                this.QV.br(i);
            }
            if (this.RC != null) {
                this.RC.e(this, i);
            }
            if (this.RD != null) {
                for (int size = this.RD.size() - 1; size >= 0; size--) {
                    ((k) this.RD.get(size)).e(this, i);
                }
            }
        }
    }

    public final void a(g gVar) {
        if (this.QV != null) {
            this.QV.O("Cannot add item decoration during a scroll  or layout");
        }
        if (this.QX.isEmpty()) {
            setWillNotDraw(false);
        }
        this.QX.add(gVar);
        fR();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.RJ) {
            this.RJ = dVar;
            setChildrenDrawingOrderEnabled(this.RJ != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(k kVar) {
        this.RC = kVar;
    }

    public final void a(k kVar) {
        if (this.RD == null) {
            this.RD = new ArrayList();
        }
        this.RD.add(kVar);
    }

    public void bg(int i) {
        if (!this.Rf) {
            fy();
            if (this.QV != null) {
                this.QV.bg(i);
                awakenScrollBars();
            }
        }
    }

    public final void smoothScrollToPosition(int i) {
        if (!this.Rf && this.QV != null) {
            this.QV.a(this, i);
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.QV != null && !this.Rf) {
            boolean eZ = this.QV.eZ();
            boolean fa = this.QV.fa();
            if (eZ || fa) {
                if (!eZ) {
                    i = 0;
                }
                if (!fa) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void fw() {
        boolean z = false;
        if (!this.Rc) {
            return;
        }
        if (this.Rl) {
            e.beginSection("RV FullInvalidate");
            fO();
            e.endSection();
        } else if (!this.QP.eE()) {
        } else {
            if (this.QP.aQ(4) && !this.QP.aQ(11)) {
                e.beginSection("RV PartialInvalidate");
                fx();
                this.QP.eC();
                if (!this.Re) {
                    int childCount = this.QQ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        t aY = aY(this.QQ.getChildAt(i));
                        if (aY != null && !aY.gk() && aY.gz()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        fO();
                    } else {
                        this.QP.eD();
                    }
                }
                R(true);
                e.endSection();
            } else if (this.QP.eE()) {
                e.beginSection("RV FullInvalidate");
                fO();
                e.endSection();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        fw();
        if (this.QU != null) {
            int a;
            fx();
            fH();
            e.beginSection("RV Scroll");
            if (i != 0) {
                a = this.QV.a(i, this.QN, this.RB);
                i4 = i - a;
            } else {
                a = 0;
            }
            if (i2 != 0) {
                i7 = this.QV.b(i2, this.QN, this.RB);
                i5 = i2 - i7;
            }
            e.endSection();
            fU();
            fI();
            R(false);
            i3 = i7;
            i6 = a;
        } else {
            i3 = 0;
        }
        if (!this.QX.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i6, i3, i4, i5, this.AL)) {
            this.Rv -= this.AL[0];
            this.Rw -= this.AL[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.AL[0], (float) this.AL[1]);
            }
            int[] iArr = this.RM;
            iArr[0] = iArr[0] + this.AL[0];
            iArr = this.RM;
            iArr[1] = iArr[1] + this.AL[1];
        } else if (z.B(this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i4;
                float y = motionEvent.getY();
                float f2 = (float) i5;
                Object obj = null;
                if (f < 0.0f) {
                    fA();
                    if (this.Rn.s((-f) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    fB();
                    if (this.Rp.s(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    fC();
                    if (this.Ro.s((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    fD();
                    if (this.Rq.s(f2 / ((float) getHeight()), 1.0f - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    z.E(this);
                }
            }
            U(i, i2);
        }
        if (!(i6 == 0 && i3 == 0)) {
            W(i6, i3);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i6 == 0 && i3 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.QV != null && this.QV.eZ()) {
            return this.QV.b(this.RB);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.QV != null && this.QV.eZ()) {
            return this.QV.d(this.RB);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.QV != null && this.QV.eZ()) {
            return this.QV.f(this.RB);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.QV != null && this.QV.fa()) {
            return this.QV.c(this.RB);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.QV != null && this.QV.fa()) {
            return this.QV.e(this.RB);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.QV != null && this.QV.fa()) {
            return this.QV.g(this.RB);
        }
        return 0;
    }

    final void fx() {
        this.Rd++;
        if (this.Rd == 1 && !this.Rf) {
            this.Re = false;
        }
    }

    final void R(boolean z) {
        if (this.Rd <= 0) {
            this.Rd = 1;
        }
        if (!z) {
            this.Re = false;
        }
        if (this.Rd == 1) {
            if (!(!z || !this.Re || this.Rf || this.QV == null || this.QU == null)) {
                fO();
            }
            if (!this.Rf) {
                this.Re = false;
            }
        }
        this.Rd--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.Rf) {
            O("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.Rf = true;
                this.Rg = true;
                fy();
                return;
            }
            this.Rf = false;
            if (!(!this.Re || this.QV == null || this.QU == null)) {
                requestLayout();
            }
            this.Re = false;
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        int i3 = 0;
        if (this.QV != null && !this.Rf) {
            if (!this.QV.eZ()) {
                i = 0;
            }
            if (this.QV.fa()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.RA.smoothScrollBy(i, i3);
            }
        }
    }

    public boolean T(int i, int i2) {
        if (this.QV == null || this.Rf) {
            return false;
        }
        boolean eZ = this.QV.eZ();
        boolean fa = this.QV.fa();
        if (!eZ || Math.abs(i) < this.Rx) {
            i = 0;
        }
        if (!fa || Math.abs(i2) < this.Rx) {
            i2 = 0;
        }
        if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
            return false;
        }
        eZ = eZ || fa;
        dispatchNestedFling((float) i, (float) i2, eZ);
        if (!eZ) {
            return false;
        }
        int max = Math.max(-this.Ry, Math.min(i, this.Ry));
        int max2 = Math.max(-this.Ry, Math.min(i2, this.Ry));
        s sVar = this.RA;
        sVar.RQ.setScrollState(2);
        sVar.SR = 0;
        sVar.SQ = 0;
        sVar.fT.b(0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        sVar.gi();
        return true;
    }

    private void fy() {
        setScrollState(0);
        fz();
    }

    private void fz() {
        this.RA.stop();
        if (this.QV != null) {
            this.QV.gd();
        }
    }

    public int getMinFlingVelocity() {
        return this.Rx;
    }

    public int getMaxFlingVelocity() {
        return this.Ry;
    }

    private void U(int i, int i2) {
        int i3 = 0;
        if (!(this.Rn == null || this.Rn.isFinished() || i <= 0)) {
            i3 = this.Rn.cI();
        }
        if (!(this.Rp == null || this.Rp.isFinished() || i >= 0)) {
            i3 |= this.Rp.cI();
        }
        if (!(this.Ro == null || this.Ro.isFinished() || i2 <= 0)) {
            i3 |= this.Ro.cI();
        }
        if (!(this.Rq == null || this.Rq.isFinished() || i2 >= 0)) {
            i3 |= this.Rq.cI();
        }
        if (i3 != 0) {
            z.E(this);
        }
    }

    final void fA() {
        if (this.Rn == null) {
            this.Rn = new android.support.v4.widget.i(getContext());
            if (this.QS) {
                this.Rn.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Rn.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fB() {
        if (this.Rp == null) {
            this.Rp = new android.support.v4.widget.i(getContext());
            if (this.QS) {
                this.Rp.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Rp.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fC() {
        if (this.Ro == null) {
            this.Ro = new android.support.v4.widget.i(getContext());
            if (this.QS) {
                this.Ro.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Ro.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void fD() {
        if (this.Rq == null) {
            this.Rq = new android.support.v4.widget.i(getContext());
            if (this.QS) {
                this.Rq.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Rq.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void fE() {
        this.Rq = null;
        this.Ro = null;
        this.Rp = null;
        this.Rn = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.QU == null || this.QV == null || fK() || this.Rf)) {
            fx();
            findNextFocus = this.QV.a(view, i, this.QN, this.RB);
            R(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    public void requestChildFocus(View view, View view2) {
        int i = (this.QV.gb() || fK()) ? 1 : 0;
        if (i == 0 && view2 != null) {
            this.bJ.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.Si) {
                    Rect rect = layoutParams2.OB;
                    Rect rect2 = this.bJ;
                    rect2.left -= rect.left;
                    rect2 = this.bJ;
                    rect2.right += rect.right;
                    rect2 = this.bJ;
                    rect2.top -= rect.top;
                    rect2 = this.bJ;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.bJ);
            offsetRectIntoDescendantCoords(view, this.bJ);
            requestChildRectangleOnScreen(view, this.bJ, !this.Rc);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        h hVar = this.QV;
        int paddingLeft = hVar.getPaddingLeft();
        int paddingTop = hVar.getPaddingTop();
        int paddingRight = hVar.mWidth - hVar.getPaddingRight();
        int paddingBottom = hVar.mHeight - hVar.getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - paddingLeft);
        int min2 = Math.min(0, top - paddingTop);
        int max = Math.max(0, width - paddingRight);
        paddingBottom = Math.max(0, height - paddingBottom);
        if (z.I(hVar.Sa) == 1) {
            if (max == 0) {
                max = Math.max(min, width - paddingRight);
            }
            min = max;
        } else {
            min = min != 0 ? min : Math.min(left - paddingLeft, max);
        }
        max = min2 != 0 ? min2 : Math.min(top - paddingTop, paddingBottom);
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            scrollBy(min, max);
        } else {
            smoothScrollBy(min, max);
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Rm = 0;
        this.Ra = true;
        this.Rc = false;
        if (this.QV != null) {
            this.QV.eC = true;
        }
        this.RH = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Rr != null) {
            this.Rr.eT();
        }
        this.Rc = false;
        fy();
        this.Ra = false;
        if (this.QV != null) {
            this.QV.b(this, this.QN);
        }
        removeCallbacks(this.RN);
        as.a.hk();
    }

    public boolean isAttachedToWindow() {
        return this.Ra;
    }

    final void O(String str) {
        if (!fK()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.Rf) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.QZ = null;
        }
        int size = this.QY.size();
        for (i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.QY.get(i2);
            if (jVar.n(motionEvent) && action != 3) {
                this.QZ = jVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            fG();
            return true;
        } else if (this.QV == null) {
            return false;
        } else {
            z = this.QV.eZ();
            boolean fa = this.QV.fa();
            if (this.cE == null) {
                this.cE = VelocityTracker.obtain();
            }
            this.cE.addMovement(motionEvent);
            action = o.d(motionEvent);
            size = o.e(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.Rg) {
                        this.Rg = false;
                    }
                    this.Rs = o.c(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.Rv = i;
                    this.Rt = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.Rw = i;
                    this.Ru = i;
                    if (this.if == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.RM;
                    this.RM[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (fa) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.cE.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = o.b(motionEvent, this.Rs);
                    if (action >= 0) {
                        size = (int) (o.d(motionEvent, action) + 0.5f);
                        action = (int) (o.e(motionEvent, action) + 0.5f);
                        if (this.if != 1) {
                            size -= this.Rt;
                            action -= this.Ru;
                            if (!z || Math.abs(size) <= this.fW) {
                                z = false;
                            } else {
                                this.Rv = ((size < 0 ? -1 : 1) * this.fW) + this.Rt;
                                z = true;
                            }
                            if (fa && Math.abs(action) > this.fW) {
                                i3 = this.Ru;
                                i2 = this.fW;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.Rw = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.Rs).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fG();
                    break;
                case 5:
                    this.Rs = o.c(motionEvent, size);
                    i3 = (int) (o.d(motionEvent, size) + 0.5f);
                    this.Rv = i3;
                    this.Rt = i3;
                    i3 = (int) (o.e(motionEvent, size) + 0.5f);
                    this.Rw = i3;
                    this.Ru = i3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (this.if != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.QY.size();
        for (int i = 0; i < size; i++) {
            ((j) this.QY.get(i)).S(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Rf || this.Rg) {
            return false;
        }
        boolean z2;
        int e;
        int action = motionEvent.getAction();
        if (this.QZ != null) {
            if (action == 0) {
                this.QZ = null;
            } else {
                this.QZ.o(motionEvent);
                if (action == 3 || action == 1) {
                    this.QZ = null;
                }
                z2 = true;
                if (z2) {
                    fG();
                    return true;
                } else if (this.QV == null) {
                    return false;
                } else {
                    boolean eZ = this.QV.eZ();
                    boolean fa = this.QV.fa();
                    if (this.cE == null) {
                        this.cE = VelocityTracker.obtain();
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    action = o.d(motionEvent);
                    e = o.e(motionEvent);
                    if (action == 0) {
                        int[] iArr = this.RM;
                        this.RM[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.RM[0], (float) this.RM[1]);
                    switch (action) {
                        case 0:
                            this.Rs = o.c(motionEvent, 0);
                            action = (int) (motionEvent.getX() + 0.5f);
                            this.Rv = action;
                            this.Rt = action;
                            action = (int) (motionEvent.getY() + 0.5f);
                            this.Rw = action;
                            this.Ru = action;
                            if (eZ) {
                                action = 1;
                            } else {
                                action = 0;
                            }
                            if (fa) {
                                action |= 2;
                            }
                            startNestedScroll(action);
                            break;
                        case 1:
                            this.cE.addMovement(obtain);
                            this.cE.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT, (float) this.Ry);
                            float f = eZ ? -y.a(this.cE, this.Rs) : 0.0f;
                            float f2;
                            if (fa) {
                                f2 = -y.b(this.cE, this.Rs);
                            } else {
                                f2 = 0.0f;
                            }
                            if ((f == 0.0f && f2 == 0.0f) || !T((int) f, (int) f2)) {
                                setScrollState(0);
                            }
                            fF();
                            z = true;
                            break;
                        case 2:
                            action = o.b(motionEvent, this.Rs);
                            if (action >= 0) {
                                int d = (int) (o.d(motionEvent, action) + 0.5f);
                                int e2 = (int) (o.e(motionEvent, action) + 0.5f);
                                int i = this.Rv - d;
                                action = this.Rw - e2;
                                if (dispatchNestedPreScroll(i, action, this.AM, this.AL)) {
                                    i -= this.AM[0];
                                    action -= this.AM[1];
                                    obtain.offsetLocation((float) this.AL[0], (float) this.AL[1]);
                                    int[] iArr2 = this.RM;
                                    iArr2[0] = iArr2[0] + this.AL[0];
                                    iArr2 = this.RM;
                                    iArr2[1] = iArr2[1] + this.AL[1];
                                }
                                if (this.if != 1) {
                                    boolean z3;
                                    if (!eZ || Math.abs(i) <= this.fW) {
                                        z3 = false;
                                    } else {
                                        if (i > 0) {
                                            i -= this.fW;
                                        } else {
                                            i += this.fW;
                                        }
                                        z3 = true;
                                    }
                                    if (fa && Math.abs(action) > this.fW) {
                                        if (action > 0) {
                                            action -= this.fW;
                                        } else {
                                            action += this.fW;
                                        }
                                        z3 = true;
                                    }
                                    if (z3) {
                                        setScrollState(1);
                                    }
                                }
                                if (this.if == 1) {
                                    this.Rv = d - this.AL[0];
                                    this.Rw = e2 - this.AL[1];
                                    if (!eZ) {
                                        i = 0;
                                    }
                                    if (!fa) {
                                        action = 0;
                                    }
                                    if (a(i, action, obtain)) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                        break;
                                    }
                                }
                            }
                            new StringBuilder("Error processing scroll; pointer index for id ").append(this.Rs).append(" not found. Did any MotionEvents get skipped?");
                            return false;
                            break;
                        case 3:
                            fG();
                            break;
                        case 5:
                            this.Rs = o.c(motionEvent, e);
                            action = (int) (o.d(motionEvent, e) + 0.5f);
                            this.Rv = action;
                            this.Rt = action;
                            action = (int) (o.e(motionEvent, e) + 0.5f);
                            this.Rw = action;
                            this.Ru = action;
                            break;
                        case 6:
                            m(motionEvent);
                            break;
                    }
                    if (!z) {
                        this.cE.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        if (action != 0) {
            int size = this.QY.size();
            for (e = 0; e < size; e++) {
                j jVar = (j) this.QY.get(e);
                if (jVar.n(motionEvent)) {
                    this.QZ = jVar;
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            fG();
            return true;
        } else if (this.QV == null) {
            return false;
        } else {
            boolean eZ2 = this.QV.eZ();
            boolean fa2 = this.QV.fa();
            if (this.cE == null) {
                this.cE = VelocityTracker.obtain();
            }
            MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
            action = o.d(motionEvent);
            e = o.e(motionEvent);
            if (action == 0) {
                int[] iArr3 = this.RM;
                this.RM[1] = 0;
                iArr3[0] = 0;
            }
            obtain2.offsetLocation((float) this.RM[0], (float) this.RM[1]);
            switch (action) {
                case 0:
                    this.Rs = o.c(motionEvent, 0);
                    action = (int) (motionEvent.getX() + 0.5f);
                    this.Rv = action;
                    this.Rt = action;
                    action = (int) (motionEvent.getY() + 0.5f);
                    this.Rw = action;
                    this.Ru = action;
                    if (eZ2) {
                        action = 1;
                    } else {
                        action = 0;
                    }
                    if (fa2) {
                        action |= 2;
                    }
                    startNestedScroll(action);
                    break;
                case 1:
                    this.cE.addMovement(obtain2);
                    this.cE.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT, (float) this.Ry);
                    float f3 = eZ2 ? -y.a(this.cE, this.Rs) : 0.0f;
                    float f22;
                    if (fa2) {
                        f22 = -y.b(this.cE, this.Rs);
                    } else {
                        f22 = 0.0f;
                    }
                    if ((f3 == 0.0f && f22 == 0.0f) || !T((int) f3, (int) f22)) {
                        setScrollState(0);
                    }
                    fF();
                    z = true;
                    break;
                case 2:
                    action = o.b(motionEvent, this.Rs);
                    if (action >= 0) {
                        int d2 = (int) (o.d(motionEvent, action) + 0.5f);
                        int e22 = (int) (o.e(motionEvent, action) + 0.5f);
                        int i2 = this.Rv - d2;
                        action = this.Rw - e22;
                        if (dispatchNestedPreScroll(i2, action, this.AM, this.AL)) {
                            i2 -= this.AM[0];
                            action -= this.AM[1];
                            obtain2.offsetLocation((float) this.AL[0], (float) this.AL[1]);
                            int[] iArr22 = this.RM;
                            iArr22[0] = iArr22[0] + this.AL[0];
                            iArr22 = this.RM;
                            iArr22[1] = iArr22[1] + this.AL[1];
                        }
                        if (this.if != 1) {
                            boolean z32;
                            if (!eZ2 || Math.abs(i2) <= this.fW) {
                                z32 = false;
                            } else {
                                if (i2 > 0) {
                                    i2 -= this.fW;
                                } else {
                                    i2 += this.fW;
                                }
                                z32 = true;
                            }
                            if (fa2 && Math.abs(action) > this.fW) {
                                if (action > 0) {
                                    action -= this.fW;
                                } else {
                                    action += this.fW;
                                }
                                z32 = true;
                            }
                            if (z32) {
                                setScrollState(1);
                            }
                        }
                        if (this.if == 1) {
                            this.Rv = d2 - this.AL[0];
                            this.Rw = e22 - this.AL[1];
                            if (!eZ2) {
                                i2 = 0;
                            }
                            if (!fa2) {
                                action = 0;
                            }
                            if (a(i2, action, obtain2)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.Rs).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fG();
                    break;
                case 5:
                    this.Rs = o.c(motionEvent, e);
                    action = (int) (o.d(motionEvent, e) + 0.5f);
                    this.Rv = action;
                    this.Rt = action;
                    action = (int) (o.e(motionEvent, e) + 0.5f);
                    this.Rw = action;
                    this.Ru = action;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (!z) {
                this.cE.addMovement(obtain2);
            }
            obtain2.recycle();
            return true;
        }
    }

    private void fF() {
        if (this.cE != null) {
            this.cE.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.Rn != null) {
            i = this.Rn.cI();
        }
        if (this.Ro != null) {
            i |= this.Ro.cI();
        }
        if (this.Rp != null) {
            i |= this.Rp.cI();
        }
        if (this.Rq != null) {
            i |= this.Rq.cI();
        }
        if (i != 0) {
            z.E(this);
        }
    }

    private void fG() {
        fF();
        setScrollState(0);
    }

    private void m(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.Rs) {
            e = e == 0 ? 1 : 0;
            this.Rs = o.c(motionEvent, e);
            int d = (int) (o.d(motionEvent, e) + 0.5f);
            this.Rv = d;
            this.Rt = d;
            e = (int) (o.e(motionEvent, e) + 0.5f);
            this.Rw = e;
            this.Ru = e;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.QV == null || this.Rf || (o.g(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float f2;
            if (this.QV.fa()) {
                f = -o.f(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.QV.eZ()) {
                f2 = o.f(motionEvent, 10);
            } else {
                f2 = 0.0f;
            }
            if (!(f == 0.0f && f2 == 0.0f)) {
                float scrollFactor = getScrollFactor();
                a((int) (f2 * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.Rz == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.Rz = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.Rz;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.QV == null) {
            V(i, i2);
        } else if (h.a(this.QV)) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.QV.ai(i, i2);
            if (!z && this.QU != null) {
                if (this.RB.SF == 1) {
                    fP();
                }
                this.QV.ag(i, i2);
                this.RB.SP = true;
                fQ();
                this.QV.ah(i, i2);
                if (this.QV.ff()) {
                    this.QV.ag(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.RB.SP = true;
                    fQ();
                    this.QV.ah(i, i2);
                }
            }
        } else if (this.Rb) {
            this.QV.ai(i, i2);
        } else {
            if (this.Ri) {
                fx();
                fN();
                if (this.RB.SN) {
                    this.RB.SL = true;
                } else {
                    this.QP.eF();
                    this.RB.SL = false;
                }
                this.Ri = false;
                R(false);
            }
            if (this.QU != null) {
                this.RB.SH = this.QU.getItemCount();
            } else {
                this.RB.SH = 0;
            }
            fx();
            this.QV.ai(i, i2);
            R(false);
            this.RB.SL = false;
        }
    }

    final void V(int i, int i2) {
        setMeasuredDimension(h.m(i, getPaddingLeft() + getPaddingRight(), z.S(this)), h.m(i2, getPaddingTop() + getPaddingBottom(), z.T(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            fE();
        }
    }

    public void setItemAnimator(e eVar) {
        if (this.Rr != null) {
            this.Rr.eT();
            this.Rr.RT = null;
        }
        this.Rr = eVar;
        if (this.Rr != null) {
            this.Rr.RT = this.RG;
        }
    }

    private void fH() {
        this.Rm++;
    }

    private void fI() {
        this.Rm--;
        if (this.Rm <= 0) {
            this.Rm = 0;
            int i = this.Rh;
            this.Rh = 0;
            if (i != 0 && fJ()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                android.support.v4.view.a.a.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean fJ() {
        return this.gD != null && this.gD.isEnabled();
    }

    private boolean fK() {
        return this.Rm > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (fK()) {
            int b;
            if (accessibilityEvent != null) {
                b = android.support.v4.view.a.a.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.Rh = i | this.Rh;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public e getItemAnimator() {
        return this.Rr;
    }

    private void fL() {
        if (!this.RH && this.Ra) {
            z.a(this, this.RN);
            this.RH = true;
        }
    }

    private boolean fM() {
        return this.Rr != null && this.QV.eY();
    }

    private void fN() {
        boolean z;
        boolean z2 = true;
        if (this.Rl) {
            this.QP.reset();
            fT();
            this.QV.eU();
        }
        if (fM()) {
            this.QP.eC();
        } else {
            this.QP.eF();
        }
        boolean z3;
        if (this.RE || this.RF) {
            z3 = true;
        } else {
            z3 = false;
        }
        q qVar = this.RB;
        if (!this.Rc || this.Rr == null || (!(this.Rl || z3 || h.b(this.QV)) || (this.Rl && !this.QU.RS))) {
            z = false;
        } else {
            z = true;
        }
        qVar.SM = z;
        q qVar2 = this.RB;
        if (!(this.RB.SM && z3 && !this.Rl && fM())) {
            z2 = false;
        }
        qVar2.SN = z2;
    }

    private void fO() {
        if (this.QU != null && this.QV != null) {
            boolean z;
            int z2;
            int i;
            this.RB.SP = false;
            if (this.RB.SF == 1) {
                fP();
                this.QV.z(this);
                fQ();
            } else {
                e eVar = this.QP;
                if (eVar.LS.isEmpty() || eVar.LR.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = 1;
                }
                if (z2 == 0 && this.QV.mWidth == getWidth() && this.QV.mHeight == getHeight()) {
                    this.QV.z(this);
                } else {
                    this.QV.z(this);
                    fQ();
                }
            }
            this.RB.bx(4);
            fx();
            fH();
            this.RB.SF = 1;
            if (this.RB.SM) {
                for (int childCount = this.QQ.getChildCount() - 1; childCount >= 0; childCount--) {
                    t aY = aY(this.QQ.getChildAt(childCount));
                    if (!aY.gk()) {
                        long g = g(aY);
                        c b = new c().b(aY, 0);
                        t tVar = (t) this.QR.Xv.get(g);
                        if (!(tVar == null || tVar.gk())) {
                            boolean C = this.QR.C(tVar);
                            boolean C2 = this.QR.C(aY);
                            if (!(C && tVar == aY)) {
                                c c = this.QR.c(tVar, 4);
                                this.QR.c(aY, b);
                                b = this.QR.c(aY, 8);
                                if (c == null) {
                                    int childCount2 = this.QQ.getChildCount();
                                    i = 0;
                                    while (i < childCount2) {
                                        t aY2 = aY(this.QQ.getChildAt(i));
                                        if (aY2 == aY || g(aY2) != g) {
                                            i++;
                                        } else if (this.QU == null || !this.QU.RS) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        }
                                    }
                                    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(tVar).append(" cannot be found but it is necessary for ").append(aY);
                                } else {
                                    tVar.T(false);
                                    if (C) {
                                        f(tVar);
                                    }
                                    if (tVar != aY) {
                                        if (C2) {
                                            f(aY);
                                        }
                                        tVar.SZ = aY;
                                        f(tVar);
                                        this.QN.p(tVar);
                                        aY.T(false);
                                        aY.Ta = tVar;
                                    }
                                    if (this.Rr.a(tVar, aY, c, b)) {
                                        fL();
                                    }
                                }
                            }
                        }
                        this.QR.c(aY, b);
                    }
                }
                this.QR.a(this.RP);
            }
            this.QV.c(this.QN);
            this.RB.SI = this.RB.SH;
            this.Rl = false;
            this.RB.SM = false;
            this.RB.SN = false;
            h.c(this.QV);
            if (this.QN.So != null) {
                this.QN.So.clear();
            }
            fI();
            R(false);
            this.QR.clear();
            z2 = this.RK[0];
            i = this.RK[1];
            if (this.QQ.getChildCount() == 0) {
                z2 = (z2 == 0 && i == 0) ? false : true;
            } else {
                e(this.RK);
                z2 = (this.RK[0] == z2 && this.RK[1] == i) ? false : true;
            }
            if (z2) {
                W(0, 0);
            }
        }
    }

    private void fP() {
        int childCount;
        int i;
        t aY;
        this.RB.bx(1);
        this.RB.SP = false;
        fx();
        this.QR.clear();
        fH();
        fN();
        q qVar = this.RB;
        boolean z = this.RB.SM && this.RF;
        qVar.SO = z;
        this.RF = false;
        this.RE = false;
        this.RB.SL = this.RB.SN;
        this.RB.SH = this.QU.getItemCount();
        e(this.RK);
        if (this.RB.SM) {
            childCount = this.QQ.getChildCount();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.QQ.getChildAt(i));
                if (!aY.gk() && (!aY.gs() || this.QU.RS)) {
                    this.QR.b(aY, this.Rr.a(this.RB, aY, e.j(aY), aY.gw()));
                    if (!(!this.RB.SO || !aY.gz() || aY.isRemoved() || aY.gk() || aY.gs())) {
                        this.QR.a(g(aY), aY);
                    }
                }
            }
        }
        if (this.RB.SN) {
            childCount = this.QQ.eO();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.QQ.aW(i));
                if (!aY.gk() && aY.SV == -1) {
                    aY.SV = aY.mPosition;
                }
            }
            z = this.RB.SK;
            this.RB.SK = false;
            this.QV.c(this.QN, this.RB);
            this.RB.SK = z;
            for (childCount = 0; childCount < this.QQ.getChildCount(); childCount++) {
                aY = aY(this.QQ.getChildAt(childCount));
                if (!aY.gk()) {
                    as.a aVar = (as.a) this.QR.Xu.get(aY);
                    if (aVar == null || (aVar.flags & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        i = e.j(aY);
                        boolean by = aY.by(8192);
                        if (!by) {
                            i |= GLIcon.LEFT;
                        }
                        c a = this.Rr.a(this.RB, aY, i, aY.gw());
                        if (by) {
                            a(aY, a);
                        } else {
                            as asVar = this.QR;
                            aVar = (as.a) asVar.Xu.get(aY);
                            if (aVar == null) {
                                aVar = as.a.hj();
                                asVar.Xu.put(aY, aVar);
                            }
                            aVar.flags |= 2;
                            aVar.Xw = a;
                        }
                    }
                }
            }
            fS();
        } else {
            fS();
        }
        fI();
        R(false);
        this.RB.SF = 2;
    }

    private void fQ() {
        boolean z;
        fx();
        fH();
        this.RB.bx(6);
        this.QP.eF();
        this.RB.SH = this.QU.getItemCount();
        this.RB.SJ = 0;
        this.RB.SL = false;
        this.QV.c(this.QN, this.RB);
        this.RB.SK = false;
        this.QO = null;
        q qVar = this.RB;
        if (!this.RB.SM || this.Rr == null) {
            z = false;
        } else {
            z = true;
        }
        qVar.SM = z;
        this.RB.SF = 4;
        fI();
        R(false);
    }

    private void a(t tVar, c cVar) {
        tVar.setFlags(0, 8192);
        if (this.RB.SO && tVar.gz() && !tVar.isRemoved() && !tVar.gk()) {
            this.QR.a(g(tVar), tVar);
        }
        this.QR.b(tVar, cVar);
    }

    private void e(int[] iArr) {
        int childCount = this.QQ.getChildCount();
        if (childCount == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            int gl;
            t aY = aY(this.QQ.getChildAt(i3));
            if (!aY.gk()) {
                gl = aY.gl();
                if (gl < i) {
                    i = gl;
                }
                if (gl > i2) {
                    i3++;
                    i2 = gl;
                }
            }
            gl = i2;
            i3++;
            i2 = gl;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    protected void removeDetachedView(View view, boolean z) {
        t aY = aY(view);
        if (aY != null) {
            if (aY.gu()) {
                aY.gr();
            } else if (!aY.gk()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + aY);
            }
        }
        bc(view);
        super.removeDetachedView(view, z);
    }

    private long g(t tVar) {
        return this.QU.RS ? tVar.SW : (long) tVar.mPosition;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e.beginSection("RV OnLayout");
        fO();
        e.endSection();
        this.Rc = true;
    }

    public void requestLayout() {
        if (this.Rd != 0 || this.Rf) {
            this.Re = true;
        } else {
            super.requestLayout();
        }
    }

    public final void fR() {
        int i = 0;
        int eO = this.QQ.eO();
        for (int i2 = 0; i2 < eO; i2++) {
            ((LayoutParams) this.QQ.aW(i2).getLayoutParams()).Si = true;
        }
        m mVar = this.QN;
        eO = mVar.Sp.size();
        while (i < eO) {
            LayoutParams layoutParams = (LayoutParams) ((t) mVar.Sp.get(i)).SU.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.Si = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.QX.size();
        for (i = 0; i < size; i++) {
            ((g) this.QX.get(i)).a(canvas, this);
        }
        if (this.Rn == null || this.Rn.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.QS ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.Rn == null || !this.Rn.draw(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.Ro == null || this.Ro.isFinished())) {
            size = canvas.save();
            if (this.QS) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.Ro == null || !this.Ro.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Rp == null || this.Rp.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            if (this.QS) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.Rp == null || !this.Rp.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Rq == null || this.Rq.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.QS) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.Rq != null && this.Rq.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.Rr == null || this.QX.size() <= 0 || !this.Rr.isRunning()) {
            i3 = i2;
        }
        if (i3 != 0) {
            z.E(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.QX.size();
        for (int i = 0; i < size; i++) {
            ((g) this.QX.get(i)).a(canvas, this, this.RB);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.QV.a((LayoutParams) layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.QV != null) {
            return this.QV.eV();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.QV != null) {
            return this.QV.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.QV != null) {
            return this.QV.e(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void fS() {
        int i = 0;
        int eO = this.QQ.eO();
        for (int i2 = 0; i2 < eO; i2++) {
            t aY = aY(this.QQ.aW(i2));
            if (!aY.gk()) {
                aY.gj();
            }
        }
        m mVar = this.QN;
        int size = mVar.Sp.size();
        for (eO = 0; eO < size; eO++) {
            ((t) mVar.Sp.get(eO)).gj();
        }
        size = mVar.Sn.size();
        for (eO = 0; eO < size; eO++) {
            ((t) mVar.Sn.get(eO)).gj();
        }
        if (mVar.So != null) {
            eO = mVar.So.size();
            while (i < eO) {
                ((t) mVar.So.get(i)).gj();
                i++;
            }
        }
    }

    final void d(int i, int i2, boolean z) {
        int i3 = i + i2;
        int eO = this.QQ.eO();
        for (int i4 = 0; i4 < eO; i4++) {
            t aY = aY(this.QQ.aW(i4));
            if (!(aY == null || aY.gk())) {
                if (aY.mPosition >= i3) {
                    aY.o(-i2, z);
                    this.RB.SK = true;
                } else if (aY.mPosition >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    aY.addFlags(8);
                    aY.o(i6, z);
                    aY.mPosition = i5;
                    this.RB.SK = true;
                }
            }
        }
        m mVar = this.QN;
        int i7 = i + i2;
        for (i3 = mVar.Sp.size() - 1; i3 >= 0; i3--) {
            t tVar = (t) mVar.Sp.get(i3);
            if (tVar != null) {
                if (tVar.mPosition >= i7) {
                    tVar.o(-i2, z);
                } else if (tVar.mPosition >= i) {
                    tVar.addFlags(8);
                    mVar.bu(i3);
                }
            }
        }
        requestLayout();
    }

    private void fT() {
        int i;
        int eO = this.QQ.eO();
        for (i = 0; i < eO; i++) {
            t aY = aY(this.QQ.aW(i));
            if (!(aY == null || aY.gk())) {
                aY.addFlags(6);
            }
        }
        fR();
        m mVar = this.QN;
        if (mVar.RQ.QU == null || !mVar.RQ.QU.RS) {
            mVar.gf();
            return;
        }
        int size = mVar.Sp.size();
        for (i = 0; i < size; i++) {
            t tVar = (t) mVar.Sp.get(i);
            if (tVar != null) {
                tVar.addFlags(6);
                tVar.T(null);
            }
        }
    }

    public final t aP(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return aY(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static t aY(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).Sh;
    }

    public static int aZ(View view) {
        t aY = aY(view);
        return aY != null ? aY.gm() : -1;
    }

    public static int ba(View view) {
        t aY = aY(view);
        return aY != null ? aY.gl() : -1;
    }

    public final t bk(int i) {
        if (this.Rl) {
            return null;
        }
        int eO = this.QQ.eO();
        for (int i2 = 0; i2 < eO; i2++) {
            t aY = aY(this.QQ.aW(i2));
            if (aY != null && !aY.isRemoved() && h(aY) == i) {
                return aY;
            }
        }
        return null;
    }

    public final View u(float f, float f2) {
        for (int childCount = this.QQ.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.QQ.getChildAt(childCount);
            float Q = z.Q(childAt);
            float R = z.R(childAt);
            if (f >= ((float) childAt.getLeft()) + Q && f <= Q + ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) + R && f2 <= ((float) childAt.getBottom()) + R) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect bb(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.Si) {
            return layoutParams.OB;
        }
        Rect rect = layoutParams.OB;
        rect.set(0, 0, 0, 0);
        int size = this.QX.size();
        for (int i = 0; i < size; i++) {
            this.bJ.set(0, 0, 0, 0);
            ((g) this.QX.get(i)).a(this.bJ, view, this, this.RB);
            rect.left += this.bJ.left;
            rect.top += this.bJ.top;
            rect.right += this.bJ.right;
            rect.bottom += this.bJ.bottom;
        }
        layoutParams.Si = false;
        return rect;
    }

    final void W(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.RC != null) {
            this.RC.c(this, i, i2);
        }
        if (this.RD != null) {
            for (scrollY = this.RD.size() - 1; scrollY >= 0; scrollY--) {
                ((k) this.RD.get(scrollY)).c(this, i, i2);
            }
        }
    }

    private void fU() {
        int childCount = this.QQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.QQ.getChildAt(i);
            t aP = aP(childAt);
            if (!(aP == null || aP.Ta == null)) {
                View view = aP.Ta.SU;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void bc(View view) {
        aY(view);
        if (this.Rk != null) {
            for (int size = this.Rk.size() - 1; size >= 0; size--) {
                ((i) this.Rk.get(size)).bl(view);
            }
        }
    }

    private int h(t tVar) {
        if (tVar.by(524) || !tVar.isBound()) {
            return -1;
        }
        e eVar = this.QP;
        int i = tVar.mPosition;
        int size = eVar.LR.size();
        for (int i2 = 0; i2 < size; i2++) {
            e.b bVar = (e.b) eVar.LR.get(i2);
            switch (bVar.nc) {
                case 1:
                    if (bVar.LY > i) {
                        break;
                    }
                    i += bVar.Ma;
                    break;
                case 2:
                    if (bVar.LY <= i) {
                        if (bVar.LY + bVar.Ma <= i) {
                            i -= bVar.Ma;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.LY != i) {
                        if (bVar.LY < i) {
                            i--;
                        }
                        if (bVar.Ma > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = bVar.Ma;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().uU;
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public int getChildDrawingOrder(int i, int i2) {
        if (this.RJ == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.RJ.af(i, i2);
    }

    private q getScrollingChildHelper() {
        if (this.RL == null) {
            this.RL = new q(this);
        }
        return this.RL;
    }
}
