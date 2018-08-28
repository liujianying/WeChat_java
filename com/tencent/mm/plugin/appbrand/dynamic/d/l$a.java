package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.sdk.platformtools.x;

class l$a implements a<com.tencent.mm.plugin.appbrand.dynamic.widget.a.a, Bundle> {
    private l$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar = (com.tencent.mm.plugin.appbrand.dynamic.widget.a.a) obj;
        Bundle bundle = new Bundle();
        View sv = e.aeR().sv(aVar.id);
        if (sv instanceof h) {
            ((h) sv).b(aVar.height, new 1(this, bundle, cVar));
            return;
        }
        x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{aVar.id});
        bundle.putBoolean("ret", false);
        bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
        cVar.at(bundle);
    }
}
