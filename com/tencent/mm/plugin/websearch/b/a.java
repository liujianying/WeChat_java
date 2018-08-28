package com.tencent.mm.plugin.websearch.b;

import android.text.TextUtils;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import org.xwalk.core.Log;

public final class a implements e {
    public final void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            Log.w("RelevantSearchService", "empty query");
            if (dVar != null) {
                dVar.a(false, null, null, null);
            }
        }
        com.tencent.mm.plugin.websearch.a.a aVar = new com.tencent.mm.plugin.websearch.a.a(str);
        v.a(aVar.diG, new 1(this, dVar, aVar));
    }

    public final void ah(String str, String str2, String str3) {
        ad.a(str, str2, System.currentTimeMillis(), str3);
    }

    public final void g(String str, String str2, int i, String str3) {
        ad.h(str, str2, i, str3);
    }
}
