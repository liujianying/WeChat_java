package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class j$a$2 implements d {
    final /* synthetic */ a nMj;

    j$a$2(a aVar) {
        this.nMj = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 4;
        switch (menuItem.getItemId()) {
            case 0:
                this.nMj.nMb.jdw.setText(a.a(this.nMj));
                h.bA(j.c(this.nMj.nMb), j.c(this.nMj.nMb).getString(j.app_copy_ok));
                if (a.b(this.nMj) != null) {
                    String gd = bi.gd(v.NE(a.c(this.nMj).bSZ));
                    int i3 = com.tencent.mm.plugin.secinforeport.a.a.mOt;
                    com.tencent.mm.plugin.secinforeport.a.a.f(4, gd + ":" + a.b(this.nMj).smh, bi.WK(a.a(this.nMj).toString()));
                    return;
                }
                return;
            case 1:
                x.e("MicroMsg.BaseTimeLine", "del snsId:" + a.c(this.nMj).bSZ + " commentId:" + a.b(this.nMj));
                long NE = v.NE(a.c(this.nMj).bSZ);
                if (v.ND(a.c(this.nMj).bSZ)) {
                    i2 = 6;
                }
                r rVar = new r(NE, i2, a.b(this.nMj));
                g.Ek();
                g.Eh().dpP.a(rVar, 0);
                j jVar = this.nMj.nMb;
                Context c = j.c(this.nMj.nMb);
                j.c(this.nMj.nMb).getString(j.app_tip);
                jVar.nLY = h.a(c, j.c(this.nMj.nMb).getString(j.sns_deling_sns), true, new 1(this, rVar));
                return;
            default:
                return;
        }
    }
}
