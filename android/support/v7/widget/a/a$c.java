package android.support.v7.widget.a;

import android.support.v4.a.a;
import android.support.v4.a.b;
import android.support.v4.a.g;
import android.support.v7.widget.RecyclerView$t;

class a$c implements b {
    final RecyclerView$t Sh;
    final int XQ;
    final /* synthetic */ a Yc;
    final float Yk;
    final float Yl;
    final float Ym;
    final float Yn;
    final g Yo;
    final int Yp;
    public boolean Yq;
    float Yr;
    float Ys;
    boolean Yt = false;
    float mf;
    boolean mh = false;

    public a$c(a aVar, RecyclerView$t recyclerView$t, int i, int i2, float f, float f2, float f3, float f4) {
        this.Yc = aVar;
        this.XQ = i2;
        this.Yp = i;
        this.Sh = recyclerView$t;
        this.Yk = f;
        this.Yl = f2;
        this.Ym = f3;
        this.Yn = f4;
        this.Yo = a.bb();
        this.Yo.a(new 1(this, aVar));
        this.Yo.w(recyclerView$t.SU);
        this.Yo.a(this);
        this.mf = 0.0f;
    }

    public void a(g gVar) {
        if (!this.mh) {
            this.Sh.T(true);
        }
        this.mh = true;
    }

    public final void bc() {
        this.mf = 1.0f;
    }
}
