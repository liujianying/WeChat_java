package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public static boolean a(String str, int i, int i2, String str2, a aVar) {
        return aq.a(new ae(str, i, i2, str2, aVar), aVar);
    }

    static int z(String str, String str2, String str3) {
        int i = 1;
        try {
            return WABSPatch.bspatch(str, str2, str3);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[]{e, str, str2, str3});
            return i;
        }
    }
}
