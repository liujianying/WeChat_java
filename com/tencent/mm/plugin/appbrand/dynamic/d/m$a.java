package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;

class m$a implements a<Bundle, Bundle> {
    private m$a() {
    }

    public final /* synthetic */ void a(Object obj, final c cVar) {
        Bundle bundle = (Bundle) obj;
        final Bundle bundle2 = new Bundle();
        View sv = e.aeR().sv(bundle.getString("id"));
        if (sv instanceof h) {
            ((h) sv).a("date", bundle.getString("data"), new r() {
                public final void b(boolean z, String str, Bundle bundle) {
                    bundle2.putBoolean("ret", z);
                    bundle2.putString("reason", str);
                    bundle2.putBundle("data", bundle);
                    cVar.at(bundle2);
                }
            });
            return;
        }
        b.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "showDatePickerView failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{bundle.getString("id")});
        bundle2.putBoolean("ret", false);
        bundle2.putString("reason", "view is not a instance of DynamicPageAccessible");
        cVar.at(bundle2);
    }
}
