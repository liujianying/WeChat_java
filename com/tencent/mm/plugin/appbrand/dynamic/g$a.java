package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.f.d;
import java.util.Collection;

final class g$a implements a<Bundle, Bundle> {
    private g$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Collection<c> values = d.aeQ().fuE.values();
        if (values != null && !values.isEmpty()) {
            d dVar = new d();
            String str = dVar.name;
            String jSONObject = dVar.tR().toString();
            for (c cVar2 : values) {
                if (cVar2 != null) {
                    cVar2.bg(str, jSONObject);
                }
            }
        }
    }
}
