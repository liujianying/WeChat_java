package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.an.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;

class bg$2 implements OnClickListener {
    final /* synthetic */ bg ohJ;

    bg$2(bg bgVar) {
        this.ohJ = bgVar;
    }

    public final void onClick(View view) {
        boolean z = view.getTag() instanceof r;
        x.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click " + z);
        if (z) {
            r rVar = (r) view.getTag();
            bsu bsu = rVar.nMH;
            if (bg.KK(bsu.ksA)) {
                h.mEJ.k(10231, "1");
                b.PW();
            } else if (!(a.by(this.ohJ.context) || a.bw(this.ohJ.context))) {
                h.mEJ.k(10090, "1,0");
                if (bsu.sqc.ruA.size() > 0) {
                    com.tencent.mm.modelsns.b io;
                    String str;
                    ate ate = (ate) bsu.sqc.ruA.get(0);
                    if (this.ohJ.scene == 0) {
                        io = com.tencent.mm.modelsns.b.io(738);
                    } else {
                        io = com.tencent.mm.modelsns.b.ip(738);
                    }
                    com.tencent.mm.modelsns.b nb = io.nb(bsu.ksA).nb(bsu.hbL);
                    if (bsu.sqb == null) {
                        str = "";
                    } else {
                        str = bsu.sqb.ksA;
                    }
                    nb.nb(str).nb(ate.bHD).nb(ate.jOS).nb("");
                    io.RD();
                }
                if (rVar.nMI) {
                    b.a(((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(af.Gq(), bsu, 9));
                } else {
                    b.b(((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(af.Gq(), bsu, 1));
                }
            }
            if (this.ohJ.oht != null) {
                this.ohJ.oht.bDg();
            }
        }
    }
}
