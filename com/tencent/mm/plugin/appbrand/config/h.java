package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.bi;

public final class h {
    public static boolean rO(String str) {
        if (bi.oW(str)) {
            return false;
        }
        AppBrandSysConfig qa = a.qa(str);
        if (qa == null || qa.fqw || qa.frm.fih == 0) {
            return false;
        }
        return true;
    }
}
