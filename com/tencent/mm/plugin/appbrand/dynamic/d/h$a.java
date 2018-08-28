package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.h.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.sdk.platformtools.x;

class h$a implements a<b, Bundle> {
    private h$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        b bVar = (b) obj;
        Bundle bundle = new Bundle();
        View sv = e.aeR().sv(bVar.id);
        if (sv instanceof h) {
            ((h) sv).a(bVar.fwf, bVar.cca, bVar.fwg, new 1(this, bundle, cVar));
            return;
        }
        x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "onTapCallback failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{bVar.id});
        bundle.putBoolean("ret", false);
        bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
        cVar.at(bundle);
    }
}
