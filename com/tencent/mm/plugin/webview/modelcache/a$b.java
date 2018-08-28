package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.plugin.webview.modelcache.a.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

final class a$b extends i<a> {
    public final boolean fAQ;

    static /* synthetic */ void a(a$b a_b, String str, long j) {
        if (a_b.fAQ) {
            a aVar = new a((byte) 0);
            aVar.field_appId = str;
            if (a_b.b(aVar, new String[0])) {
                aVar.field_occupation += j;
                a_b.c(aVar, new String[0]);
                return;
            }
            aVar.field_occupation = j;
            a_b.b(aVar);
        }
    }

    public a$b(e eVar) {
        super(eVar, a.bUF(), "WebViewCacheAppIdOccupation", null);
        this.fAQ = eVar != null;
    }
}
