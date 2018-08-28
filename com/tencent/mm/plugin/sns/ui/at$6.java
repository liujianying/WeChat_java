package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.an.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bsu;

class at$6 implements OnClickListener {
    final /* synthetic */ at nZP;

    at$6(at atVar) {
        this.nZP = atVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof bsu) {
            bsu bsu = (bsu) view.getTag();
            if (at.NZ(bsu.ksA)) {
                h.mEJ.k(10231, "1");
                b.PW();
            } else {
                h.mEJ.k(10090, "1,0");
                if (!(a.by(at.a(this.nZP)) || a.bw(at.a(this.nZP)))) {
                    avq a = ((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(af.Gq(), bsu, 8);
                    a.rYz = at.b(this.nZP);
                    b.b(a);
                }
            }
            this.nZP.notifyDataSetChanged();
        }
    }
}
