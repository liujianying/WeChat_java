package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;

class a$d implements a<Bundle, Bundle> {
    private a$d() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        c su = d.aeQ().su(((Bundle) obj).getString("id"));
        if (su == null) {
            x.e("MicroMsg.IPCInvoke_OnPause", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{r0});
            return;
        }
        b.o(new 1(this, su));
    }
}
