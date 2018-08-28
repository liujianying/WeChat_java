package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.protocal.c.xn;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class e extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new xn();
        aVar.dIH = new xo();
        aVar.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        aVar.dIF = 1781;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1781;
    }

    public e(LinkedList<xm> linkedList) {
        aOR();
        if (linkedList != null && linkedList.size() > 0) {
            ((xn) this.diG.dID.dIL).rDs = linkedList;
        }
    }

    protected final void b(int i, int i2, int i3, String str) {
        x.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (m.cC(i2, i3)) {
            j.aOO().aOv().post(new 1(this));
        }
    }

    public final LinkedList<xm> aPa() {
        xo xoVar = (xo) this.diG.dIE.dIL;
        if (xoVar == null) {
            return null;
        }
        return xoVar.rDs;
    }
}
