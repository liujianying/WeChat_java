package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class r {
    private static volatile Boolean fek = null;

    public static boolean aaM() {
        if (fek == null) {
            boolean z;
            a aVar = b.dnp;
            c fJ = a.fJ("100400");
            if (fJ == null || !fJ.isValid() || bi.getInt((String) fJ.ckq().get("openIsolateContext"), 0) <= 0) {
                z = false;
            } else {
                z = true;
            }
            fek = Boolean.valueOf(z);
            x.i("MicroMsg.AppBrand.MultiContextABTests", "openLibraryIsolateContext init value = %B", new Object[]{fek});
        }
        return fek.booleanValue();
    }
}
