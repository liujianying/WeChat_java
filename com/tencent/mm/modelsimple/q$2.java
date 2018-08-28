package com.tencent.mm.modelsimple;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class q$2 implements a {
    final /* synthetic */ q efS;
    final /* synthetic */ e efU;

    q$2(q qVar, e eVar) {
        this.efS = qVar;
        this.efU = eVar;
    }

    public final void a(com.tencent.mm.network.e eVar) {
        if (eVar == null || eVar.Lr() == null || this.efU.erT == null || this.efU.qWn == null || this.efU.qWn.srN == null) {
            f.mDy.a(148, 8, 1, false);
            x.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
            return;
        }
        x.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", new Object[]{bi.Xf(bi.bB(this.efU.erT)), Integer.valueOf(this.efU.qWn.srN.iwE)});
        eVar.Lr().x(this.efU.erT, this.efU.qWn.srN.iwE);
    }
}
