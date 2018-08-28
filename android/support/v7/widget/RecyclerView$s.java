package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.support.v7.widget.RecyclerView.p;
import android.view.animation.Interpolator;

class RecyclerView$s implements Runnable {
    final /* synthetic */ RecyclerView RQ;
    int SQ;
    int SR;
    private boolean SS = false;
    private boolean ST = false;
    q fT;
    private Interpolator mInterpolator = RecyclerView.fV();

    public RecyclerView$s(RecyclerView recyclerView) {
        this.RQ = recyclerView;
        this.fT = q.a(recyclerView.getContext(), RecyclerView.fV());
    }

    public final void run() {
        if (this.RQ.QV == null) {
            stop();
            return;
        }
        this.ST = false;
        this.SS = true;
        RecyclerView.d(this.RQ);
        q qVar = this.fT;
        p pVar = this.RQ.QV.Sb;
        if (qVar.computeScrollOffset()) {
            int itemCount;
            int currX = qVar.getCurrX();
            int currY = qVar.getCurrY();
            int i = currX - this.SQ;
            int i2 = currY - this.SR;
            int i3 = 0;
            int i4 = 0;
            this.SQ = currX;
            this.SR = currY;
            int i5 = 0;
            int i6 = 0;
            if (RecyclerView.h(this.RQ) != null) {
                this.RQ.fx();
                RecyclerView.i(this.RQ);
                e.beginSection("RV Scroll");
                if (i != 0) {
                    i3 = this.RQ.QV.a(i, this.RQ.QN, this.RQ.RB);
                    i5 = i - i3;
                }
                if (i2 != 0) {
                    i4 = this.RQ.QV.b(i2, this.RQ.QN, this.RQ.RB);
                    i6 = i2 - i4;
                }
                e.endSection();
                RecyclerView.j(this.RQ);
                RecyclerView.k(this.RQ);
                this.RQ.R(false);
                if (!(pVar == null || pVar.Sw || !pVar.Sx)) {
                    itemCount = this.RQ.RB.getItemCount();
                    if (itemCount == 0) {
                        pVar.stop();
                    } else {
                        if (pVar.Sv >= itemCount) {
                            pVar.Sv = itemCount - 1;
                        }
                        p.a(pVar, i - i5, i2 - i6);
                    }
                }
            }
            if (!RecyclerView.l(this.RQ).isEmpty()) {
                this.RQ.invalidate();
            }
            if (z.B(this.RQ) != 2) {
                RecyclerView.a(this.RQ, i, i2);
            }
            if (!(i5 == 0 && i6 == 0)) {
                int i7;
                int currVelocity = (int) qVar.getCurrVelocity();
                if (i5 != currX) {
                    itemCount = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                    i7 = itemCount;
                } else {
                    i7 = 0;
                }
                if (i6 == currY) {
                    currVelocity = 0;
                } else if (i6 < 0) {
                    currVelocity = -currVelocity;
                } else if (i6 <= 0) {
                    currVelocity = 0;
                }
                if (z.B(this.RQ) != 2) {
                    RecyclerView recyclerView = this.RQ;
                    if (i7 < 0) {
                        recyclerView.fA();
                        recyclerView.Rn.at(-i7);
                    } else if (i7 > 0) {
                        recyclerView.fB();
                        recyclerView.Rp.at(i7);
                    }
                    if (currVelocity < 0) {
                        recyclerView.fC();
                        recyclerView.Ro.at(-currVelocity);
                    } else if (currVelocity > 0) {
                        recyclerView.fD();
                        recyclerView.Rq.at(currVelocity);
                    }
                    if (!(i7 == 0 && currVelocity == 0)) {
                        z.E(recyclerView);
                    }
                }
                if ((i7 != 0 || i5 == currX || qVar.getFinalX() == 0) && (currVelocity != 0 || i6 == currY || qVar.getFinalY() == 0)) {
                    qVar.abortAnimation();
                }
            }
            if (!(i3 == 0 && i4 == 0)) {
                this.RQ.W(i3, i4);
            }
            if (!RecyclerView.m(this.RQ)) {
                this.RQ.invalidate();
            }
            Object obj = (i2 != 0 && this.RQ.QV.fa() && i4 == i2) ? 1 : null;
            Object obj2 = (i != 0 && this.RQ.QV.eZ() && i3 == i) ? 1 : null;
            obj2 = (!(i == 0 && i2 == 0) && obj2 == null && obj == null) ? null : 1;
            if (qVar.isFinished() || obj2 == null) {
                RecyclerView.c(this.RQ, 0);
            } else {
                gi();
            }
        }
        if (pVar != null) {
            if (pVar.Sw) {
                p.a(pVar, 0, 0);
            }
            if (!this.ST) {
                pVar.stop();
            }
        }
        this.SS = false;
        if (this.ST) {
            gi();
        }
    }

    final void gi() {
        if (this.SS) {
            this.ST = true;
            return;
        }
        this.RQ.removeCallbacks(this);
        z.a(this.RQ, this);
    }

    public final void smoothScrollBy(int i, int i2) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt(0.0d);
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.RQ.getWidth() : this.RQ.getHeight();
        int i3 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
        } else {
            round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
        }
        o(i, i2, Math.min(round, 2000));
    }

    public final void o(int i, int i2, int i3) {
        b(i, i2, i3, RecyclerView.fV());
    }

    public final void b(int i, int i2, int i3, Interpolator interpolator) {
        if (this.mInterpolator != interpolator) {
            this.mInterpolator = interpolator;
            this.fT = q.a(this.RQ.getContext(), interpolator);
        }
        RecyclerView.c(this.RQ, 2);
        this.SR = 0;
        this.SQ = 0;
        this.fT.startScroll(0, 0, i, i2, i3);
        gi();
    }

    public final void stop() {
        this.RQ.removeCallbacks(this);
        this.fT.abortAnimation();
    }
}
