package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class ag extends i<af> {
    public static final String[] diD = new String[]{i.a(af.dhO, "WebviewLocalData")};

    public ag(e eVar) {
        super(eVar, af.dhO, "WebviewLocalData", null);
    }

    public static int ak(String str, String str2, String str3) {
        return (str + str2 + str3).hashCode();
    }
}
