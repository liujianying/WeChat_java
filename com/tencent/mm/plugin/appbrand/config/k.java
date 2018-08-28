package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.cha;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class k extends a<gs> {
    k(List<String> list, a aVar) {
        x.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[]{Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.ordinal())});
        gr grVar = new gr();
        grVar.otY = aVar.ordinal();
        for (String str : list) {
            if (!bi.oW(str)) {
                cha cha = new cha();
                cha.spJ = str;
                cha.riB = r.sd(str);
                grVar.rgW.add(cha);
            }
        }
        b.a aVar2 = new b.a();
        aVar2.dIG = grVar;
        aVar2.dIH = new gs();
        aVar2.dIF = 1192;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
        this.diG = aVar2.KT();
    }
}
