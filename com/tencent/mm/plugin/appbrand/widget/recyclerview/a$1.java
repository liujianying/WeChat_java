package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView$c;

class a$1 extends RecyclerView$c {
    final /* synthetic */ a gPS;

    a$1(a aVar) {
        this.gPS = aVar;
    }

    public final void onChanged() {
        this.gPS.RR.notifyChanged();
    }

    public final void ab(int i, int i2) {
        this.gPS.X((a.a(this.gPS).isEmpty() ? 0 : 1) + i, i2);
    }

    public final void c(int i, int i2, Object obj) {
        this.gPS.b((a.a(this.gPS).isEmpty() ? 0 : 1) + i, i2, obj);
    }

    public final void ac(int i, int i2) {
        this.gPS.Z((a.a(this.gPS).isEmpty() ? 0 : 1) + i, i2);
    }

    public final void ad(int i, int i2) {
        this.gPS.aa((a.a(this.gPS).isEmpty() ? 0 : 1) + i, i2);
    }

    public final void ae(int i, int i2) {
        int i3;
        int i4 = 0;
        a aVar = this.gPS;
        if (a.a(this.gPS).isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        i3 += i;
        if (!a.a(this.gPS).isEmpty()) {
            i4 = 1;
        }
        aVar.Y(i3, i4 + i2);
    }
}
