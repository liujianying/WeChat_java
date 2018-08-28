package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsHeader.a;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;

class bb$7 implements a {
    final /* synthetic */ bb ogl;

    bb$7(bb bbVar) {
        this.ogl = bbVar;
    }

    public final boolean fm(long j) {
        if (bb.b(this.ogl) || bb.c(this.ogl).getType() == 1) {
            this.ogl.xE(2);
        } else {
            n nVar = new n();
            nVar.field_snsId = j;
            nVar.field_userName = bb.d(this.ogl);
            bsu RF = e.RF();
            RF.hbL = bb.d(this.ogl);
            nVar.c(RF);
            n Mk = aj.Mk(bb.d(this.ogl));
            x.d("MicroMsg.SnsActivity", "friend like %s", new Object[]{bb.d(this.ogl)});
            if (Mk == null) {
                am.a.a(nVar, 1, "");
            } else if (Mk.bBd()) {
                am.a.a(nVar, 1, "");
            } else {
                am.a.a(nVar, 5, "");
            }
            l Np = af.bys().Np(bb.d(this.ogl));
            Np.field_local_flag |= 2;
            af.bys().c(Np);
            bb.e(this.ogl);
        }
        return false;
    }

    public final boolean bDp() {
        bb.c(this.ogl).bEf();
        return false;
    }
}
