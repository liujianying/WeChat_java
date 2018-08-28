package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.support.v4.widget.u.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    private int cA;
    public WeakReference<V> cB;
    private WeakReference<View> cC;
    public a cD;
    private VelocityTracker cE;
    private int cF;
    private int cG;
    private boolean cH;
    private final a cI = new 1(this);
    private float cq;
    private int cs;
    public int ct;
    private int cu;
    public boolean cv;
    public u cw;
    private boolean cx;
    private int cy;
    private boolean cz;
    public int mState = 4;

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new 1();
        final int state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.BottomSheetBehavior_Params);
        q(obtainStyledAttributes.getDimensionPixelSize(i.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        this.cv = obtainStyledAttributes.getBoolean(i.BottomSheetBehavior_Params_behavior_hideable, false);
        obtainStyledAttributes.recycle();
        this.cq = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.mState);
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.mState == 1 || this.mState == 2)) {
            if (z.Z(coordinatorLayout) && !z.Z(v)) {
                z.a(v, true);
            }
            coordinatorLayout.e(v, i);
        }
        this.cA = coordinatorLayout.getHeight();
        this.ct = Math.max(0, this.cA - v.getHeight());
        this.cu = Math.max(this.cA - this.cs, this.ct);
        if (this.mState == 3) {
            z.j(v, this.ct);
        } else if (this.cv && this.mState == 5) {
            z.j(v, this.cA);
        } else if (this.mState == 4) {
            z.j(v, this.cu);
        }
        if (this.cw == null) {
            this.cw = u.a(coordinatorLayout, this.cI);
        }
        this.cB = new WeakReference(v);
        this.cC = new WeakReference(g((View) v));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        View view;
        int d = o.d(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        switch (d) {
            case 0:
                int x = (int) motionEvent.getX();
                this.cG = (int) motionEvent.getY();
                view = (View) this.cC.get();
                if (view != null && coordinatorLayout.b(view, x, this.cG)) {
                    this.cF = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.cH = true;
                }
                boolean z = this.cF == -1 && !coordinatorLayout.b(v, x, this.cG);
                this.cx = z;
                break;
            case 1:
            case 3:
                this.cH = false;
                this.cF = -1;
                if (this.cx) {
                    this.cx = false;
                    return false;
                }
                break;
        }
        if (!this.cx && this.cw.j(motionEvent)) {
            return true;
        }
        view = (View) this.cC.get();
        if (d != 2 || view == null || this.cx || this.mState == 1 || coordinatorLayout.b(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.cG) - motionEvent.getY()) <= ((float) this.cw.fW)) {
            return false;
        }
        return true;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = o.d(motionEvent);
        if (this.mState == 1 && d == 0) {
            return true;
        }
        this.cw.k(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        if (d != 2 || this.cx || Math.abs(((float) this.cG) - motionEvent.getY()) <= ((float) this.cw.fW)) {
            return true;
        }
        this.cw.n(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        this.cy = 0;
        this.cz = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        if (view == ((View) this.cC.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.ct) {
                    iArr[1] = top - this.ct;
                    z.j(v, -iArr[1]);
                    b(3);
                } else {
                    iArr[1] = i;
                    z.j(v, -i);
                    b(1);
                }
            } else if (i < 0 && !z.h(view, -1)) {
                if (i2 <= this.cu || this.cv) {
                    iArr[1] = i;
                    z.j(v, -i);
                    b(1);
                } else {
                    iArr[1] = top - this.cu;
                    z.j(v, -iArr[1]);
                    b(4);
                }
            }
            s(v.getTop());
            this.cy = i;
            this.cz = true;
        }
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.ct) {
            b(3);
        } else if (view == this.cC.get() && this.cz) {
            int i2;
            if (this.cy > 0) {
                i2 = this.ct;
            } else {
                if (this.cv) {
                    this.cE.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT, this.cq);
                    if (a((View) v, y.b(this.cE, this.cF))) {
                        i = 5;
                        i2 = this.cA;
                    }
                }
                if (this.cy == 0) {
                    i2 = v.getTop();
                    if (Math.abs(i2 - this.ct) < Math.abs(i2 - this.cu)) {
                        i2 = this.ct;
                    } else {
                        i2 = this.cu;
                        i = 4;
                    }
                } else {
                    i2 = this.cu;
                    i = 4;
                }
            }
            if (this.cw.d(v, v.getLeft(), i2)) {
                b(2);
                z.a(v, new b(this, v, i));
            } else {
                b(i);
            }
            this.cz = false;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.cC.get() && (this.mState != 3 || super.a(coordinatorLayout, v, view, f, f2));
    }

    public final void q(int i) {
        this.cs = Math.max(0, i);
        this.cu = this.cA - i;
    }

    /* renamed from: r */
    public final void b(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (((View) this.cB.get()) != null && this.cD != null) {
                this.cD.u(i);
            }
        }
    }

    private void reset() {
        this.cF = -1;
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
    }

    private boolean a(View view, float f) {
        if (view.getTop() >= this.cu && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.cu)) / ((float) this.cs) > 0.5f) {
            return true;
        }
        return false;
    }

    private View g(View view) {
        if (view instanceof p) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View g = g(viewGroup.getChildAt(i));
                if (g != null) {
                    return g;
                }
            }
        }
        return null;
    }

    private void s(int i) {
        if (((View) this.cB.get()) != null && this.cD != null) {
            if (i > this.cu) {
                this.cD.g(((float) (this.cu - i)) / ((float) this.cs));
            } else {
                this.cD.g(((float) (this.cu - i)) / ((float) (this.cu - this.ct)));
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> h(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof d) {
            Behavior behavior = ((d) layoutParams).eO;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
