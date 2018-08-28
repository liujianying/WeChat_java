package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.e.g.4;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class g$3 implements e {
    final /* synthetic */ g jkP;

    g$3(g gVar) {
        this.jkP = gVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            a aVar = (a) lVar;
            x.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", new Object[]{aVar.aOS()});
            ep aOY = aVar.aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK});
                j.aON().aOv().post(new 4(this.jkP, r0, aOY));
                return;
            }
            g.c(this.jkP);
            return;
        }
        g.c(this.jkP);
    }
}
