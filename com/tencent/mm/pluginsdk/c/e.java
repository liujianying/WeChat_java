package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.rg;
import com.tencent.mm.sdk.b.a;

public final class e {
    public static rg SG(String str) {
        rg rgVar = new rg();
        rgVar.cbZ.bNI = 1;
        rgVar.cbZ.cca = str;
        a.sFg.m(rgVar);
        return rgVar;
    }

    public static void SH(String str) {
        rg rgVar = new rg();
        rgVar.cbZ.bNI = 2;
        rgVar.cbZ.cca = str;
        a.sFg.m(rgVar);
    }
}
