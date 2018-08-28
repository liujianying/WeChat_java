package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ac.e.a.b;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class i$1 implements Runnable {
    final /* synthetic */ b tOp;
    final /* synthetic */ i ujw;

    i$1(i iVar, b bVar) {
        this.ujw = iVar;
        this.tOp = bVar;
    }

    public final void run() {
        au.HU();
        ab Yg = c.FR().Yg(this.tOp.dKF);
        if (i.a(this.ujw) == null || i.a(this.ujw).size() <= 0 || !i.a(this.ujw).contains(this.tOp.dKF)) {
            if (Yg != null && ((int) Yg.dhP) > 0 && a.gd(Yg.field_type)) {
                if (i.a(this.ujw) != null) {
                    i.a(this.ujw).clear();
                }
                if (i.b(this.ujw) != null) {
                    i.b(this.ujw).clear();
                }
                if (i.c(this.ujw) != null) {
                    i.c(this.ujw).removeAllViews();
                }
                i.e(this.ujw);
                if (i.d(this.ujw) != null) {
                    i.d(this.ujw).FL(i.a(this.ujw).size());
                }
            }
        } else if (Yg == null || ((int) Yg.dhP) <= 0 || !a.gd(Yg.field_type)) {
            x.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", new Object[]{this.tOp.dKF});
            i.a(this.ujw).remove(this.tOp.dKF);
            if (i.a(this.ujw).size() > 0) {
                View view = (View) i.b(this.ujw).get(this.tOp.dKF);
                if (view != null && i.c(this.ujw) != null) {
                    i.c(this.ujw).removeView(view);
                    i.b(this.ujw).remove(view);
                }
            } else if (i.d(this.ujw) != null) {
                if (i.b(this.ujw) != null) {
                    i.b(this.ujw).clear();
                }
                if (i.c(this.ujw) != null) {
                    i.c(this.ujw).removeAllViews();
                }
                i.d(this.ujw).FL(i.a(this.ujw).size());
            }
        }
    }
}
