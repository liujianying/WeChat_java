package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.car;

class k$1 implements e {
    final /* synthetic */ k oOb;

    k$1(k kVar) {
        this.oOb = kVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eV("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
        try {
            car car = (car) this.oOb.bLq();
            if (car.sxa == 0 || car.sxb == 0) {
                a.eT("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + car.sxb);
            } else if (this.oOb.oKs.oJC != 1) {
                a.eT("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.oOb.oKs.oJC);
            } else {
                this.oOb.oKs.oJC = 2;
                this.oOb.oKs.oJE = car.swW;
                v2protocal v2protocal = this.oOb.oKs.oJX;
                if (v2protocal.oPy != 0) {
                    a.eU("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                    return;
                }
                v2protocal.oPy = car.swW;
                v2protocal.field_SpeedTestSvrParaArray = a.a(car);
                v2protocal.StartSpeedTest(car.swW, car.sxb);
            }
        } catch (Exception e) {
            this.oOb.oKs.oJC = 0;
        }
    }
}
