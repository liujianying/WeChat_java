package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.protocal.c.x;

public final class c extends a<x> {
    public c(int i, int i2, int i3, String str, int i4, int i5, String str2) {
        b.a aVar = new b.a();
        w wVar = new w();
        wVar.limit = i;
        wVar.offset = i2;
        wVar.type = i3;
        wVar.qYQ = str;
        wVar.qYR = i4;
        wVar.qYS = i5;
        wVar.qYT = str2;
        aVar.dIG = wVar;
        aVar.dIH = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.dIF = 1676;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2});
    }

    public c(int i, int i2, int i3) {
        b.a aVar = new b.a();
        w wVar = new w();
        wVar.limit = i;
        wVar.offset = i2;
        wVar.type = i3;
        aVar.dIG = wVar;
        aVar.dIH = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.dIF = 1676;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
