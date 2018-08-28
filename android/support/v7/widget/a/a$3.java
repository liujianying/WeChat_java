package android.support.v7.widget.a;

import android.support.v4.a.g;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.a.a.4;

class a$3 extends a$c {
    final /* synthetic */ a Yc;
    final /* synthetic */ int Yd;
    final /* synthetic */ RecyclerView$t Ye;

    a$3(a aVar, RecyclerView$t recyclerView$t, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView$t recyclerView$t2) {
        this.Yc = aVar;
        this.Yd = i3;
        this.Ye = recyclerView$t2;
        super(aVar, recyclerView$t, i, i2, f, f2, f3, f4);
    }

    public final void a(g gVar) {
        super.a(gVar);
        if (!this.Yt) {
            if (this.Yd <= 0) {
                this.Yc.XP.c(this.Yc.Sa, this.Ye);
            } else {
                this.Yc.XE.add(this.Ye.SU);
                this.Yq = true;
                if (this.Yd > 0) {
                    a aVar = this.Yc;
                    aVar.Sa.post(new 4(aVar, this, this.Yd));
                }
            }
            if (this.Yc.XX == this.Ye.SU) {
                this.Yc.bx(this.Ye.SU);
            }
        }
    }
}
