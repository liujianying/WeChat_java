package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.sdk.platformtools.x;

class g$b implements a<g.a, Bundle> {
    private g$b() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        g.a aVar = (g.a) obj;
        Bundle bundle = new Bundle();
        View sv = e.aeR().sv(aVar.id);
        if (sv instanceof h) {
            ((h) sv).b(aVar.cbJ, new 1(this, bundle, cVar));
            return;
        }
        x.i("MicroMsg.IPCInvoke_RequestMakePhoneCall", "makePhoneCall failed, view is not a instance of DynamicPageAccessible.(%s)", aVar.id);
        bundle.putBoolean("ret", false);
        bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
        cVar.at(bundle);
    }
}
