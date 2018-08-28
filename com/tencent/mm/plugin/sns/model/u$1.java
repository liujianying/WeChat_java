package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class u$1 implements Runnable {
    final /* synthetic */ u noA;
    final /* synthetic */ boy noy;
    final /* synthetic */ ag noz;

    u$1(u uVar, boy boy, ag agVar) {
        this.noA = uVar;
        this.noy = boy;
        this.noz = agVar;
    }

    public final void run() {
        if (!this.noy.rdS.equals(u.a(this.noA))) {
            g.Ek();
            if (g.Eg().Dx()) {
                g.Ek();
                String str = (String) g.Ei().DT().get(68377, null);
                g.Ek();
                if (!(bi.a((Integer) g.Ei().DT().get(68400, null), 0) == this.noy.lOH && (bi.oW(str) || str.equals(this.noy.rdS)))) {
                    g.Ek();
                    g.Ei().DT().set(68377, this.noy.rdS);
                    g.Ek();
                    g.Ei().DT().set(68400, Integer.valueOf(this.noy.lOH));
                    g.Ek();
                    g.Ei().DT().set(68418, i.eF(this.noy.rlK));
                }
                for (ap HH : u.afl()) {
                    HH.HH();
                }
            } else {
                x.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                return;
            }
        }
        this.noz.sendEmptyMessage(0);
    }
}
