package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a$i;
import android.support.v4.os.b;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] vV = new int[]{16842931};
    private static final Comparator<b> vX = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).position - ((b) obj2).position;
        }
    };
    private static final Interpolator vY = new 2();
    private static final i wR = new i();
    private final ArrayList<b> bA = new ArrayList();
    private final Rect bJ = new Rect();
    private VelocityTracker cE;
    private int cF = -1;
    private boolean fU;
    private int fW;
    private int if = 0;
    private boolean mInLayout;
    private int vW;
    private final b vZ = new b();
    private float vm;
    private float vn;
    private int wA;
    private int wB;
    private boolean wC;
    private i wD;
    private i wE;
    private boolean wF = true;
    private boolean wG = false;
    private boolean wH;
    private int wI;
    public List<e> wJ;
    private e wK;
    private e wL;
    private d wM;
    private f wN;
    private Method wO;
    private int wP;
    private ArrayList<View> wQ;
    private final Runnable wS = new Runnable() {
        public final void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.cf();
        }
    };
    private u wa;
    private int wb;
    private int wc = -1;
    private Parcelable wd = null;
    private ClassLoader we = null;
    private Scroller wf;
    private boolean wg;
    private g wh;
    private int wi;
    private Drawable wj;
    private int wk;
    private int wl;
    private float wm = -3.4028235E38f;
    private float wn = Float.MAX_VALUE;
    private int wo;
    private int wp;
    private boolean wq;
    private boolean wr;
    private int ws = 1;
    private boolean wt;
    private int wu;
    private int wv;
    private float ww;
    private float wx;
    private int wy;
    private int wz;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = b.a(new 1());
        int position;
        Parcelable xa;
        ClassLoader xb;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.xa, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.xa = parcel.readParcelable(classLoader);
            this.xb = classLoader;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.wf = new Scroller(context2, vY);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.fW = ae.a(viewConfiguration);
        this.wy = (int) (400.0f * f);
        this.wz = viewConfiguration.getScaledMaximumFlingVelocity();
        this.wD = new i(context2);
        this.wE = new i(context2);
        this.wA = (int) (25.0f * f);
        this.wB = (int) (2.0f * f);
        this.wu = (int) (16.0f * f);
        z.a(this, new c(this));
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        z.b(this, new 4(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.wS);
        if (!(this.wf == null || this.wf.isFinished())) {
            this.wf.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        int i2 = 0;
        if (this.if != i) {
            this.if = i;
            if (this.wN != null) {
                int i3 = i != 0 ? 1 : 0;
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    z.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.wK != null) {
                this.wK.N(i);
            }
            if (this.wJ != null) {
                int size = this.wJ.size();
                while (i2 < size) {
                    e eVar = (e) this.wJ.get(i2);
                    if (eVar != null) {
                        eVar.N(i);
                    }
                    i2++;
                }
            }
            if (this.wL != null) {
                this.wL.N(i);
            }
        }
    }

    public void setAdapter(u uVar) {
        if (this.wa != null) {
            int i;
            this.wa.a(null);
            for (i = 0; i < this.bA.size(); i++) {
                b bVar = (b) this.bA.get(i);
                this.wa.a(this, bVar.position, bVar.object);
            }
            this.wa.bo();
            this.bA.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).wX) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.wb = 0;
            scrollTo(0, 0);
        }
        u uVar2 = this.wa;
        this.wa = uVar;
        this.vW = 0;
        if (this.wa != null) {
            if (this.wh == null) {
                this.wh = new g(this, (byte) 0);
            }
            this.wa.a(this.wh);
            this.wr = false;
            boolean z = this.wF;
            this.wF = true;
            this.vW = this.wa.getCount();
            if (this.wc >= 0) {
                this.wa.a(this.wd, this.we);
                a(this.wc, false, true);
                this.wc = -1;
                this.wd = null;
                this.we = null;
            } else if (z) {
                requestLayout();
            } else {
                cf();
            }
        }
        if (this.wM != null && uVar2 != uVar) {
            this.wM.b(uVar2, uVar);
        }
    }

    public u getAdapter() {
        return this.wa;
    }

    void setOnAdapterChangeListener(d dVar) {
        this.wM = dVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.wr = false;
        if (this.wF) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void k(int i, boolean z) {
        this.wr = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.wb;
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.wa == null || this.wa.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.wb != i || this.bA.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.wa.getCount()) {
                i = this.wa.getCount() - 1;
            }
            int i3 = this.ws;
            if (i > this.wb + i3 || i < this.wb - i3) {
                for (int i4 = 0; i4 < this.bA.size(); i4++) {
                    ((b) this.bA.get(i4)).wU = true;
                }
            }
            if (this.wb != i) {
                z3 = true;
            }
            if (this.wF) {
                this.wb = i;
                if (z3) {
                    ao(i);
                }
                requestLayout();
                return;
            }
            al(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int clientWidth;
        b am = am(i);
        if (am != null) {
            clientWidth = (int) (((float) getClientWidth()) * Math.max(this.wm, Math.min(am.wW, this.wn)));
        } else {
            clientWidth = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.wf == null || this.wf.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.wg ? this.wf.getCurrX() : this.wf.getStartX();
                    this.wf.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                clientWidth -= i3;
                int i4 = 0 - scrollY;
                if (clientWidth == 0 && i4 == 0) {
                    x(false);
                    cf();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    currX = getClientWidth();
                    int i5 = currX / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(clientWidth))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    i5 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(clientWidth)) / ((((float) currX) * this.wa.ak(this.wb)) + ((float) this.wi))) + 1.0f) * 100.0f), 600);
                    this.wg = false;
                    this.wf.startScroll(i3, scrollY, clientWidth, i4, i5);
                    z.E(this);
                }
            }
            if (z2) {
                ao(i);
                return;
            }
            return;
        }
        if (z2) {
            ao(i);
        }
        x(false);
        scrollTo(clientWidth, 0);
        an(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.wK = eVar;
    }

    public final void a(e eVar) {
        if (this.wJ == null) {
            this.wJ = new ArrayList();
        }
        this.wJ.add(eVar);
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.wO == null) {
                try {
                    this.wO = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                }
            }
            try {
                this.wO.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.wP == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.wQ.get(i2)).getLayoutParams()).wZ;
    }

    final e b(e eVar) {
        e eVar2 = this.wL;
        this.wL = eVar;
        return eVar2;
    }

    public int getOffscreenPageLimit() {
        return this.ws;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i).append(" too small; defaulting to 1");
            i = 1;
        }
        if (i != this.ws) {
            this.ws = i;
            cf();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.wi;
        this.wi = i;
        int width = getWidth();
        e(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.wi;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.wj = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.wj;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.wj;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private b q(int i, int i2) {
        b bVar = new b();
        bVar.position = i;
        bVar.object = this.wa.b(this, i);
        bVar.wV = this.wa.ak(i);
        if (i2 < 0 || i2 >= this.bA.size()) {
            this.bA.add(bVar);
        } else {
            this.bA.add(i2, bVar);
        }
        return bVar;
    }

    final void ce() {
        int i;
        int count = this.wa.getCount();
        this.vW = count;
        int i2 = (this.bA.size() >= (this.ws * 2) + 1 || this.bA.size() >= count) ? 0 : 1;
        int i3 = this.wb;
        int i4 = 0;
        boolean z = false;
        while (true) {
            i = i2;
            if (i4 >= this.bA.size()) {
                break;
            }
            b bVar = (b) this.bA.get(i4);
            int k = this.wa.k(bVar.object);
            if (k != -1) {
                boolean z2;
                if (k == -2) {
                    this.bA.remove(i4);
                    i4--;
                    if (!z) {
                        z = true;
                    }
                    this.wa.a(this, bVar.position, bVar.object);
                    if (this.wb == bVar.position) {
                        i3 = Math.max(0, Math.min(this.wb, count - 1));
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                } else if (bVar.position != k) {
                    if (bVar.position == this.wb) {
                        i3 = k;
                    }
                    bVar.position = k;
                    z2 = true;
                }
            }
            i2 = i4 + 1;
        }
        if (z) {
            this.wa.bo();
        }
        Collections.sort(this.bA, vX);
        if (i != 0) {
            int childCount = getChildCount();
            for (i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                if (!layoutParams.wX) {
                    layoutParams.wV = 0.0f;
                }
            }
            a(i3, false, true);
            requestLayout();
        }
    }

    final void cf() {
        al(this.wb);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void al(int r14) {
        /*
        r13 = this;
        r0 = 0;
        r1 = r13.wb;
        if (r1 == r14) goto L_0x028d;
    L_0x0005:
        r0 = r13.wb;
        r0 = r13.am(r0);
        r13.wb = r14;
        r1 = r0;
    L_0x000e:
        r0 = r13.wa;
        if (r0 != 0) goto L_0x0016;
    L_0x0012:
        r13.cg();
    L_0x0015:
        return;
    L_0x0016:
        r0 = r13.wr;
        if (r0 == 0) goto L_0x001e;
    L_0x001a:
        r13.cg();
        goto L_0x0015;
    L_0x001e:
        r0 = r13.getWindowToken();
        if (r0 == 0) goto L_0x0015;
    L_0x0024:
        r0 = r13.ws;
        r2 = 0;
        r3 = r13.wb;
        r3 = r3 - r0;
        r9 = java.lang.Math.max(r2, r3);
        r2 = r13.wa;
        r10 = r2.getCount();
        r2 = r10 + -1;
        r3 = r13.wb;
        r0 = r0 + r3;
        r11 = java.lang.Math.min(r2, r0);
        r0 = r13.vW;
        if (r10 == r0) goto L_0x00a5;
    L_0x0041:
        r0 = r13.getResources();	 Catch:{ NotFoundException -> 0x009b }
        r1 = r13.getId();	 Catch:{ NotFoundException -> 0x009b }
        r0 = r0.getResourceName(r1);	 Catch:{ NotFoundException -> 0x009b }
    L_0x004d:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r3 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r2.<init>(r3);
        r3 = r13.vW;
        r2 = r2.append(r3);
        r3 = ", found: ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r3 = " Pager id: ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = " Pager class: ";
        r0 = r0.append(r2);
        r2 = r13.getClass();
        r0 = r0.append(r2);
        r2 = " Problematic adapter: ";
        r0 = r0.append(r2);
        r2 = r13.wa;
        r2 = r2.getClass();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x009b:
        r0 = move-exception;
        r0 = r13.getId();
        r0 = java.lang.Integer.toHexString(r0);
        goto L_0x004d;
    L_0x00a5:
        r3 = 0;
        r0 = 0;
        r2 = r0;
    L_0x00a8:
        r0 = r13.bA;
        r0 = r0.size();
        if (r2 >= r0) goto L_0x028a;
    L_0x00b0:
        r0 = r13.bA;
        r0 = r0.get(r2);
        r0 = (android.support.v4.view.ViewPager.b) r0;
        r4 = r0.position;
        r5 = r13.wb;
        if (r4 < r5) goto L_0x011b;
    L_0x00be:
        r4 = r0.position;
        r5 = r13.wb;
        if (r4 != r5) goto L_0x028a;
    L_0x00c4:
        if (r0 != 0) goto L_0x0287;
    L_0x00c6:
        if (r10 <= 0) goto L_0x0287;
    L_0x00c8:
        r0 = r13.wb;
        r0 = r13.q(r0, r2);
        r8 = r0;
    L_0x00cf:
        if (r8 == 0) goto L_0x0205;
    L_0x00d1:
        r5 = 0;
        r4 = r2 + -1;
        if (r4 < 0) goto L_0x011f;
    L_0x00d6:
        r0 = r13.bA;
        r0 = r0.get(r4);
        r0 = (android.support.v4.view.ViewPager.b) r0;
    L_0x00de:
        r12 = r13.getClientWidth();
        if (r12 > 0) goto L_0x0121;
    L_0x00e4:
        r3 = 0;
    L_0x00e5:
        r6 = r13.wb;
        r7 = r6 + -1;
        r6 = r2;
    L_0x00ea:
        if (r7 < 0) goto L_0x0162;
    L_0x00ec:
        r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r2 < 0) goto L_0x0131;
    L_0x00f0:
        if (r7 >= r9) goto L_0x0131;
    L_0x00f2:
        if (r0 == 0) goto L_0x0162;
    L_0x00f4:
        r2 = r0.position;
        if (r7 != r2) goto L_0x0284;
    L_0x00f8:
        r2 = r0.wU;
        if (r2 != 0) goto L_0x0284;
    L_0x00fc:
        r2 = r13.bA;
        r2.remove(r4);
        r2 = r13.wa;
        r0 = r0.object;
        r2.a(r13, r7, r0);
        r2 = r4 + -1;
        r4 = r6 + -1;
        if (r2 < 0) goto L_0x012f;
    L_0x010e:
        r0 = r13.bA;
        r0 = r0.get(r2);
        r0 = (android.support.v4.view.ViewPager.b) r0;
    L_0x0116:
        r6 = r4;
    L_0x0117:
        r7 = r7 + -1;
        r4 = r2;
        goto L_0x00ea;
    L_0x011b:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x00a8;
    L_0x011f:
        r0 = 0;
        goto L_0x00de;
    L_0x0121:
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r8.wV;
        r3 = r3 - r6;
        r6 = r13.getPaddingLeft();
        r6 = (float) r6;
        r7 = (float) r12;
        r6 = r6 / r7;
        r3 = r3 + r6;
        goto L_0x00e5;
    L_0x012f:
        r0 = 0;
        goto L_0x0116;
    L_0x0131:
        if (r0 == 0) goto L_0x0149;
    L_0x0133:
        r2 = r0.position;
        if (r7 != r2) goto L_0x0149;
    L_0x0137:
        r0 = r0.wV;
        r5 = r5 + r0;
        r2 = r4 + -1;
        if (r2 < 0) goto L_0x0147;
    L_0x013e:
        r0 = r13.bA;
        r0 = r0.get(r2);
        r0 = (android.support.v4.view.ViewPager.b) r0;
        goto L_0x0117;
    L_0x0147:
        r0 = 0;
        goto L_0x0117;
    L_0x0149:
        r0 = r4 + 1;
        r0 = r13.q(r7, r0);
        r0 = r0.wV;
        r5 = r5 + r0;
        r6 = r6 + 1;
        if (r4 < 0) goto L_0x0160;
    L_0x0156:
        r0 = r13.bA;
        r0 = r0.get(r4);
        r0 = (android.support.v4.view.ViewPager.b) r0;
    L_0x015e:
        r2 = r4;
        goto L_0x0117;
    L_0x0160:
        r0 = 0;
        goto L_0x015e;
    L_0x0162:
        r3 = r8.wV;
        r4 = r6 + 1;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0202;
    L_0x016c:
        r0 = r13.bA;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x01b8;
    L_0x0174:
        r0 = r13.bA;
        r0 = r0.get(r4);
        r0 = (android.support.v4.view.ViewPager.b) r0;
        r5 = r0;
    L_0x017d:
        if (r12 > 0) goto L_0x01ba;
    L_0x017f:
        r0 = 0;
        r2 = r0;
    L_0x0181:
        r0 = r13.wb;
        r7 = r0 + 1;
        r0 = r5;
    L_0x0186:
        if (r7 >= r10) goto L_0x0202;
    L_0x0188:
        r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r5 < 0) goto L_0x01c8;
    L_0x018c:
        if (r7 <= r11) goto L_0x01c8;
    L_0x018e:
        if (r0 == 0) goto L_0x0202;
    L_0x0190:
        r5 = r0.position;
        if (r7 != r5) goto L_0x01b4;
    L_0x0194:
        r5 = r0.wU;
        if (r5 != 0) goto L_0x01b4;
    L_0x0198:
        r5 = r13.bA;
        r5.remove(r4);
        r5 = r13.wa;
        r0 = r0.object;
        r5.a(r13, r7, r0);
        r0 = r13.bA;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x01c6;
    L_0x01ac:
        r0 = r13.bA;
        r0 = r0.get(r4);
        r0 = (android.support.v4.view.ViewPager.b) r0;
    L_0x01b4:
        r5 = r7 + 1;
        r7 = r5;
        goto L_0x0186;
    L_0x01b8:
        r5 = 0;
        goto L_0x017d;
    L_0x01ba:
        r0 = r13.getPaddingRight();
        r0 = (float) r0;
        r2 = (float) r12;
        r0 = r0 / r2;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r0 + r2;
        r2 = r0;
        goto L_0x0181;
    L_0x01c6:
        r0 = 0;
        goto L_0x01b4;
    L_0x01c8:
        if (r0 == 0) goto L_0x01e6;
    L_0x01ca:
        r5 = r0.position;
        if (r7 != r5) goto L_0x01e6;
    L_0x01ce:
        r0 = r0.wV;
        r3 = r3 + r0;
        r4 = r4 + 1;
        r0 = r13.bA;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x01e4;
    L_0x01db:
        r0 = r13.bA;
        r0 = r0.get(r4);
        r0 = (android.support.v4.view.ViewPager.b) r0;
        goto L_0x01b4;
    L_0x01e4:
        r0 = 0;
        goto L_0x01b4;
    L_0x01e6:
        r0 = r13.q(r7, r4);
        r4 = r4 + 1;
        r0 = r0.wV;
        r3 = r3 + r0;
        r0 = r13.bA;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x0200;
    L_0x01f7:
        r0 = r13.bA;
        r0 = r0.get(r4);
        r0 = (android.support.v4.view.ViewPager.b) r0;
        goto L_0x01b4;
    L_0x0200:
        r0 = 0;
        goto L_0x01b4;
    L_0x0202:
        r13.a(r8, r6, r1);
    L_0x0205:
        r1 = r13.wa;
        if (r8 == 0) goto L_0x0244;
    L_0x0209:
        r0 = r8.object;
    L_0x020b:
        r1.e(r0);
        r0 = r13.wa;
        r0.bo();
        r2 = r13.getChildCount();
        r0 = 0;
        r1 = r0;
    L_0x0219:
        if (r1 >= r2) goto L_0x0246;
    L_0x021b:
        r3 = r13.getChildAt(r1);
        r0 = r3.getLayoutParams();
        r0 = (android.support.v4.view.ViewPager.LayoutParams) r0;
        r0.wZ = r1;
        r4 = r0.wX;
        if (r4 != 0) goto L_0x0240;
    L_0x022b:
        r4 = r0.wV;
        r5 = 0;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 != 0) goto L_0x0240;
    L_0x0232:
        r3 = r13.ao(r3);
        if (r3 == 0) goto L_0x0240;
    L_0x0238:
        r4 = r3.wV;
        r0.wV = r4;
        r3 = r3.position;
        r0.position = r3;
    L_0x0240:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0219;
    L_0x0244:
        r0 = 0;
        goto L_0x020b;
    L_0x0246:
        r13.cg();
        r0 = r13.hasFocus();
        if (r0 == 0) goto L_0x0015;
    L_0x024f:
        r0 = r13.findFocus();
        if (r0 == 0) goto L_0x0282;
    L_0x0255:
        r0 = r13.ap(r0);
    L_0x0259:
        if (r0 == 0) goto L_0x0261;
    L_0x025b:
        r0 = r0.position;
        r1 = r13.wb;
        if (r0 == r1) goto L_0x0015;
    L_0x0261:
        r0 = 0;
    L_0x0262:
        r1 = r13.getChildCount();
        if (r0 >= r1) goto L_0x0015;
    L_0x0268:
        r1 = r13.getChildAt(r0);
        r2 = r13.ao(r1);
        if (r2 == 0) goto L_0x027f;
    L_0x0272:
        r2 = r2.position;
        r3 = r13.wb;
        if (r2 != r3) goto L_0x027f;
    L_0x0278:
        r2 = 2;
        r1 = r1.requestFocus(r2);
        if (r1 != 0) goto L_0x0015;
    L_0x027f:
        r0 = r0 + 1;
        goto L_0x0262;
    L_0x0282:
        r0 = 0;
        goto L_0x0259;
    L_0x0284:
        r2 = r4;
        goto L_0x0117;
    L_0x0287:
        r8 = r0;
        goto L_0x00cf;
    L_0x028a:
        r0 = r3;
        goto L_0x00c4;
    L_0x028d:
        r1 = r0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.al(int):void");
    }

    private void cg() {
        if (this.wP != 0) {
            if (this.wQ == null) {
                this.wQ = new ArrayList();
            } else {
                this.wQ.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.wQ.add(getChildAt(i));
            }
            Collections.sort(this.wQ, wR);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        float f;
        b bVar3;
        int i2;
        int count = this.wa.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.wi) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            clientWidth = bVar2.position;
            float f2;
            int i3;
            int i4;
            Object obj;
            if (clientWidth < bVar.position) {
                f2 = (bVar2.wW + bVar2.wV) + f;
                i3 = clientWidth + 1;
                i4 = 0;
                while (i3 <= bVar.position && i4 < this.bA.size()) {
                    obj = this.bA.get(i4);
                    while (true) {
                        bVar3 = (b) obj;
                        if (i3 <= bVar3.position || i4 >= this.bA.size() - 1) {
                            while (i3 < bVar3.position) {
                                f2 += this.wa.ak(i3) + f;
                                i3++;
                            }
                        } else {
                            i4++;
                            obj = this.bA.get(i4);
                        }
                    }
                    while (i3 < bVar3.position) {
                        f2 += this.wa.ak(i3) + f;
                        i3++;
                    }
                    bVar3.wW = f2;
                    f2 += bVar3.wV + f;
                    i3++;
                }
            } else if (clientWidth > bVar.position) {
                i4 = this.bA.size() - 1;
                f2 = bVar2.wW;
                clientWidth--;
                while (true) {
                    i3 = clientWidth;
                    if (i3 < bVar.position || i4 < 0) {
                        break;
                    }
                    obj = this.bA.get(i4);
                    while (true) {
                        bVar3 = (b) obj;
                        if (i3 >= bVar3.position || i4 <= 0) {
                            while (i3 > bVar3.position) {
                                f2 -= this.wa.ak(i3) + f;
                                i3--;
                            }
                        } else {
                            i4--;
                            obj = this.bA.get(i4);
                        }
                    }
                    while (i3 > bVar3.position) {
                        f2 -= this.wa.ak(i3) + f;
                        i3--;
                    }
                    f2 -= bVar3.wV + f;
                    bVar3.wW = f2;
                    clientWidth = i3 - 1;
                }
            }
        }
        int size = this.bA.size();
        float f3 = bVar.wW;
        int i5 = bVar.position - 1;
        this.wm = bVar.position == 0 ? bVar.wW : -3.4028235E38f;
        this.wn = bVar.position == count + -1 ? (bVar.wW + bVar.wV) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bVar3 = (b) this.bA.get(i2);
            while (i5 > bVar3.position) {
                f3 -= this.wa.ak(i5) + f;
                i5--;
            }
            f3 -= bVar3.wV + f;
            bVar3.wW = f3;
            if (bVar3.position == 0) {
                this.wm = f3;
            }
            i5--;
        }
        f3 = (bVar.wW + bVar.wV) + f;
        i5 = bVar.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bVar3 = (b) this.bA.get(i2);
            while (i5 < bVar3.position) {
                f3 += this.wa.ak(i5) + f;
                i5++;
            }
            if (bVar3.position == count - 1) {
                this.wn = (bVar3.wV + f3) - 1.0f;
            }
            bVar3.wW = f3;
            f3 += bVar3.wV + f;
            i5++;
        }
        this.wG = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.wb;
        if (this.wa != null) {
            savedState.xa = this.wa.bp();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.wa != null) {
                this.wa.a(savedState.xa, savedState.xb);
                a(savedState.position, false, true);
                return;
            }
            this.wc = savedState.position;
            this.wd = savedState.xa;
            this.we = savedState.xb;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.wX |= view instanceof a;
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.wX) {
            layoutParams3.wY = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private b ao(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bA.size()) {
                return null;
            }
            b bVar = (b) this.bA.get(i2);
            if (this.wa.a(view, bVar.object)) {
                return bVar;
            }
            i = i2 + 1;
        }
    }

    private b ap(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return ao(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b am(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.bA.size()) {
                return null;
            }
            b bVar = (b) this.bA.get(i3);
            if (bVar.position == i) {
                return bVar;
            }
            i2 = i3 + 1;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.wF = true;
    }

    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.wv = Math.min(measuredWidth / 10, this.wu);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.wX) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & 112;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i6 = 1073741824;
                        i7 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = paddingLeft;
                        i6 = i3;
                    }
                    if (layoutParams.height != -2) {
                        i4 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i6), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i6), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.wo = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.wp = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        cf();
        this.mInLayout = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.wX) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.wV * ((float) paddingLeft)), 1073741824), this.wp);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            e(i, i3, this.wi, this.wi);
        }
    }

    private void e(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.bA.isEmpty()) {
            b am = am(this.wb);
            int min = (int) ((am != null ? Math.min(am.wW, this.wn) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                x(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.wf.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.wf.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int i5;
        int childCount = getChildCount();
        int i6 = i3 - i;
        int i7 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            int i10;
            int max2;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.wX) {
                    int i11 = layoutParams.gravity & 112;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i6 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i5 = paddingRight;
                            i10 = paddingLeft;
                            break;
                        case 3:
                            i10 = paddingLeft + childAt.getMeasuredWidth();
                            max = paddingLeft;
                            i5 = paddingRight;
                            break;
                        case 5:
                            max = (i6 - paddingRight) - childAt.getMeasuredWidth();
                            i5 = paddingRight + childAt.getMeasuredWidth();
                            i10 = paddingLeft;
                            break;
                        default:
                            max = paddingLeft;
                            i5 = paddingRight;
                            i10 = paddingLeft;
                            break;
                    }
                    switch (i11) {
                        case 16:
                            max2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            paddingRight = paddingTop;
                            break;
                        case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                            paddingRight = paddingTop + childAt.getMeasuredHeight();
                            max2 = paddingTop;
                            break;
                        case 80:
                            max2 = (i7 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            paddingRight = paddingTop;
                            break;
                        default:
                            max2 = paddingTop;
                            paddingRight = paddingTop;
                            break;
                    }
                    paddingTop = max + scrollX;
                    childAt.layout(paddingTop, max2, childAt.getMeasuredWidth() + paddingTop, childAt.getMeasuredHeight() + max2);
                    max2 = i8 + 1;
                    paddingTop = paddingRight;
                    i9++;
                    i8 = max2;
                    paddingRight = i5;
                    paddingLeft = i10;
                }
            }
            max2 = i8;
            i5 = paddingRight;
            i10 = paddingLeft;
            i9++;
            i8 = max2;
            paddingRight = i5;
            paddingLeft = i10;
        }
        i5 = (i6 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.wX) {
                    b ao = ao(childAt2);
                    if (ao != null) {
                        max = ((int) (ao.wW * ((float) i5))) + paddingLeft;
                        if (layoutParams.wY) {
                            layoutParams.wY = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.wV * ((float) i5)), 1073741824), MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(max, paddingTop, childAt2.getMeasuredWidth() + max, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.wk = paddingTop;
        this.wl = i7 - paddingBottom;
        this.wI = i8;
        if (this.wF) {
            a(this.wb, false, 0, false);
        }
        this.wF = false;
    }

    public void computeScroll() {
        this.wg = true;
        if (this.wf.isFinished() || !this.wf.computeScrollOffset()) {
            x(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.wf.getCurrX();
        int currY = this.wf.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!an(currX)) {
                this.wf.abortAnimation();
                scrollTo(0, currY);
            }
        }
        z.E(this);
    }

    private boolean an(int i) {
        if (this.bA.size() != 0) {
            b cj = cj();
            int clientWidth = getClientWidth();
            int i2 = this.wi + clientWidth;
            float f = ((float) this.wi) / ((float) clientWidth);
            int i3 = cj.position;
            float f2 = ((((float) i) / ((float) clientWidth)) - cj.wW) / (cj.wV + f);
            clientWidth = (int) (((float) i2) * f2);
            this.wH = false;
            a(i3, f2, clientWidth);
            if (this.wH) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.wF) {
            return false;
        } else {
            this.wH = false;
            a(0, 0.0f, 0);
            if (this.wH) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.wI > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.wX) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i3 = paddingLeft;
                            break;
                        case 3:
                            i3 = paddingLeft + childAt.getWidth();
                            max = paddingLeft;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            break;
                        default:
                            max = paddingLeft;
                            i3 = paddingLeft;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i3 = paddingLeft;
                }
                i4++;
                paddingLeft = i3;
            }
        }
        if (this.wK != null) {
            this.wK.a(i, f, i2);
        }
        if (this.wJ != null) {
            paddingRight = this.wJ.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                e eVar = (e) this.wJ.get(paddingLeft);
                if (eVar != null) {
                    eVar.a(i, f, i2);
                }
            }
        }
        if (this.wL != null) {
            this.wL.a(i, f, i2);
        }
        if (this.wN != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).wX) {
                    this.wN.h(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.wH = true;
    }

    private void ao(int i) {
        if (this.wK != null) {
            this.wK.O(i);
        }
        if (this.wJ != null) {
            int size = this.wJ.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.wJ.get(i2);
                if (eVar != null) {
                    eVar.O(i);
                }
            }
        }
        if (this.wL != null) {
            this.wL.O(i);
        }
    }

    private void x(boolean z) {
        int scrollX;
        int scrollY;
        int i = this.if == 2 ? 1 : 0;
        if (i != 0) {
            boolean z2;
            setScrollingCacheEnabled(false);
            if (this.wf.isFinished()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.wf.abortAnimation();
                scrollX = getScrollX();
                scrollY = getScrollY();
                int currX = this.wf.getCurrX();
                int currY = this.wf.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        an(currX);
                    }
                }
            }
        }
        this.wr = false;
        scrollX = 0;
        while (true) {
            scrollY = i;
            if (scrollX >= this.bA.size()) {
                break;
            }
            b bVar = (b) this.bA.get(scrollX);
            if (bVar.wU) {
                bVar.wU = false;
                scrollY = 1;
            }
            i = scrollX + 1;
        }
        if (scrollY == 0) {
            return;
        }
        if (z) {
            z.a(this, this.wS);
        } else {
            this.wS.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (action == 3 || action == 1) {
            ch();
            return false;
        }
        if (action != 0) {
            if (this.fU) {
                return true;
            }
            if (this.wt) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.vm = x;
                this.ww = x;
                x = motionEvent.getY();
                this.vn = x;
                this.wx = x;
                this.cF = o.c(motionEvent, 0);
                this.wt = false;
                this.wg = true;
                this.wf.computeScrollOffset();
                if (this.if == 2 && Math.abs(this.wf.getFinalX() - this.wf.getCurrX()) > this.wB) {
                    this.wf.abortAnimation();
                    this.wr = false;
                    cf();
                    this.fU = true;
                    ci();
                    setScrollState(1);
                    break;
                }
                x(false);
                this.fU = false;
                break;
                break;
            case 2:
                action = this.cF;
                if (action != -1) {
                    action = o.b(motionEvent, action);
                    float d = o.d(motionEvent, action);
                    float f = d - this.ww;
                    float abs = Math.abs(f);
                    float e = o.e(motionEvent, action);
                    float abs2 = Math.abs(e - this.vn);
                    if (f != 0.0f) {
                        x = this.ww;
                        boolean z = (x < ((float) this.wv) && f > 0.0f) || (x > ((float) (getWidth() - this.wv)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) d, (int) e)) {
                            this.ww = d;
                            this.wx = e;
                            this.wt = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.fW) && 0.5f * abs > abs2) {
                        this.fU = true;
                        ci();
                        setScrollState(1);
                        this.ww = f > 0.0f ? this.vm + ((float) this.fW) : this.vm - ((float) this.fW);
                        this.wx = e;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.fW)) {
                        this.wt = true;
                    }
                    if (this.fU && s(d)) {
                        z.E(this);
                        break;
                    }
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        return this.fU;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.wC) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.wa == null || this.wa.getCount() == 0) {
            return false;
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                this.wf.abortAnimation();
                this.wr = false;
                cf();
                x = motionEvent.getX();
                this.vm = x;
                this.ww = x;
                x = motionEvent.getY();
                this.vn = x;
                this.wx = x;
                this.cF = o.c(motionEvent, 0);
                break;
            case 1:
                if (this.fU) {
                    VelocityTracker velocityTracker = this.cE;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.wz);
                    int a = (int) y.a(velocityTracker, this.cF);
                    this.wr = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b cj = cj();
                    float f2 = ((float) this.wi) / ((float) clientWidth);
                    i = cj.position;
                    f = ((((float) scrollX) / ((float) clientWidth)) - cj.wW) / (cj.wV + f2);
                    if (Math.abs((int) (o.d(motionEvent, o.b(motionEvent, this.cF)) - this.vm)) <= this.wA || Math.abs(a) <= this.wy) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.wb ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.bA.size() > 0) {
                        scrollX = Math.max(((b) this.bA.get(0)).position, Math.min(scrollX, ((b) this.bA.get(this.bA.size() - 1)).position));
                    }
                    a(scrollX, true, true, a);
                    z = ch();
                    break;
                }
                break;
            case 2:
                if (!this.fU) {
                    i = o.b(motionEvent, this.cF);
                    if (i == -1) {
                        z = ch();
                        break;
                    }
                    float d = o.d(motionEvent, i);
                    f = Math.abs(d - this.ww);
                    float e = o.e(motionEvent, i);
                    x = Math.abs(e - this.wx);
                    if (f > ((float) this.fW) && f > x) {
                        this.fU = true;
                        ci();
                        if (d - this.vm > 0.0f) {
                            x = this.vm + ((float) this.fW);
                        } else {
                            x = this.vm - ((float) this.fW);
                        }
                        this.ww = x;
                        this.wx = e;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.fU) {
                    z = s(o.d(motionEvent, o.b(motionEvent, this.cF))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.fU) {
                    a(this.wb, true, 0, false);
                    z = ch();
                    break;
                }
                break;
            case 5:
                i = o.e(motionEvent);
                this.ww = o.d(motionEvent, i);
                this.cF = o.c(motionEvent, i);
                break;
            case 6:
                h(motionEvent);
                this.ww = o.d(motionEvent, o.b(motionEvent, this.cF));
                break;
        }
        if (z) {
            z.E(this);
        }
        return true;
    }

    private boolean ch() {
        this.cF = -1;
        this.fU = false;
        this.wt = false;
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
        return this.wD.cI() | this.wE.cI();
    }

    private void ci() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean s(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.ww - f;
        this.ww = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.wm;
        float f5 = ((float) clientWidth) * this.wn;
        b bVar = (b) this.bA.get(0);
        b bVar2 = (b) this.bA.get(this.bA.size() - 1);
        if (bVar.position != 0) {
            f4 = ((float) clientWidth) * bVar.wW;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.wa.getCount() - 1) {
            f2 = bVar2.wW * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.wD.A(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.wE.A(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.ww += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        an((int) f4);
        return z3;
    }

    private b cj() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.wi) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        int i = -1;
        Object obj = 1;
        int i2 = 0;
        b bVar = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.bA.size()) {
            b bVar2;
            b bVar3 = (b) this.bA.get(i2);
            if (obj != null || bVar3.position == i + 1) {
                bVar2 = bVar3;
            } else {
                bVar3 = this.vZ;
                bVar3.wW = (f3 + f2) + f;
                bVar3.position = i + 1;
                bVar3.wV = this.wa.ak(bVar3.position);
                i2--;
                bVar2 = bVar3;
            }
            f3 = bVar2.wW;
            float f4 = (bVar2.wV + f3) + f;
            if (obj == null && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f4 || i2 == this.bA.size() - 1) {
                return bVar2;
            }
            i = bVar2.position;
            f2 = bVar2.wV;
            i2++;
            bVar = bVar2;
            obj = null;
        }
        return bVar;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int B = z.B(this);
        if (B == 0 || (B == 1 && this.wa != null && this.wa.getCount() > 1)) {
            int width;
            if (!this.wD.isFinished()) {
                B = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.wm * ((float) width));
                this.wD.setSize(i, width);
                i = this.wD.draw(canvas) | 0;
                canvas.restoreToCount(B);
            }
            if (!this.wE.isFinished()) {
                B = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.wn + 1.0f)) * ((float) width));
                this.wE.setSize(height, width);
                i |= this.wE.draw(canvas);
                canvas.restoreToCount(B);
            }
        } else {
            this.wD.finish();
            this.wE.finish();
        }
        if (i != 0) {
            z.E(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.wi > 0 && this.wj != null && this.bA.size() > 0 && this.wa != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.wi) / ((float) width);
            b bVar = (b) this.bA.get(0);
            float f2 = bVar.wW;
            int size = this.bA.size();
            int i = bVar.position;
            int i2 = ((b) this.bA.get(size - 1)).position;
            int i3 = i;
            int i4 = 0;
            while (i3 < i2) {
                float f3;
                while (i3 > bVar.position && i4 < size) {
                    i4++;
                    bVar = (b) this.bA.get(i4);
                }
                if (i3 == bVar.position) {
                    f3 = (bVar.wW + bVar.wV) * ((float) width);
                    f2 = (bVar.wW + bVar.wV) + f;
                } else {
                    float ak = this.wa.ak(i3);
                    f3 = (f2 + ak) * ((float) width);
                    f2 += ak + f;
                }
                if (((float) this.wi) + f3 > ((float) scrollX)) {
                    this.wj.setBounds(Math.round(f3), this.wk, Math.round(((float) this.wi) + f3), this.wl);
                    this.wj.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.cF) {
            e = e == 0 ? 1 : 0;
            this.ww = o.d(motionEvent, e);
            this.cF = o.c(motionEvent, e);
            if (this.cE != null) {
                this.cE.clear();
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.wq != z) {
            this.wq = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.wa == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.wm))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.wn))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && z.g(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.view.g.a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.g.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.arrowScroll(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 66;
        r7 = 17;
        r4 = 0;
        r3 = 1;
        r2 = r9.findFocus();
        if (r2 != r9) goto L_0x003f;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r1 = android.view.FocusFinder.getInstance();
        r1 = r1.findNextFocus(r9, r0, r10);
        if (r1 == 0) goto L_0x00b4;
    L_0x0018:
        if (r1 == r0) goto L_0x00b4;
    L_0x001a:
        if (r10 != r7) goto L_0x0099;
    L_0x001c:
        r2 = r9.bJ;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.bJ;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x0094;
    L_0x002e:
        if (r2 < r3) goto L_0x0094;
    L_0x0030:
        r0 = r9.ck();
    L_0x0034:
        r4 = r0;
    L_0x0035:
        if (r4 == 0) goto L_0x003e;
    L_0x0037:
        r0 = android.view.SoundEffectConstants.getContantForFocusDirection(r10);
        r9.playSoundEffect(r0);
    L_0x003e:
        return r4;
    L_0x003f:
        if (r2 == 0) goto L_0x00e0;
    L_0x0041:
        r0 = r2.getParent();
    L_0x0045:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x00e3;
    L_0x0049:
        if (r0 != r9) goto L_0x007d;
    L_0x004b:
        r0 = r3;
    L_0x004c:
        if (r0 != 0) goto L_0x00e0;
    L_0x004e:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        r5.append(r0);
        r0 = r2.getParent();
    L_0x0062:
        r2 = r0 instanceof android.view.ViewGroup;
        if (r2 == 0) goto L_0x0082;
    L_0x0066:
        r2 = " => ";
        r2 = r5.append(r2);
        r6 = r0.getClass();
        r6 = r6.getSimpleName();
        r2.append(r6);
        r0 = r0.getParent();
        goto L_0x0062;
    L_0x007d:
        r0 = r0.getParent();
        goto L_0x0045;
    L_0x0082:
        r0 = new java.lang.StringBuilder;
        r2 = "arrowScroll tried to find focus based on non-child current focused view ";
        r0.<init>(r2);
        r2 = r5.toString();
        r0.append(r2);
        r0 = r1;
        goto L_0x000e;
    L_0x0094:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x0099:
        if (r10 != r8) goto L_0x0035;
    L_0x009b:
        r2 = r9.bJ;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r5 = r9.bJ;
        r5 = r9.a(r5, r0);
        r5 = r5.left;
        if (r0 == 0) goto L_0x00af;
    L_0x00ad:
        if (r2 <= r5) goto L_0x00c3;
    L_0x00af:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x00b4:
        if (r10 == r7) goto L_0x00b8;
    L_0x00b6:
        if (r10 != r3) goto L_0x00be;
    L_0x00b8:
        r0 = r9.ck();
        goto L_0x0034;
    L_0x00be:
        if (r10 == r8) goto L_0x00c3;
    L_0x00c0:
        r0 = 2;
        if (r10 != r0) goto L_0x0035;
    L_0x00c3:
        r0 = r9.wa;
        if (r0 == 0) goto L_0x00dd;
    L_0x00c7:
        r0 = r9.wb;
        r1 = r9.wa;
        r1 = r1.getCount();
        r1 = r1 + -1;
        if (r0 >= r1) goto L_0x00dd;
    L_0x00d3:
        r0 = r9.wb;
        r0 = r0 + 1;
        r9.k(r0, r3);
        r0 = r3;
        goto L_0x0034;
    L_0x00dd:
        r0 = r4;
        goto L_0x0034;
    L_0x00e0:
        r0 = r2;
        goto L_0x000e;
    L_0x00e3:
        r0 = r4;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.arrowScroll(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean ck() {
        if (this.wb <= 0) {
            return false;
        }
        k(this.wb - 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b ao = ao(childAt);
                    if (ao != null && ao.position == this.wb) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.wb) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            childCount = -1;
            i2 = -1;
        }
        while (i3 != childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.wb && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i3 += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.wb && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
