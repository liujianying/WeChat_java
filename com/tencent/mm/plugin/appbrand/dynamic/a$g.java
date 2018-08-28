package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;

class a$g implements a<Bundle, Bundle> {
    private a$g() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("id");
        Bundle bundle2 = bundle.getBundle("__env_args");
        if (bundle2 == null) {
            x.i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
            return;
        }
        c su = d.aeQ().su(string);
        if (su == null) {
            x.e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            return;
        }
        su.n(bundle2);
    }
}
