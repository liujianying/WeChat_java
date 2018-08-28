package android.support.v7.widget.a;

import android.support.v4.view.o;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.j;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

class a$2 implements j {
    final /* synthetic */ a Yc;

    a$2(a aVar) {
        this.Yc = aVar;
    }

    public final boolean n(MotionEvent motionEvent) {
        this.Yc.XZ.onTouchEvent(motionEvent);
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Yc.cF = o.c(motionEvent, 0);
            this.Yc.XH = motionEvent.getX();
            this.Yc.XI = motionEvent.getY();
            a aVar = this.Yc;
            if (aVar.cE != null) {
                aVar.cE.recycle();
            }
            aVar.cE = VelocityTracker.obtain();
            if (this.Yc.XG == null) {
                a$c a_c;
                a aVar2 = this.Yc;
                if (!aVar2.XS.isEmpty()) {
                    View p = aVar2.p(motionEvent);
                    for (int size = aVar2.XS.size() - 1; size >= 0; size--) {
                        a_c = (a$c) aVar2.XS.get(size);
                        if (a_c.Sh.SU == p) {
                            break;
                        }
                    }
                }
                a_c = null;
                if (a_c != null) {
                    a aVar3 = this.Yc;
                    aVar3.XH -= a_c.Yr;
                    aVar3 = this.Yc;
                    aVar3.XI -= a_c.Ys;
                    this.Yc.a(a_c.Sh, true);
                    if (this.Yc.XE.remove(a_c.Sh.SU)) {
                        this.Yc.XP.c(this.Yc.Sa, a_c.Sh);
                    }
                    this.Yc.d(a_c.Sh, a_c.XQ);
                    a.a(this.Yc, motionEvent, this.Yc.XR, 0);
                }
            }
        } else if (d == 3 || d == 1) {
            this.Yc.cF = -1;
            this.Yc.d(null, 0);
        } else if (this.Yc.cF != -1) {
            int b = o.b(motionEvent, this.Yc.cF);
            if (b >= 0) {
                a.a(this.Yc, d, motionEvent, b);
            }
        }
        if (this.Yc.cE != null) {
            this.Yc.cE.addMovement(motionEvent);
        }
        if (this.Yc.XG != null) {
            return true;
        }
        return false;
    }

    public final void o(MotionEvent motionEvent) {
        int i = 0;
        this.Yc.XZ.onTouchEvent(motionEvent);
        if (this.Yc.cE != null) {
            this.Yc.cE.addMovement(motionEvent);
        }
        if (this.Yc.cF != -1) {
            int d = o.d(motionEvent);
            int b = o.b(motionEvent, this.Yc.cF);
            if (b >= 0) {
                a.a(this.Yc, d, motionEvent, b);
            }
            RecyclerView$t recyclerView$t = this.Yc.XG;
            if (recyclerView$t != null) {
                switch (d) {
                    case 1:
                        break;
                    case 2:
                        if (b >= 0) {
                            a.a(this.Yc, motionEvent, this.Yc.XR, b);
                            a.a(this.Yc, recyclerView$t);
                            this.Yc.Sa.removeCallbacks(this.Yc.XU);
                            this.Yc.XU.run();
                            this.Yc.Sa.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        if (this.Yc.cE != null) {
                            this.Yc.cE.clear();
                            break;
                        }
                        break;
                    case 6:
                        d = o.e(motionEvent);
                        if (o.c(motionEvent, d) == this.Yc.cF) {
                            if (d == 0) {
                                i = 1;
                            }
                            this.Yc.cF = o.c(motionEvent, i);
                            a.a(this.Yc, motionEvent, this.Yc.XR, d);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                this.Yc.d(null, 0);
                this.Yc.cF = -1;
            }
        }
    }

    public final void S(boolean z) {
        if (z) {
            this.Yc.d(null, 0);
        }
    }
}
