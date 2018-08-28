package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements n {
    public static m ezn;
    public static l ezo;

    public final void a(m mVar) {
        ezn = mVar;
    }

    public final void a(l lVar) {
        ezo = lVar;
    }

    public static void g(int i, Object obj) {
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? "null" : obj.toString();
        x.i(str, str2, objArr);
        g.Ek();
        g.Ei().DT().set(i, obj);
    }
}
