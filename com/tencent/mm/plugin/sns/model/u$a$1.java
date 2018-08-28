package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import android.support.design.a$i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.u.a;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class u$a$1 extends ag {
    final /* synthetic */ a noD;

    u$a$1(a aVar) {
        this.noD = aVar;
    }

    public final void handleMessage(Message message) {
        if (this.noD.iWX == null || this.noD.iWX.isEmpty()) {
            u uVar = this.noD.noA;
            bpr bpr = (bpr) uVar.diG.dIE.dIL;
            bpq bpq = (bpq) uVar.diG.dID.dIL;
            byte[] g = z.g(bpq.rny.siK.toByteArray(), bpr.rny.siK.toByteArray());
            if (g != null && g.length > 0) {
                g.Ek();
                g.Ei().DT().set(8195, bi.bE(g));
            }
            bpq.rny.bq(g);
            if ((bpr.rlm & bpq.rnx) == 0) {
                uVar.diJ.a(0, 0, "", uVar);
                return;
            } else {
                uVar.a(uVar.dIX, uVar.diJ);
                return;
            }
        }
        final pm pmVar = (pm) this.noD.iWX.getFirst();
        x.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + pmVar.rtM);
        this.noD.iWX.removeFirst();
        switch (pmVar.rtM) {
            case a$i.AppCompatTheme_actionDropDownStyle /*45*/:
                af.bxY().post(new Runnable() {
                    public final void run() {
                        if (!u$a$1.this.noD.noA.a(pmVar, u$a$1.this.noD.iWY)) {
                            u$a$1.this.noD.iWY.sendEmptyMessage(0);
                        }
                    }
                });
                return;
            case a$i.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                af.bxY().post(new 2(this, pmVar));
                return;
            default:
                return;
        }
    }
}
