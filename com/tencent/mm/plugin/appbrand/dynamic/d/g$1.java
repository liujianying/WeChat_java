package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.u.b.b$a;

class g$1 implements c<Bundle> {
    final /* synthetic */ b$a fvZ;
    final /* synthetic */ g fwa;

    g$1(g gVar, b$a b_a) {
        this.fwa = gVar;
        this.fvZ = b_a;
    }

    public final /* synthetic */ void at(Object obj) {
        Bundle bundle;
        String str;
        Bundle bundle2 = (Bundle) obj;
        boolean z = false;
        if (bundle2 != null) {
            z = bundle2.getBoolean("ret");
            String string = bundle2.getString("reason");
            bundle = bundle2.getBundle("data");
            str = string;
        } else {
            bundle = null;
            str = null;
        }
        this.fvZ.aA(this.fwa.a(z, str, bundle));
    }
}
