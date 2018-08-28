package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.base.a;
import java.util.Locale;

final class ae extends a {
    final int fgJ;
    final int fgK;
    final aq.a fgL;

    static String r(String str, int i, int i2) {
        return String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    ae(String str, int i, int i2, String str2, aq.a aVar) {
        boolean z = false;
        super(r(str, i, i2), ah.abY() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)}), str2, str, 0, i2);
        this.fgJ = i;
        this.fgK = i2;
        this.fgL = aVar;
        if (!"@LibraryAppId".equals(str)) {
            z = true;
        }
        this.fin = z;
    }

    public final String abR() {
        return ai.ag(this.appId, this.fgK);
    }
}
