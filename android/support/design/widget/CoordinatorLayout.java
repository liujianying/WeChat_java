package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v4.view.f;
import android.support.v4.view.o;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.s$l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements r {
    static final String eo;
    static final Class<?>[] ep = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> eq = new ThreadLocal();
    static final Comparator<View> es;
    static final g et;
    private ap bW;
    private final int[] eA;
    private boolean eB;
    private boolean eC;
    private int[] eD;
    private View eE;
    private View eF;
    private View eG;
    private e eH;
    private boolean eI;
    private boolean eJ;
    private Drawable eK;
    private OnHierarchyChangeListener eL;
    private final s eM;
    final Comparator<View> er;
    final List<View> eu;
    private final List<View> ev;
    private final List<View> ew;
    final Rect ex;
    final Rect ey;
    private final Rect ez;

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean d(View view) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, float f, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public static ap a(ap apVar) {
            return apVar;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        SparseArray<Parcelable> eZ;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.eZ = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.eZ.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.eZ != null ? this.eZ.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.eZ.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.eZ.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private class a implements t {
        private a() {
        }

        /* synthetic */ a(CoordinatorLayout coordinatorLayout, byte b) {
            this();
        }

        public final ap a(View view, ap apVar) {
            return CoordinatorLayout.a(CoordinatorLayout.this, apVar);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> value();
    }

    private class c implements OnHierarchyChangeListener {
        private c() {
        }

        /* synthetic */ c(CoordinatorLayout coordinatorLayout, byte b) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.eL != null) {
                CoordinatorLayout.this.eL.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            int size = coordinatorLayout.eu.size();
            int i = 0;
            Object obj = null;
            while (i < size) {
                Object obj2;
                View view3 = (View) coordinatorLayout.eu.get(i);
                if (view3 == view2) {
                    obj2 = 1;
                } else {
                    if (obj != null) {
                        view3.getLayoutParams();
                    }
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (CoordinatorLayout.this.eL != null) {
                CoordinatorLayout.this.eL.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class d extends MarginLayoutParams {
        public int anchorGravity = 0;
        Behavior eO;
        boolean eP = false;
        public int eQ = -1;
        int eR = -1;
        View eS;
        View eT;
        boolean eU;
        boolean eV;
        boolean eW;
        final Rect eX = new Rect();
        Object eY;
        public int gravity = 0;

        public d() {
            super(-2, -2);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.CoordinatorLayout_LayoutParams);
            this.gravity = obtainStyledAttributes.getInteger(i.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
            this.eR = obtainStyledAttributes.getResourceId(i.CoordinatorLayout_LayoutParams_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(i.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
            this.eQ = obtainStyledAttributes.getInteger(i.CoordinatorLayout_LayoutParams_layout_keyline, -1);
            this.eP = obtainStyledAttributes.hasValue(i.CoordinatorLayout_LayoutParams_layout_behavior);
            if (this.eP) {
                this.eO = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(i.CoordinatorLayout_LayoutParams_layout_behavior));
            }
            obtainStyledAttributes.recycle();
        }

        public d(d dVar) {
            super(dVar);
        }

        public d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a(Behavior behavior) {
            if (this.eO != behavior) {
                this.eO = behavior;
                this.eY = null;
                this.eP = true;
            }
        }

        final boolean n(View view) {
            return view == this.eT || (this.eO != null && this.eO.d(view));
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        eo = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            es = new f();
            et = new h();
        } else {
            es = null;
            et = null;
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.er = new 1(this);
        this.eu = new ArrayList();
        this.ev = new ArrayList();
        this.ew = new ArrayList();
        this.ex = new Rect();
        this.ey = new Rect();
        this.ez = new Rect();
        this.eA = new int[2];
        this.eM = new s(this);
        t.G(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.CoordinatorLayout, i, h.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(i.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.eD = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.eD.length;
            for (resourceId = 0; resourceId < length; resourceId++) {
                int[] iArr = this.eD;
                iArr[resourceId] = (int) (((float) iArr[resourceId]) * f);
            }
        }
        this.eK = obtainStyledAttributes.getDrawable(i.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (et != null) {
            et.a(this, new a(this, (byte) 0));
        }
        super.setOnHierarchyChangeListener(new c(this, (byte) 0));
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.eL = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ai();
        if (this.eI) {
            if (this.eH == null) {
                this.eH = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.eH);
        }
        if (this.bW == null && z.Z(this)) {
            z.Y(this);
        }
        this.eC = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai();
        if (this.eI && this.eH != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.eH);
        }
        if (this.eG != null) {
            onStopNestedScroll(this.eG);
        }
        this.eC = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.eK != drawable) {
            if (this.eK != null) {
                this.eK.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.eK = drawable2;
            if (this.eK != null) {
                if (this.eK.isStateful()) {
                    this.eK.setState(getDrawableState());
                }
                android.support.v4.b.a.a.b(this.eK, z.I(this));
                this.eK.setVisible(getVisibility() == 0, false);
                this.eK.setCallback(this);
            }
            z.E(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.eK;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.eK;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.eK;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.eK != null && this.eK.isVisible() != z) {
            this.eK.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.content.a.f(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    private void ai() {
        if (this.eE != null) {
            Behavior behavior = ((d) this.eE.getLayoutParams()).eO;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.b(this, this.eE, obtain);
                obtain.recycle();
            }
            this.eE = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((d) getChildAt(i).getLayoutParams()).eU = false;
        }
        this.eB = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z = false;
        Object obj = null;
        int d = o.d(motionEvent);
        List list = this.ev;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i2 = childCount - 1;
        while (i2 >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            i2--;
        }
        if (es != null) {
            Collections.sort(list, es);
        }
        int size = list.size();
        int i3 = 0;
        MotionEvent motionEvent2 = null;
        while (i3 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i3);
            d dVar = (d) view.getLayoutParams();
            Behavior behavior = dVar.eO;
            if ((!z && obj == null) || d == 0) {
                boolean z2;
                if (!(z || behavior == null)) {
                    switch (i) {
                        case 0:
                            z = behavior.a(this, view, motionEvent);
                            break;
                        case 1:
                            z = behavior.b(this, view, motionEvent);
                            break;
                    }
                    if (z) {
                        this.eE = view;
                    }
                }
                isChildrenDrawingOrderEnabled = z;
                if (dVar.eO == null) {
                    dVar.eU = false;
                }
                boolean z3 = dVar.eU;
                if (dVar.eU) {
                    z2 = true;
                } else {
                    boolean z4 = dVar.eU | 0;
                    dVar.eU = z4;
                    z2 = z4;
                }
                obj2 = (!z2 || z3) ? null : 1;
                if (z2 && obj2 == null) {
                    list.clear();
                    return isChildrenDrawingOrderEnabled;
                }
                motionEvent3 = motionEvent2;
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        behavior.a(this, view, motionEvent3);
                        obj2 = obj;
                        isChildrenDrawingOrderEnabled = z;
                        continue;
                    case 1:
                        behavior.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                isChildrenDrawingOrderEnabled = z;
            } else {
                motionEvent3 = motionEvent2;
                obj2 = obj;
                isChildrenDrawingOrderEnabled = z;
            }
            i3++;
            motionEvent2 = motionEvent3;
            obj = obj2;
            z = isChildrenDrawingOrderEnabled;
        }
        isChildrenDrawingOrderEnabled = z;
        list.clear();
        return isChildrenDrawingOrderEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            ai();
        }
        boolean a = a(motionEvent, 0);
        if (d == 1 || d == 3) {
            ai();
        }
        return a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2;
        int d = o.d(motionEvent);
        boolean z2;
        if (this.eE == null) {
            boolean a = a(motionEvent, 1);
            if (a) {
                z2 = a;
            } else {
                z2 = a;
                z = false;
                if (this.eE == null) {
                    z |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                } else {
                    motionEvent2 = null;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (d == 1 || d == 3) {
                    ai();
                }
                return z;
            }
        }
        z2 = false;
        Behavior behavior = ((d) this.eE.getLayoutParams()).eO;
        z = behavior != null ? behavior.b(this, this.eE, motionEvent) : false;
        if (this.eE == null) {
            z |= super.onTouchEvent(motionEvent);
            motionEvent2 = null;
        } else if (z2) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        } else {
            motionEvent2 = null;
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        ai();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.eB) {
            ai();
            this.eB = true;
        }
    }

    private int C(int i) {
        if (this.eD == null) {
            new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i);
            return 0;
        } else if (i >= 0 && i < this.eD.length) {
            return this.eD[i];
        } else {
            new StringBuilder("Keyline index ").append(i).append(" out of range for ").append(this);
            return 0;
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(eo)) {
            str = eo + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) eq.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                eq.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(ep);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static d l(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.eP) {
            b bVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (b) cls.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            b bVar2 = bVar;
            if (bVar2 != null) {
                try {
                    dVar.a((Behavior) bVar2.value().newInstance());
                } catch (Exception e) {
                    new StringBuilder("Default behavior class ").append(bVar2.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
                }
            }
            dVar.eP = true;
        }
        return dVar;
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        Object obj;
        this.eu.clear();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            ViewParent childAt = getChildAt(i3);
            d l = l(childAt);
            if (l.eR == -1) {
                l.eT = null;
                l.eS = null;
            } else {
                View view;
                ViewParent parent;
                if (l.eS != null) {
                    Object obj2;
                    if (l.eS.getId() != l.eR) {
                        obj2 = null;
                    } else {
                        view = l.eS;
                        parent = l.eS.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                l.eT = null;
                                l.eS = null;
                                obj2 = null;
                                break;
                            }
                            if (parent instanceof View) {
                                view = (View) parent;
                            }
                            parent = parent.getParent();
                        }
                        l.eT = view;
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        continue;
                    }
                }
                l.eS = findViewById(l.eR);
                if (l.eS != null) {
                    if (l.eS != this) {
                        view = l.eS;
                        parent = l.eS.getParent();
                        while (parent != this && parent != null) {
                            if (parent != childAt) {
                                if (parent instanceof View) {
                                    view = (View) parent;
                                }
                                parent = parent.getParent();
                            } else if (isInEditMode()) {
                                l.eT = null;
                                l.eS = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        l.eT = view;
                    } else if (isInEditMode()) {
                        l.eT = null;
                        l.eS = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    l.eT = null;
                    l.eS = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(l.eR) + " to anchor view " + childAt);
                }
            }
            this.eu.add(childAt);
        }
        a(this.eu, this.er);
        aj();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        i3 = getPaddingBottom();
        int I = z.I(this);
        Object obj3;
        if (I == 1) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i4 = paddingLeft + paddingRight;
        int i5 = paddingTop + i3;
        childCount = getSuggestedMinimumWidth();
        i3 = getSuggestedMinimumHeight();
        if (this.bW == null || !z.Z(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size3 = this.eu.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = i3;
        int i9 = childCount;
        while (i6 < size3) {
            int i10;
            View view2 = (View) this.eu.get(i6);
            d dVar = (d) view2.getLayoutParams();
            int i11 = 0;
            if (dVar.eQ >= 0 && mode != 0) {
                int C = C(dVar.eQ);
                paddingTop = f.getAbsoluteGravity(E(dVar.gravity), I) & 7;
                if ((paddingTop == 3 && obj3 == null) || (paddingTop == 5 && obj3 != null)) {
                    i11 = Math.max(0, (size - paddingRight) - C);
                } else if ((paddingTop == 5 && obj3 == null) || (paddingTop == 3 && obj3 != null)) {
                    i11 = Math.max(0, C - paddingLeft);
                }
            }
            if (obj == null || z.Z(view2)) {
                i10 = i2;
                childCount = i;
            } else {
                paddingTop = this.bW.getSystemWindowInsetTop() + this.bW.getSystemWindowInsetBottom();
                childCount = MeasureSpec.makeMeasureSpec(size - (this.bW.getSystemWindowInsetLeft() + this.bW.getSystemWindowInsetRight()), mode);
                i10 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            Behavior behavior = dVar.eO;
            if (behavior == null || !behavior.a(this, view2, childCount, i11, i10, 0)) {
                a(view2, childCount, i11, i10, 0);
            }
            i11 = Math.max(i9, ((view2.getMeasuredWidth() + i4) + dVar.leftMargin) + dVar.rightMargin);
            childCount = Math.max(i8, ((view2.getMeasuredHeight() + i5) + dVar.topMargin) + dVar.bottomMargin);
            i6++;
            i7 = z.combineMeasuredStates(i7, z.M(view2));
            i8 = childCount;
            i9 = i11;
        }
        setMeasuredDimension(z.resolveSizeAndState(i9, i, -16777216 & i7), z.resolveSizeAndState(i8, i2, i7 << 16));
    }

    public final void e(View view, int i) {
        Object obj;
        d dVar = (d) view.getLayoutParams();
        if (dVar.eS != null || dVar.eR == -1) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.eS != null) {
            View view2 = dVar.eS;
            view.getLayoutParams();
            Rect rect = this.ex;
            Rect rect2 = this.ey;
            x.a(this, view2, rect);
            a(view, i, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        } else if (dVar.eQ >= 0) {
            int i2;
            int i3 = dVar.eQ;
            dVar = (d) view.getLayoutParams();
            int absoluteGravity = f.getAbsoluteGravity(E(dVar.gravity), i);
            int i4 = absoluteGravity & 7;
            absoluteGravity &= 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (i == 1) {
                i3 = width - i3;
            }
            i3 = C(i3) - measuredWidth;
            switch (i4) {
                case 1:
                    i2 = i3 + (measuredWidth / 2);
                    break;
                case 5:
                    i2 = i3 + measuredWidth;
                    break;
                default:
                    i2 = i3;
                    break;
            }
            switch (absoluteGravity) {
                case 16:
                    i3 = (measuredHeight / 2) + 0;
                    break;
                case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                    i3 = measuredHeight + 0;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(i2, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
            int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
            view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
        } else {
            dVar = (d) view.getLayoutParams();
            Rect rect3 = this.ex;
            rect3.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
            if (!(this.bW == null || !z.Z(this) || z.Z(view))) {
                rect3.left += this.bW.getSystemWindowInsetLeft();
                rect3.top += this.bW.getSystemWindowInsetTop();
                rect3.right -= this.bW.getSystemWindowInsetRight();
                rect3.bottom -= this.bW.getSystemWindowInsetBottom();
            }
            Rect rect4 = this.ey;
            f.apply(D(dVar.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect3, rect4, i);
            view.layout(rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int I = z.I(this);
        int size = this.eu.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.eu.get(i5);
            Behavior behavior = ((d) view.getLayoutParams()).eO;
            if (behavior == null || !behavior.a(this, view, I)) {
                e(view, I);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eJ && this.eK != null) {
            int systemWindowInsetTop = this.bW != null ? this.bW.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.eK.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.eK.draw(canvas);
            }
        }
    }

    final void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            x.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.gravity;
        if (i2 == 0) {
            i2 = 17;
        }
        i2 = f.getAbsoluteGravity(i2, i);
        int absoluteGravity = f.getAbsoluteGravity(D(dVar.anchorGravity), i);
        int i3 = i2 & 7;
        int i4 = i2 & 112;
        i2 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (i2) {
            case 1:
                absoluteGravity = (rect.width() / 2) + rect.left;
                break;
            case 5:
                absoluteGravity = rect.right;
                break;
            default:
                absoluteGravity = rect.left;
                break;
        }
        switch (i5) {
            case 16:
                i2 = rect.top + (rect.height() / 2);
                break;
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                i2 = rect.bottom;
                break;
            default:
                i2 = rect.top;
                break;
        }
        switch (i3) {
            case 1:
                absoluteGravity -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                absoluteGravity -= measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i2 -= measuredHeight / 2;
                break;
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                break;
            default:
                i2 -= measuredHeight;
                break;
        }
        i3 = getWidth();
        i4 = getHeight();
        absoluteGravity = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(absoluteGravity, ((i3 - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i2, ((i4 - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        rect2.set(absoluteGravity, max, absoluteGravity + measuredWidth, max + measuredHeight);
    }

    private static int D(int i) {
        return i == 0 ? 8388659 : i;
    }

    private static int E(int i) {
        return i == 0 ? 8388661 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    final void q(boolean z) {
        int I = z.I(this);
        int size = this.eu.size();
        for (int i = 0; i < size; i++) {
            int i2;
            d dVar;
            Behavior behavior;
            View view = (View) this.eu.get(i);
            d dVar2 = (d) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (dVar2.eT == ((View) this.eu.get(i2))) {
                    dVar = (d) view.getLayoutParams();
                    if (dVar.eS != null) {
                        Rect rect = this.ex;
                        Rect rect2 = this.ey;
                        Rect rect3 = this.ez;
                        x.a(this, dVar.eS, rect);
                        a(view, false, rect2);
                        a(view, I, rect, rect3);
                        int i3 = rect3.left - rect2.left;
                        int i4 = rect3.top - rect2.top;
                        if (i3 != 0) {
                            view.offsetLeftAndRight(i3);
                        }
                        if (i4 != 0) {
                            view.offsetTopAndBottom(i4);
                        }
                        if (i3 != 0 || i4 != 0) {
                            behavior = dVar.eO;
                            if (behavior != null) {
                                behavior.b(this, view, dVar.eS);
                            }
                        }
                    }
                }
            }
            Rect rect4 = this.ex;
            Rect rect5 = this.ey;
            rect4.set(((d) view.getLayoutParams()).eX);
            a(view, true, rect5);
            if (!rect4.equals(rect5)) {
                ((d) view.getLayoutParams()).eX.set(rect5);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.eu.get(i2);
                    dVar = (d) view2.getLayoutParams();
                    behavior = dVar.eO;
                    if (behavior != null && behavior.d(view)) {
                        if (z || !dVar.eW) {
                            behavior.b(this, view2, view);
                            if (z) {
                                dVar.eW = false;
                            }
                        } else {
                            dVar.eW = false;
                        }
                    }
                }
            }
        }
    }

    public final List<View> m(View view) {
        d dVar = (d) view.getLayoutParams();
        List<View> list = this.ew;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && dVar.n(childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    private void aj() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.eS != null) {
                z = true;
            } else {
                int childCount2 = getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = getChildAt(i2);
                    if (childAt2 != childAt && dVar.n(childAt2)) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            if (z) {
                z = true;
                break;
            }
        }
        z = false;
        if (z == this.eI) {
            return;
        }
        if (z) {
            if (this.eC) {
                if (this.eH == null) {
                    this.eH = new e(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.eH);
            }
            this.eI = true;
            return;
        }
        if (this.eC && this.eH != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.eH);
        }
        this.eI = false;
    }

    public final boolean b(View view, int i, int i2) {
        Rect rect = this.ex;
        x.a(this, view, rect);
        return rect.contains(i, i2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            Behavior behavior = dVar.eO;
            if (behavior != null) {
                boolean a = behavior.a(this, childAt, view, i);
                i3 |= a;
                dVar.eV = a;
            } else {
                dVar.eV = false;
            }
            i2++;
            i3 = i3;
        }
        return i3;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.eM.uX = i;
        this.eF = view;
        this.eG = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams();
        }
    }

    public void onStopNestedScroll(View view) {
        this.eM.uX = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.eV) {
                Behavior behavior = dVar.eO;
                if (behavior != null) {
                    behavior.a(this, childAt, view);
                }
                dVar.eV = false;
                dVar.eW = false;
            }
        }
        this.eF = null;
        this.eG = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            boolean z2;
            View childAt = getChildAt(i5);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.eV) {
                Behavior behavior = dVar.eO;
                if (behavior != null) {
                    behavior.b(this, childAt, i4);
                    z2 = true;
                    i5++;
                    z = z2;
                }
            }
            z2 = z;
            i5++;
            z = z2;
        }
        if (z) {
            q(true);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            View childAt = getChildAt(i5);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.eV) {
                Behavior behavior = dVar.eO;
                if (behavior != null) {
                    int[] iArr2 = this.eA;
                    this.eA[1] = 0;
                    iArr2[0] = 0;
                    behavior.a(this, childAt, view, i2, this.eA);
                    max = i > 0 ? Math.max(i3, this.eA[0]) : Math.min(i3, this.eA[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.eA[1]) : Math.min(i4, this.eA[1]);
                    obj = 1;
                    i5++;
                    i4 = max2;
                    i3 = max;
                }
            }
            max2 = i4;
            max = i3;
            i5++;
            i4 = max2;
            i3 = max;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            q(true);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.eV) {
                Behavior behavior = dVar.eO;
                if (behavior != null) {
                    a = behavior.a(this, childAt, f2, z) | z2;
                    i++;
                    z2 = a;
                }
            }
            a = z2;
            i++;
            z2 = a;
        }
        if (z2) {
            q(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.eV) {
                Behavior behavior = dVar.eO;
                if (behavior != null) {
                    a = behavior.a(this, childAt, view, f, f2) | z;
                    i++;
                    z = a;
                }
            }
            a = z;
            i++;
            z = a;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.eM.uX;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.eZ;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = l(childAt).eO;
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        behavior.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((d) childAt.getLayoutParams()).eO;
            if (!(id == -1 || behavior == null)) {
                Parcelable b = behavior.b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.eZ = sparseArray;
        return savedState;
    }

    private static void a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }
}
