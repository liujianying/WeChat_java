package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.e.a;
import android.support.v7.widget.e.b;
import android.view.View;

class RecyclerView$6 implements a {
    final /* synthetic */ RecyclerView RQ;

    RecyclerView$6(RecyclerView recyclerView) {
        this.RQ = recyclerView;
    }

    public final t aS(int i) {
        t aY;
        RecyclerView recyclerView = this.RQ;
        int eO = recyclerView.QQ.eO();
        for (int i2 = 0; i2 < eO; i2++) {
            aY = RecyclerView.aY(recyclerView.QQ.aW(i2));
            if (aY != null && !aY.isRemoved() && aY.mPosition == i) {
                break;
            }
        }
        aY = null;
        if (aY == null || this.RQ.QQ.aO(aY.SU)) {
            return null;
        }
        return aY;
    }

    public final void A(int i, int i2) {
        this.RQ.d(i, i2, true);
        this.RQ.RE = true;
        q qVar = this.RQ.RB;
        qVar.SJ += i2;
    }

    public final void B(int i, int i2) {
        this.RQ.d(i, i2, false);
        this.RQ.RE = true;
    }

    public final void a(int i, int i2, Object obj) {
        int i3;
        RecyclerView recyclerView = this.RQ;
        int eO = recyclerView.QQ.eO();
        int i4 = i + i2;
        for (i3 = 0; i3 < eO; i3++) {
            View aW = recyclerView.QQ.aW(i3);
            t aY = RecyclerView.aY(aW);
            if (aY != null && !aY.gk() && aY.mPosition >= i && aY.mPosition < i4) {
                aY.addFlags(2);
                aY.T(obj);
                ((LayoutParams) aW.getLayoutParams()).Si = true;
            }
        }
        RecyclerView$m recyclerView$m = recyclerView.QN;
        eO = i + i2;
        for (i3 = recyclerView$m.Sp.size() - 1; i3 >= 0; i3--) {
            t tVar = (t) recyclerView$m.Sp.get(i3);
            if (tVar != null) {
                i4 = tVar.gl();
                if (i4 >= i && i4 < eO) {
                    tVar.addFlags(2);
                    recyclerView$m.bu(i3);
                }
            }
        }
        this.RQ.RF = true;
    }

    public final void d(b bVar) {
        f(bVar);
    }

    private void f(b bVar) {
        switch (bVar.nc) {
            case 1:
                this.RQ.QV.F(bVar.LY, bVar.Ma);
                return;
            case 2:
                this.RQ.QV.G(bVar.LY, bVar.Ma);
                return;
            case 4:
                this.RQ.QV.H(bVar.LY, bVar.Ma);
                return;
            case 8:
                this.RQ.QV.I(bVar.LY, bVar.Ma);
                return;
            default:
                return;
        }
    }

    public final void e(b bVar) {
        f(bVar);
    }

    public final void C(int i, int i2) {
        int i3;
        RecyclerView recyclerView = this.RQ;
        int eO = recyclerView.QQ.eO();
        for (i3 = 0; i3 < eO; i3++) {
            t aY = RecyclerView.aY(recyclerView.QQ.aW(i3));
            if (!(aY == null || aY.gk() || aY.mPosition < i)) {
                aY.o(i2, false);
                recyclerView.RB.SK = true;
            }
        }
        RecyclerView$m recyclerView$m = recyclerView.QN;
        int size = recyclerView$m.Sp.size();
        for (i3 = 0; i3 < size; i3++) {
            t tVar = (t) recyclerView$m.Sp.get(i3);
            if (tVar != null && tVar.mPosition >= i) {
                tVar.o(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.RQ.RE = true;
    }

    public final void D(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        RecyclerView recyclerView = this.RQ;
        int eO = recyclerView.QQ.eO();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (i6 = 0; i6 < eO; i6++) {
            t aY = RecyclerView.aY(recyclerView.QQ.aW(i6));
            if (aY != null && aY.mPosition >= i5 && aY.mPosition <= i4) {
                if (aY.mPosition == i) {
                    aY.o(i2 - i, false);
                } else {
                    aY.o(i3, false);
                }
                recyclerView.RB.SK = true;
            }
        }
        RecyclerView$m recyclerView$m = recyclerView.QN;
        if (i < i2) {
            i4 = i2;
            i5 = i;
        } else {
            i7 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = recyclerView$m.Sp.size();
        for (i6 = 0; i6 < size; i6++) {
            t tVar = (t) recyclerView$m.Sp.get(i6);
            if (tVar != null && tVar.mPosition >= r4 && tVar.mPosition <= r3) {
                if (tVar.mPosition == i) {
                    tVar.o(i2 - i, false);
                } else {
                    tVar.o(i7, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.RQ.RE = true;
    }
}
