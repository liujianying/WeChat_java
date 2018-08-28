package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class k extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new is();
        aVar.dIH = new it();
        aVar.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        aVar.dIF = 1705;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1705;
    }

    public k(String str, bij bij, int i, String str2) {
        aOR();
        if (!(8 == i && 9 == i)) {
            x.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[]{Integer.valueOf(i)});
        }
        is isVar = (is) this.diG.dID.dIL;
        isVar.riA = str;
        isVar.rjX = bij;
        isVar.qZe = i;
        isVar.qZf = str2;
    }

    public final String aPf() {
        LinkedList linkedList = ((it) this.diG.dIE.dIL).rjY;
        if (linkedList == null || linkedList.size() != 1) {
            return null;
        }
        return ((cs) linkedList.get(0)).rcP;
    }
}
