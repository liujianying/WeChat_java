package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1;
import com.tencent.mm.plugin.appbrand.dynamic.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements a<Bundle, Bundle> {
    private a$c() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("id");
        String string2 = bundle.getString("appId");
        int i = bundle.getInt("wxaPkgType");
        int i2 = bundle.getInt("pkgVersion");
        int i3 = bundle.getInt("scene");
        String string3 = bundle.getString("searchId");
        int i4 = bundle.getInt("widgetType");
        int i5 = bundle.getInt("serviceType");
        String string4 = bundle.getString("preloadLaunchData", "");
        if (d.aeQ().su(string) == null) {
            c cVar2 = new c(ad.getContext());
            d aeQ = d.aeQ();
            if (bi.oW(string)) {
                x.w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
            } else {
                if (((c) aeQ.fuE.put(string, cVar2)) != null) {
                    x.i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", new Object[]{string});
                }
                x.d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", new Object[]{string});
            }
        }
        f aeS = f.aeS();
        String string5 = bundle.getString("query");
        String string6 = bundle.getString("cache_key", string5);
        if (aeS.fuI.containsKey(string)) {
            x.w("MicroMsg.DynamicPageViewStateMonitor", "OnAttach with same widgetId[%s]", new Object[]{string});
            aeS.fuI.remove(string);
        }
        aeS.fuI.put(string, new b(string, string2, i5, string6));
        j aeV = j.aeV();
        int i6 = i + 1;
        string5 = bundle.getString("query");
        string5 = bundle.getString("cache_key", string5);
        if (aeV.fuI.containsKey(string)) {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnAttach with same widgetId[%s]", string);
            aeV.fuI.remove(string);
        }
        j.b bVar = new j.b(string, string2, i6, string5, i5);
        aeV.fuI.put(string, bVar);
        Parcelable toBundle = bVar.toBundle();
        f.a("com.tencent.mm", toBundle, j.a.class);
        f.a("com.tencent.mm:support", toBundle, j.a.class);
        f.a("com.tencent.mm:tools", toBundle, j.a.class);
        aeV.C(string, 626, 0);
        final c cVar3 = cVar;
        string5 = string;
        b.n(new 1(string5, com.tencent.mm.plugin.appbrand.dynamic.k.b.bH(i4, i), i2, string2, i4, i3, string4, new WxaWidgetInitializer.a() {
            public final void bf(String str, String str2) {
                Bundle bundle = new Bundle();
                bundle.putInt("op", 0);
                bundle.putString("id", str);
                bundle.putString("appId", str2);
                cVar3.at(bundle);
            }

            public final void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext) {
                Bundle bundle = new Bundle();
                bundle.putInt("op", 1);
                bundle.putString("id", str);
                bundle.putString("appId", str2);
                bundle.putBoolean("success", z);
                if (wxaWidgetContext != null) {
                    s.i("MicroMsg.DynamicIPCJsBridge", " OnInitializeCallback.onInitialized putContext %s", new Object[]{str});
                    bundle.putParcelable("fwContext", wxaWidgetContext);
                    k.a(str, wxaWidgetContext);
                }
                cVar3.at(bundle);
            }
        }, string3));
    }
}
