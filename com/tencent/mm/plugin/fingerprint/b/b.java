package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.bq.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<bq> implements e {
    private bq jgp;
    private boolean jgq;

    public b() {
        this.jgq = false;
        this.sFo = bq.class.getName().hashCode();
    }

    private boolean a(bq bqVar) {
        if (g.Eg().Dx()) {
            this.jgq = false;
            if (!(bqVar instanceof bq)) {
                return false;
            }
            this.jgp = bqVar;
            x.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
            g.Ek();
            g.Eh().dpP.a(385, this);
            d dVar = new d();
            g.Ek();
            g.Eh().dpP.a(dVar, 0);
            return true;
        }
        x.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof d) {
            a aVar = new a();
            x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                aVar.retCode = 0;
            } else {
                x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                aVar.retCode = i2;
            }
            g.Ek();
            g.Eh().dpP.b(385, this);
            this.jgp.bJb = aVar;
            this.jgq = true;
            if (this.jgp.bJX != null) {
                this.jgp.bJX.run();
            }
            if (this.jgq) {
                this.jgp = null;
            }
        }
    }
}
