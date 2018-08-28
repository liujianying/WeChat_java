package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.sdk.platformtools.x;

class a$a implements a<Bundle, Bundle> {
    private a$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("id");
        String string2 = bundle.getString("appId");
        Bundle bundle2 = bundle.getBundle("extData");
        c su = d.aeQ().su(string);
        if (su == null) {
            x.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            s.i("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            return;
        }
        b.o(new 1(this, su, string, string2, bundle2));
    }
}
