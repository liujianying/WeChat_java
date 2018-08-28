package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.b;

class b$a implements a<Bundle, Bundle> {
    private b$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        boolean z = false;
        Bundle bundle = (Bundle) obj;
        if (bundle != null && bundle.getBoolean("forceKillProcess", false)) {
            z = true;
        }
        if (z) {
            b.afu();
        } else {
            b.aft();
        }
        cVar.at(null);
    }
}
