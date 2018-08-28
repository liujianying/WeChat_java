package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.g.a.qt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<qt> {
    final /* synthetic */ a ooP;

    a$1(a aVar) {
        this.ooP = aVar;
        this.sFo = qt.class.getName().hashCode();
    }

    private boolean a(qt qtVar) {
        long bFD;
        boolean fs;
        switch (qtVar.cbp.action) {
            case 1:
            case 2:
            case 3:
                g.bFI();
                if (a.bFF()) {
                    this.ooP.bFE();
                    bFD = this.ooP.bFD();
                    if (qtVar.cbp.action == 1) {
                        fs = this.ooP.fs(bFD);
                    } else if (n.F(this.ooP.bFC(), bFD)) {
                        fs = this.ooP.fs(bFD);
                    } else {
                        fs = false;
                    }
                    x.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", new Object[]{Integer.valueOf(qtVar.cbp.action), Long.valueOf(bFD), Boolean.valueOf(fs)});
                    break;
                }
                break;
            case 4:
            case 5:
                g.bFI();
                if (a.bFF()) {
                    this.ooP.bFE();
                    bFD = this.ooP.bFD();
                    a aVar = this.ooP;
                    if (aVar.ooM == 0) {
                        aVar.ooM = i.L(3, 0);
                    }
                    boolean E = n.E(aVar.ooM, System.currentTimeMillis());
                    if (n.F(this.ooP.bFC(), bFD) || E) {
                        fs = this.ooP.fs(bFD);
                    } else {
                        fs = false;
                    }
                    x.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", new Object[]{Integer.valueOf(qtVar.cbp.action), Long.valueOf(bFD), Boolean.valueOf(fs), Boolean.valueOf(E), Boolean.valueOf(r5)});
                    break;
                }
                break;
        }
        return false;
    }
}
