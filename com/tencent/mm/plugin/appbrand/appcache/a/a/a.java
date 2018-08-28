package com.tencent.mm.plugin.appbrand.appcache.a.a;

import com.tencent.mm.plugin.appbrand.appcache.a.d.c;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class a implements com.tencent.mm.vending.c.a<Boolean, c> {
    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        String str = cVar.field_appId;
        int i = cVar.field_version;
        String str2 = cVar.field_pkgMd5;
        int i2 = cVar.field_type;
        r rVar = new r(str, "");
        final boolean z = cVar.field_retriedCount > 0;
        final int i3 = cVar.field_reportId;
        final b cBF = g.cBF();
        cBF.cBE();
        akl akl = new akl();
        akl.bPS = str;
        akl.rkb = i;
        akl.rNa = 0;
        akl.rMZ = str2;
        if (bi.oW("")) {
            akl.rNa = 0;
        } else {
            akl.rLl = "";
            akl.rNa = 4;
        }
        akl.rNc = new ayx();
        akl.rNc.sbF = 0;
        akl.rNc.sbG = 1;
        int i4 = z ? 51 : 46;
        int i5 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) i3, (long) i4);
        new com.tencent.mm.plugin.appbrand.appcache.b(akl).KM().j(new 2(this, cBF, z, i3)).g(new a()).g(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                int i = ((Boolean) obj).booleanValue() ? z ? 52 : 47 : z ? 53 : 48;
                int i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) i3, (long) i);
                cBF.v(new Object[]{r5});
                return uQG;
            }
        });
        return Boolean.TRUE;
    }
}
