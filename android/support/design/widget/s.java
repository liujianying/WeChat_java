package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class s<V extends View> extends Behavior<V> {
    private final android.support.v4.widget.u.a cI = new android.support.v4.widget.u.a() {
        private int cF = -1;
        private int he;

        public final boolean b(View view, int i) {
            return this.cF == -1 && s.this.r(view);
        }

        public final void f(View view, int i) {
            this.cF = i;
            this.he = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public final void t(int i) {
            if (s.this.gX != null) {
                s.this.gX.H(i);
            }
        }

        public final void a(View view, float f, float f2) {
            boolean z;
            int i;
            boolean z2 = true;
            this.cF = -1;
            int width = view.getWidth();
            if (f != 0.0f) {
                z = z.I(view) == 1;
                z = s.this.ha == 2 ? true : s.this.ha == 0 ? z ? f < 0.0f : f > 0.0f : s.this.ha == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.he) >= Math.round(((float) view.getWidth()) * s.this.hb);
            }
            if (z) {
                i = view.getLeft() < this.he ? this.he - width : this.he + width;
            } else {
                i = this.he;
                z2 = false;
            }
            if (s.this.cw.w(i, view.getTop())) {
                z.a(view, new b(s.this, view, z2));
            } else if (z2 && s.this.gX != null) {
                s.this.gX.onDismiss(view);
            }
        }

        public final int s(View view) {
            return view.getWidth();
        }

        public final int d(View view, int i) {
            int width;
            int i2;
            Object obj = z.I(view) == 1 ? 1 : null;
            if (s.this.ha == 0) {
                if (obj != null) {
                    width = this.he - view.getWidth();
                    i2 = this.he;
                } else {
                    width = this.he;
                    i2 = this.he + view.getWidth();
                }
            } else if (s.this.ha != 1) {
                width = this.he - view.getWidth();
                i2 = this.he + view.getWidth();
            } else if (obj != null) {
                width = this.he;
                i2 = this.he + view.getWidth();
            } else {
                width = this.he - view.getWidth();
                i2 = this.he;
            }
            return Math.min(Math.max(width, i), i2);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void a(View view, int i, int i2) {
            float width = ((float) this.he) + (((float) view.getWidth()) * s.this.hc);
            float width2 = ((float) this.he) + (((float) view.getWidth()) * s.this.hd);
            if (((float) i) <= width) {
                z.d(view, 1.0f);
            } else if (((float) i) >= width2) {
                z.d(view, 0.0f);
            } else {
                z.d(view, s.o(1.0f - s.c(width, width2, (float) i)));
            }
        }
    };
    private u cw;
    private boolean cx;
    a gX;
    private float gY = 0.0f;
    private boolean gZ;
    int ha = 2;
    private float hb = 0.5f;
    float hc = 0.0f;
    float hd = 0.5f;

    public interface a {
        void H(int i);

        void onDismiss(View view);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (o.d(motionEvent)) {
            case 1:
            case 3:
                if (this.cx) {
                    this.cx = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.cx = z;
                break;
        }
        if (this.cx) {
            return false;
        }
        if (this.cw == null) {
            u a;
            if (this.gZ) {
                a = u.a(coordinatorLayout, this.gY, this.cI);
            } else {
                a = u.a(coordinatorLayout, this.cI);
            }
            this.cw = a;
        }
        return this.cw.j(motionEvent);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.cw == null) {
            return false;
        }
        this.cw.k(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }

    static float o(float f) {
        return Math.min(Math.max(0.0f, f), 1.0f);
    }

    static float c(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
