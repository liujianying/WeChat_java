package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.bsc;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.protocal.c.go;
import java.util.List;

public final class a extends com.tencent.mm.ab.a<go> {
    private final b diG;

    /* synthetic */ a(List list, byte b) {
        this(list);
    }

    private a(List<bsc> list) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        gn gnVar = new gn();
        gnVar.rgW.addAll(list);
        aVar.dIG = gnVar;
        aVar.dIH = new go();
        aVar.dIF = 2763;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
        b KT = aVar.KT();
        this.diG = KT;
        this.diG = KT;
    }
}
