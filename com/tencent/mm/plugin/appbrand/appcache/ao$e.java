package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ao.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.m;
import java.io.InputStream;

final class ao$e implements b<m> {
    private ao$e() {
    }

    /* synthetic */ ao$e(byte b) {
        this();
    }

    public final /* synthetic */ Object c(String str, InputStream inputStream) {
        return new m(s.Ui(str), "UTF-8", inputStream);
    }
}
