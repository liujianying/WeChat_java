package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.x;

public class h$a {
    static void qD(String str) {
        e.deleteFile(str);
        try {
            Runtime.getRuntime().exec("rm -r " + str + "_xdir");
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[]{str + "_xdir", e});
        }
    }
}
