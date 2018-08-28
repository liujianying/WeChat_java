package com.tencent.mm.booter;

import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CoreService$4 implements a {
    final /* synthetic */ CoreService cWM;

    CoreService$4(CoreService coreService) {
        this.cWM = coreService;
    }

    public final boolean vD() {
        boolean z;
        t a = CoreService.a(this.cWM);
        if (bi.bI(a.evU) < a.evS) {
            x.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.evU + ", cur=" + bi.VG() + ", retries=" + a.evV);
            if (a.evV <= 0) {
                z = false;
            } else {
                a.evV--;
                a.evU = bi.VG();
                z = true;
            }
        } else {
            a.evV = a.evT;
            a.evU = bi.VG();
            z = true;
        }
        if (z) {
            x.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isMMProcessExist:%b", new Object[]{Boolean.valueOf(bi.bC(CoreService.b(this.cWM).esl.DE())), Boolean.valueOf(aa.UZ().UG())});
            if (bi.bC(CoreService.b(this.cWM).esl.DE()) || r3 || !f.a(1, 0, null, CoreService.b(this.cWM).esl.DE(), bi.VF())) {
                CoreService.xw();
            } else {
                x.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                return true;
            }
        }
        x.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
        x.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[]{Long.valueOf(CoreService.c(this.cWM)), Long.valueOf(CoreService.d(this.cWM)), Long.valueOf(bi.VF() - CoreService.e(this.cWM))});
        CoreService.f(this.cWM);
        CoreService.g(this.cWM);
        CoreService.h(this.cWM);
        new al(new 1(this), false).J(500, 500);
        return true;
    }
}
