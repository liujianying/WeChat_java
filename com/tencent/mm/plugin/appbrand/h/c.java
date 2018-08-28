package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c implements a {
    public final String h(Map<String, String> map, String str) {
        if (map != null && !map.isEmpty()) {
            return bi.oV((String) map.get(str + ".title"));
        }
        x.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
        return "";
    }
}
