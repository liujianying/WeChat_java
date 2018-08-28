package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ai;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.k;
import android.support.v4.widget.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ListPopupWindow {
    private static Method PI;
    private static Method PJ;
    private ListAdapter Do;
    public int Jh;
    public int MU;
    private int OK;
    public PopupWindow PK;
    public a PL;
    public int PM;
    int PN;
    int PO;
    private int PP;
    boolean PQ;
    private boolean PR;
    private boolean PS;
    int PT;
    private View PU;
    int PV;
    public View PW;
    private Drawable PX;
    public OnItemClickListener PY;
    private OnItemSelectedListener PZ;
    private final g Qa;
    private final f Qb;
    private final e Qc;
    private final c Qd;
    private Runnable Qe;
    private boolean Qf;
    private Rect bJ;
    private Context mContext;
    private final Handler mHandler;
    private DataSetObserver mObserver;

    public static abstract class b implements OnTouchListener {
        private final float Qm;
        private final int Qn;
        private final int Qo;
        private final View Qp;
        private Runnable Qq;
        private Runnable Qr;
        private boolean Qs;
        private boolean Qt;
        private final int[] Qu = new int[2];
        private int cF;

        private class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            public final void run() {
                b.this.Qp.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class b implements Runnable {
            private b() {
            }

            /* synthetic */ b(b bVar, byte b) {
                this();
            }

            public final void run() {
                b.b(b.this);
            }
        }

        public abstract ListPopupWindow dB();

        static /* synthetic */ void b(b bVar) {
            bVar.fq();
            View view = bVar.Qp;
            if (view.isEnabled() && !view.isLongClickable() && bVar.dC()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                bVar.Qs = true;
                bVar.Qt = true;
            }
        }

        public b(View view) {
            this.Qp = view;
            this.Qm = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.Qn = ViewConfiguration.getTapTimeout();
            this.Qo = (this.Qn + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
            r11 = this;
            r5 = 0;
            r8 = 1;
            r7 = 0;
            r10 = r11.Qs;
            if (r10 == 0) goto L_0x0027;
        L_0x0007:
            r0 = r11.Qt;
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r11.l(r13);
        L_0x000f:
            r11.Qs = r0;
            if (r0 != 0) goto L_0x0015;
        L_0x0013:
            if (r10 == 0) goto L_0x0016;
        L_0x0015:
            r7 = r8;
        L_0x0016:
            return r7;
        L_0x0017:
            r0 = r11.l(r13);
            if (r0 != 0) goto L_0x0023;
        L_0x001d:
            r0 = r11.em();
            if (r0 != 0) goto L_0x0025;
        L_0x0023:
            r0 = r8;
            goto L_0x000f;
        L_0x0025:
            r0 = r7;
            goto L_0x000f;
        L_0x0027:
            r1 = r11.Qp;
            r0 = r1.isEnabled();
            if (r0 == 0) goto L_0x0036;
        L_0x002f:
            r0 = android.support.v4.view.o.d(r13);
            switch(r0) {
                case 0: goto L_0x0057;
                case 1: goto L_0x00d2;
                case 2: goto L_0x0086;
                case 3: goto L_0x00d2;
                default: goto L_0x0036;
            };
        L_0x0036:
            r0 = r7;
        L_0x0037:
            if (r0 == 0) goto L_0x00d7;
        L_0x0039:
            r0 = r11.dC();
            if (r0 == 0) goto L_0x00d7;
        L_0x003f:
            r9 = r8;
        L_0x0040:
            if (r9 == 0) goto L_0x0055;
        L_0x0042:
            r0 = android.os.SystemClock.uptimeMillis();
            r4 = 3;
            r2 = r0;
            r6 = r5;
            r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);
            r1 = r11.Qp;
            r1.onTouchEvent(r0);
            r0.recycle();
        L_0x0055:
            r0 = r9;
            goto L_0x000f;
        L_0x0057:
            r0 = r13.getPointerId(r7);
            r11.cF = r0;
            r11.Qt = r7;
            r0 = r11.Qq;
            if (r0 != 0) goto L_0x006a;
        L_0x0063:
            r0 = new android.support.v7.widget.ListPopupWindow$b$a;
            r0.<init>(r11, r7);
            r11.Qq = r0;
        L_0x006a:
            r0 = r11.Qq;
            r2 = r11.Qn;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            r0 = r11.Qr;
            if (r0 != 0) goto L_0x007d;
        L_0x0076:
            r0 = new android.support.v7.widget.ListPopupWindow$b$b;
            r0.<init>(r11, r7);
            r11.Qr = r0;
        L_0x007d:
            r0 = r11.Qr;
            r2 = r11.Qo;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            goto L_0x0036;
        L_0x0086:
            r0 = r11.cF;
            r0 = r13.findPointerIndex(r0);
            if (r0 < 0) goto L_0x0036;
        L_0x008e:
            r2 = r13.getX(r0);
            r0 = r13.getY(r0);
            r3 = r11.Qm;
            r4 = -r3;
            r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x009d:
            r4 = -r3;
            r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x00a2:
            r4 = r1.getRight();
            r6 = r1.getLeft();
            r4 = r4 - r6;
            r4 = (float) r4;
            r4 = r4 + r3;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 >= 0) goto L_0x00d0;
        L_0x00b1:
            r2 = r1.getBottom();
            r4 = r1.getTop();
            r2 = r2 - r4;
            r2 = (float) r2;
            r2 = r2 + r3;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x00d0;
        L_0x00c0:
            r0 = r8;
        L_0x00c1:
            if (r0 != 0) goto L_0x0036;
        L_0x00c3:
            r11.fq();
            r0 = r1.getParent();
            r0.requestDisallowInterceptTouchEvent(r8);
            r0 = r8;
            goto L_0x0037;
        L_0x00d0:
            r0 = r7;
            goto L_0x00c1;
        L_0x00d2:
            r11.fq();
            goto L_0x0036;
        L_0x00d7:
            r9 = r7;
            goto L_0x0040;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public boolean dC() {
            ListPopupWindow dB = dB();
            if (!(dB == null || dB.PK.isShowing())) {
                dB.show();
            }
            return true;
        }

        protected boolean em() {
            ListPopupWindow dB = dB();
            if (dB != null && dB.PK.isShowing()) {
                dB.dismiss();
            }
            return true;
        }

        private void fq() {
            if (this.Qr != null) {
                this.Qp.removeCallbacks(this.Qr);
            }
            if (this.Qq != null) {
                this.Qp.removeCallbacks(this.Qq);
            }
        }

        private boolean l(MotionEvent motionEvent) {
            View view = this.Qp;
            ListPopupWindow dB = dB();
            if (dB == null || !dB.PK.isShowing()) {
                return false;
            }
            View a = dB.PL;
            if (a == null || !a.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            int[] iArr = this.Qu;
            view.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
            int[] iArr2 = this.Qu;
            a.getLocationOnScreen(iArr2);
            obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
            boolean h = a.h(obtainNoHistory, this.cF);
            obtainNoHistory.recycle();
            int d = o.d(motionEvent);
            boolean z;
            if (d == 1 || d == 3) {
                z = false;
            } else {
                z = true;
            }
            if (h && z) {
                return true;
            }
            return false;
        }
    }

    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class d extends DataSetObserver {
        private d() {
        }

        /* synthetic */ d(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void onChanged() {
            if (ListPopupWindow.this.PK.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class e implements OnScrollListener {
        private e() {
        }

        /* synthetic */ e(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.PK.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Qa);
                ListPopupWindow.this.Qa.run();
            }
        }
    }

    private class f implements OnTouchListener {
        private f() {
        }

        /* synthetic */ f(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.PK != null && ListPopupWindow.this.PK.isShowing() && x >= 0 && x < ListPopupWindow.this.PK.getWidth() && y >= 0 && y < ListPopupWindow.this.PK.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.Qa, 250);
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Qa);
            }
            return false;
        }
    }

    private class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void run() {
            if (ListPopupWindow.this.PL != null && z.ak(ListPopupWindow.this.PL) && ListPopupWindow.this.PL.getCount() > ListPopupWindow.this.PL.getChildCount() && ListPopupWindow.this.PL.getChildCount() <= ListPopupWindow.this.PT) {
                ListPopupWindow.this.PK.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    private static class a extends ListViewCompat {
        private boolean Qh;
        private boolean Qi;
        private boolean Qj;
        private ai Qk;
        private k Ql;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
            this.Qi = z;
            setCacheColorHint(0);
        }

        public final boolean h(MotionEvent motionEvent, int i) {
            boolean z = true;
            Object obj = null;
            int d = o.d(motionEvent);
            switch (d) {
                case 1:
                    z = false;
                    break;
                case 2:
                    break;
                case 3:
                    z = false;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    obj = 1;
                } else {
                    Object obj2;
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    float f = (float) x;
                    float f2 = (float) findPointerIndex;
                    this.Qj = true;
                    if (VERSION.SDK_INT >= 21) {
                        drawableHotspotChanged(f, f2);
                    }
                    if (!isPressed()) {
                        setPressed(true);
                    }
                    layoutChildren();
                    if (this.QC != -1) {
                        View childAt2 = getChildAt(this.QC - getFirstVisiblePosition());
                        if (!(childAt2 == null || childAt2 == childAt || !childAt2.isPressed())) {
                            childAt2.setPressed(false);
                        }
                    }
                    this.QC = pointToPosition;
                    float left = f - ((float) childAt.getLeft());
                    float top = f2 - ((float) childAt.getTop());
                    if (VERSION.SDK_INT >= 21) {
                        childAt.drawableHotspotChanged(left, top);
                    }
                    if (!childAt.isPressed()) {
                        childAt.setPressed(true);
                    }
                    Drawable selector = getSelector();
                    if (selector == null || pointToPosition == -1) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        selector.setVisible(false, false);
                    }
                    Rect rect = this.Qx;
                    rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                    rect.left -= this.Qy;
                    rect.top -= this.Qz;
                    rect.right += this.QA;
                    rect.bottom += this.QB;
                    try {
                        z = this.QD.getBoolean(this);
                        if (childAt.isEnabled() != z) {
                            Field field = this.QD;
                            if (z) {
                                z = false;
                            } else {
                                z = true;
                            }
                            field.set(this, Boolean.valueOf(z));
                            if (pointToPosition != -1) {
                                refreshDrawableState();
                            }
                        }
                    } catch (IllegalAccessException e) {
                    }
                    if (obj2 != null) {
                        rect = this.Qx;
                        top = rect.exactCenterX();
                        float exactCenterY = rect.exactCenterY();
                        if (getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        selector.setVisible(z, false);
                        android.support.v4.b.a.a.a(selector, top, exactCenterY);
                    }
                    Drawable selector2 = getSelector();
                    if (!(selector2 == null || pointToPosition == -1)) {
                        android.support.v4.b.a.a.a(selector2, f, f2);
                    }
                    setSelectorEnabled(false);
                    refreshDrawableState();
                    z = true;
                    if (d == 1) {
                        performItemClick(childAt, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                }
            }
            if (!(z && obj == null)) {
                this.Qj = false;
                setPressed(false);
                drawableStateChanged();
                View childAt3 = getChildAt(this.QC - getFirstVisiblePosition());
                if (childAt3 != null) {
                    childAt3.setPressed(false);
                }
                if (this.Qk != null) {
                    this.Qk.cancel();
                    this.Qk = null;
                }
            }
            if (z) {
                if (this.Ql == null) {
                    this.Ql = new k(this);
                }
                this.Ql.y(true);
                this.Ql.onTouch(this, motionEvent);
            } else if (this.Ql != null) {
                this.Ql.y(false);
            }
            return z;
        }

        protected final boolean fp() {
            return this.Qj || super.fp();
        }

        public final boolean isInTouchMode() {
            return (this.Qi && this.Qh) || super.isInTouchMode();
        }

        public final boolean hasWindowFocus() {
            return this.Qi || super.hasWindowFocus();
        }

        public final boolean isFocused() {
            return this.Qi || super.isFocused();
        }

        public final boolean hasFocus() {
            return this.Qi || super.hasFocus();
        }
    }

    static {
        try {
            PI = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            PJ = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.PM = -2;
        this.MU = -2;
        this.PP = 1002;
        this.Jh = 0;
        this.PR = false;
        this.PS = false;
        this.PT = Integer.MAX_VALUE;
        this.PV = 0;
        this.Qa = new g(this, (byte) 0);
        this.Qb = new f(this, (byte) 0);
        this.Qc = new e(this, (byte) 0);
        this.Qd = new c(this, (byte) 0);
        this.bJ = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.k.ListPopupWindow, i, i2);
        this.PN = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.PO = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.PO != 0) {
            this.PQ = true;
        }
        obtainStyledAttributes.recycle();
        this.PK = new AppCompatPopupWindow(context, attributeSet, i);
        this.PK.setInputMethodMode(1);
        this.OK = android.support.v4.d.f.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new d(this, (byte) 0);
        } else if (this.Do != null) {
            this.Do.unregisterDataSetObserver(this.mObserver);
        }
        this.Do = listAdapter;
        if (this.Do != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.PL != null) {
            this.PL.setAdapter(this.Do);
        }
    }

    public final void setModal(boolean z) {
        this.Qf = z;
        this.PK.setFocusable(z);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.PK.setBackgroundDrawable(drawable);
    }

    public final void setVerticalOffset(int i) {
        this.PO = i;
        this.PQ = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.PK.getBackground();
        if (background != null) {
            background.getPadding(this.bJ);
            this.MU = (this.bJ.left + this.bJ.right) + i;
            return;
        }
        this.MU = i;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        View view;
        LayoutParams layoutParams;
        if (this.PL == null) {
            Context context = this.mContext;
            this.Qe = new Runnable() {
                public final void run() {
                    View view = ListPopupWindow.this.PW;
                    if (view != null && view.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.PL = new a(context, !this.Qf);
            if (this.PX != null) {
                this.PL.setSelector(this.PX);
            }
            this.PL.setAdapter(this.Do);
            this.PL.setOnItemClickListener(this.PY);
            this.PL.setFocusable(true);
            this.PL.setFocusableInTouchMode(true);
            this.PL.setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = ListPopupWindow.this.PL;
                        if (a != null) {
                            a.Qh = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.PL.setOnScrollListener(this.Qc);
            if (this.PZ != null) {
                this.PL.setOnItemSelectedListener(this.PZ);
            }
            view = this.PL;
            View view2 = this.PU;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.PV) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.PV);
                        break;
                }
                if (this.MU >= 0) {
                    i = this.MU;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                i2 = 0;
            }
            this.PK.setContentView(view);
        } else {
            this.PK.getContentView();
            view = this.PU;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.PK.getBackground();
        if (background != null) {
            background.getPadding(this.bJ);
            i = this.bJ.top + this.bJ.bottom;
            if (!this.PQ) {
                this.PO = -this.bJ.top;
            }
        } else {
            this.bJ.setEmpty();
            i = 0;
        }
        if (this.PK.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int maxAvailableHeight = getMaxAvailableHeight(this.PW, this.PO, z);
        if (this.PR || this.PM == -1) {
            i2 = maxAvailableHeight + i;
        } else {
            switch (this.MU) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.bJ.left + this.bJ.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.bJ.left + this.bJ.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.MU, 1073741824);
                    break;
            }
            makeMeasureSpec = this.PL.S(makeMeasureSpec, maxAvailableHeight - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i2 += makeMeasureSpec;
        }
        z = isInputMethodNotNeeded();
        m.a(this.PK, this.PP);
        PopupWindow popupWindow;
        if (this.PK.isShowing()) {
            if (this.MU == -1) {
                i = -1;
            } else if (this.MU == -2) {
                i = this.PW.getWidth();
            } else {
                i = this.MU;
            }
            if (this.PM == -1) {
                if (z) {
                    makeMeasureSpec = i2;
                } else {
                    makeMeasureSpec = -1;
                }
                PopupWindow popupWindow2;
                if (z) {
                    popupWindow2 = this.PK;
                    if (this.MU == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow2.setWidth(i2);
                    this.PK.setHeight(0);
                    maxAvailableHeight = makeMeasureSpec;
                } else {
                    popupWindow2 = this.PK;
                    if (this.MU == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow2.setWidth(i2);
                    this.PK.setHeight(-1);
                    maxAvailableHeight = makeMeasureSpec;
                }
            } else if (this.PM != -2) {
                maxAvailableHeight = this.PM;
            } else {
                maxAvailableHeight = i2;
            }
            popupWindow = this.PK;
            if (this.PS || this.PR) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.PK;
            View view3 = this.PW;
            int i3 = this.PN;
            makeMeasureSpec = this.PO;
            if (i < 0) {
                i = -1;
            }
            if (maxAvailableHeight < 0) {
                maxAvailableHeight = -1;
            }
            popupWindow.update(view3, i3, makeMeasureSpec, i, maxAvailableHeight);
            return;
        }
        if (this.MU == -1) {
            makeMeasureSpec = -1;
        } else if (this.MU == -2) {
            makeMeasureSpec = this.PW.getWidth();
        } else {
            makeMeasureSpec = this.MU;
        }
        if (this.PM == -1) {
            i2 = -1;
        } else if (this.PM != -2) {
            i2 = this.PM;
        }
        this.PK.setWidth(makeMeasureSpec);
        this.PK.setHeight(i2);
        if (PI != null) {
            try {
                PI.invoke(this.PK, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
        popupWindow = this.PK;
        if (this.PS || this.PR) {
            z2 = false;
        }
        popupWindow.setOutsideTouchable(z2);
        this.PK.setTouchInterceptor(this.Qb);
        m.a(this.PK, this.PW, this.PN, this.PO, this.Jh);
        this.PL.setSelection(-1);
        if (!this.Qf || this.PL.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Qf) {
            this.mHandler.post(this.Qd);
        }
    }

    public final void dismiss() {
        this.PK.dismiss();
        if (this.PU != null) {
            ViewParent parent = this.PU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.PU);
            }
        }
        this.PK.setContentView(null);
        this.PL = null;
        this.mHandler.removeCallbacks(this.Qa);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.PK.setOnDismissListener(onDismissListener);
    }

    public final void fo() {
        this.PK.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.PL;
        if (aVar != null) {
            aVar.Qh = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.PK.getInputMethodMode() == 2;
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (PJ != null) {
            try {
                return ((Integer) PJ.invoke(this.PK, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.PK.getMaxAvailableHeight(view, i);
    }
}
