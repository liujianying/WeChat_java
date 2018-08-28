package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;

class n$a implements a<Bundle, Bundle> {
    private n$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = new Bundle();
        View sv = e.aeR().sv(bundle.getString("id"));
        if (sv instanceof h) {
            ((h) sv).a("selector", bundle.getString("data"), new 1(this, bundle2, cVar));
            return;
        }
        b.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "showPickerView failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{bundle.getString("id")});
        bundle2.putBoolean("ret", false);
        bundle2.putString("reason", "view is not a instance of DynamicPageAccessible");
        cVar.at(bundle2);
    }
}
