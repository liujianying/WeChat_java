package com.tencent.mm.ui;

import com.tencent.mm.s.a.a;
import com.tencent.mm.storage.aa;

class ab$1 implements a {
    final /* synthetic */ ab toE;

    ab$1(ab abVar) {
        this.toE = abVar;
    }

    public final void gl(int i) {
        if (i == 262145 || i == 266260 || i == 262157 || i == 266267 || i == 262158) {
            ab.a(this.toE);
            ab.b(this.toE);
        } else if (i == 262147) {
            ab.c(this.toE);
        } else if (i == 262156) {
            ab.d(this.toE);
        } else if (i == 262152) {
            ab.e(this.toE);
        }
        ab.f(this.toE).notifyDataSetChanged();
    }

    public final void gm(int i) {
    }

    public final void b(aa.a aVar) {
        if (aVar == aa.a.sPM) {
            ab.e(this.toE);
        } else if (aVar == aa.a.sPN) {
            ab.e(this.toE);
        } else if (aVar == aa.a.sYc) {
            ab.d(this.toE);
        } else if (aVar == aa.a.sZC) {
            ab.a(this.toE);
        }
        ab.f(this.toE).notifyDataSetChanged();
    }
}
