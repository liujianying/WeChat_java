package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.base.a;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;

public final class ah {
    final b fhg = new b(this);

    ah() {
    }

    public static String abY() {
        String str = g.Ei().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "appbrand/pkg/";
        h.Ey(str);
        return str;
    }

    public final int b(a aVar) {
        if (this.fhg.Tl(aVar.qBy)) {
            x.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[]{aVar.qBy});
            return 0;
        }
        x.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[]{aVar.qBy, Integer.valueOf(this.fhg.b(aVar))});
        return this.fhg.b(aVar);
    }
}
