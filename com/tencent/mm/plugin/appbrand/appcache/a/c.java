package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.by.g;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public enum c implements m {
    ;

    private c(String str) {
    }

    public final b a(String str, Map<String, String> map, a aVar) {
        String str2 = (String) map.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
        if (!bi.oW(str2)) {
            g.cC(str2).j(new 1(this));
        }
        return null;
    }
}
