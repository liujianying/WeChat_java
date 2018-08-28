package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private VelocityTracker cE;
    private int cF = -1;
    private Runnable fS;
    private q fT;
    private boolean fU;
    private int fV;
    private int fW = -1;

    private class a implements Runnable {
        private final CoordinatorLayout fX;
        private final V fY;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.fX = coordinatorLayout;
            this.fY = v;
        }

        public final void run() {
            if (this.fY != null && HeaderBehavior.this.fT != null) {
                if (HeaderBehavior.this.fT.computeScrollOffset()) {
                    HeaderBehavior.this.c(this.fX, this.fY, HeaderBehavior.this.fT.getCurrY());
                    z.a(this.fY, this);
                    return;
                }
                HeaderBehavior.this.a(this.fX, this.fY);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.fW < 0) {
            this.fW = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.fU) {
            return true;
        }
        int y;
        switch (o.d(motionEvent)) {
            case 0:
                this.fU = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (S() && coordinatorLayout.b(v, x, y)) {
                    this.fV = y;
                    this.cF = o.c(motionEvent, 0);
                    av();
                    break;
                }
            case 1:
            case 3:
                this.fU = false;
                this.cF = -1;
                if (this.cE != null) {
                    this.cE.recycle();
                    this.cE = null;
                    break;
                }
                break;
            case 2:
                y = this.cF;
                if (y != -1) {
                    y = o.b(motionEvent, y);
                    if (y != -1) {
                        y = (int) o.e(motionEvent, y);
                        if (Math.abs(y - this.fV) > this.fW) {
                            this.fU = true;
                            this.fV = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.cE != null) {
            this.cE.addMovement(motionEvent);
        }
        return this.fU;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.fW < 0) {
            this.fW = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (o.d(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), y) && S()) {
                    this.fV = y;
                    this.cF = o.c(motionEvent, 0);
                    av();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.cE != null) {
                    this.cE.addMovement(motionEvent);
                    this.cE.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -b(v), y.b(this.cE, this.cF));
                    break;
                }
                break;
            case 2:
                int b = o.b(motionEvent, this.cF);
                if (b != -1) {
                    b = (int) o.e(motionEvent, b);
                    int i = this.fV - b;
                    if (!this.fU && Math.abs(i) > this.fW) {
                        this.fU = true;
                        i = i > 0 ? i - this.fW : i + this.fW;
                    }
                    if (this.fU) {
                        this.fV = b;
                        b(coordinatorLayout, v, i, c(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.fU = false;
        this.cF = -1;
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
        if (this.cE != null) {
            this.cE.addMovement(motionEvent);
        }
        return true;
    }

    final int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int T = T();
        if (i2 == 0 || T < i2 || T > i3) {
            return 0;
        }
        int e = n.e(i, i2, i3);
        if (T == e) {
            return 0;
        }
        p(e);
        return T - e;
    }

    int R() {
        return T();
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, R() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, float f) {
        if (this.fS != null) {
            v.removeCallbacks(this.fS);
            this.fS = null;
        }
        if (this.fT == null) {
            this.fT = q.a(v.getContext(), null);
        }
        this.fT.b(T(), 0, Math.round(f), 0, 0, i, 0);
        if (this.fT.computeScrollOffset()) {
            this.fS = new a(coordinatorLayout, v);
            z.a(v, this.fS);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean S() {
        return false;
    }

    int c(V v) {
        return -v.getHeight();
    }

    int b(V v) {
        return v.getHeight();
    }

    private void av() {
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
    }
}
