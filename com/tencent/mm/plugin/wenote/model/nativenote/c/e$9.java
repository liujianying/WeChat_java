package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class e$9 implements a {
    final /* synthetic */ e qsJ;

    e$9(e eVar) {
        this.qsJ = eVar;
    }

    public final boolean vD() {
        boolean z;
        x.d("NoteSelectManager", "onTimerExpired: ");
        RecyclerView a = e.a(this.qsJ);
        boolean z2 = e.c(this.qsJ) != null && e.c(this.qsJ).qrQ < ((float) e.a(this.qsJ, a));
        if (e.c(this.qsJ) == null || e.c(this.qsJ).qrQ <= ((float) e.d(this.qsJ))) {
            z = false;
        } else {
            z = true;
        }
        if (e.cD() && a != null && e.c(this.qsJ) != null && e.c(this.qsJ).getType() == 1 && (z2 || z)) {
            if (z2 && a.canScrollVertically(-1)) {
                if (e.c(this.qsJ).hER == 3) {
                    e.e(this.qsJ);
                }
                e.f(this.qsJ);
                this.qsJ.cax();
                this.qsJ.cav();
                a.smoothScrollBy(0, -300);
            } else if (z && a.canScrollVertically(1)) {
                e.f(this.qsJ);
                this.qsJ.cax();
                this.qsJ.cav();
                a.smoothScrollBy(0, 300);
            }
        } else if (e.g(this.qsJ) != null) {
            e.g(this.qsJ).SO();
        }
        return true;
    }
}
