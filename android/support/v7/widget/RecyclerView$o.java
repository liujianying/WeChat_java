package android.support.v7.widget;

import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.c;

class RecyclerView$o extends c {
    final /* synthetic */ RecyclerView RQ;

    private RecyclerView$o(RecyclerView recyclerView) {
        this.RQ = recyclerView;
    }

    /* synthetic */ RecyclerView$o(RecyclerView recyclerView, byte b) {
        this(recyclerView);
    }

    public final void onChanged() {
        this.RQ.O(null);
        RecyclerView.h(this.RQ);
        this.RQ.RB.SK = true;
        RecyclerView.n(this.RQ);
        if (!this.RQ.QP.eE()) {
            this.RQ.requestLayout();
        }
    }

    public final void c(int i, int i2, Object obj) {
        Object obj2 = 1;
        this.RQ.O(null);
        e eVar = this.RQ.QP;
        eVar.LR.add(eVar.a(4, i, i2, obj));
        eVar.LX |= 4;
        if (eVar.LR.size() != 1) {
            obj2 = null;
        }
        if (obj2 != null) {
            gg();
        }
    }

    public final void ac(int i, int i2) {
        int i3 = 1;
        this.RQ.O(null);
        e eVar = this.RQ.QP;
        eVar.LR.add(eVar.a(1, i, i2, null));
        eVar.LX |= 1;
        if (eVar.LR.size() != 1) {
            i3 = 0;
        }
        if (i3 != 0) {
            gg();
        }
    }

    public final void ad(int i, int i2) {
        Object obj = 1;
        this.RQ.O(null);
        e eVar = this.RQ.QP;
        eVar.LR.add(eVar.a(2, i, i2, null));
        eVar.LX |= 2;
        if (eVar.LR.size() != 1) {
            obj = null;
        }
        if (obj != null) {
            gg();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ae(int r6, int r7) {
        /*
        r5 = this;
        r4 = 0;
        r0 = 1;
        r1 = r5.RQ;
        r1.O(r4);
        r1 = r5.RQ;
        r1 = r1.QP;
        if (r6 == r7) goto L_0x002c;
    L_0x000d:
        r2 = r1.LR;
        r3 = 8;
        r3 = r1.a(r3, r6, r7, r4);
        r2.add(r3);
        r2 = r1.LX;
        r2 = r2 | 8;
        r1.LX = r2;
        r1 = r1.LR;
        r1 = r1.size();
        if (r1 != r0) goto L_0x002c;
    L_0x0026:
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r5.gg();
    L_0x002b:
        return;
    L_0x002c:
        r0 = 0;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView$o.ae(int, int):void");
    }

    private void gg() {
        if (RecyclerView.o(this.RQ) && RecyclerView.p(this.RQ) && RecyclerView.q(this.RQ)) {
            z.a(this.RQ, RecyclerView.r(this.RQ));
            return;
        }
        RecyclerView.s(this.RQ);
        this.RQ.requestLayout();
    }
}
