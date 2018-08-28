package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.u.b.b$a;

class n$1 implements c<Bundle> {
    final /* synthetic */ b$a fvZ;
    final /* synthetic */ n fwn;

    n$1(n nVar, b$a b_a) {
        this.fwn = nVar;
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
        this.fvZ.aA(this.fwn.a(z, str, bundle));
    }
}
