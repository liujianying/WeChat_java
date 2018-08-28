package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.a;
import com.tencent.mm.plugin.appbrand.dynamic.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.i;

class IPCDynamicPageView$3 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ Bundle fuf;
    final /* synthetic */ IPCDynamicPageView fyl;
    final /* synthetic */ u fym;
    final /* synthetic */ String sk;

    public IPCDynamicPageView$3(IPCDynamicPageView iPCDynamicPageView, String str, Bundle bundle, u uVar, String str2) {
        this.fyl = iPCDynamicPageView;
        this.sk = str;
        this.fuf = bundle;
        this.fym = uVar;
        this.bAj = str2;
    }

    public final void run() {
        if (!(IPCDynamicPageView.e(this.fyl) == null || this.sk.equals(IPCDynamicPageView.e(this.fyl)))) {
            this.fyl.detach();
        }
        IPCDynamicPageView.a(this.fyl, this.sk);
        IPCDynamicPageView.a(this.fyl, this.fuf);
        IPCDynamicPageView.a(this.fyl, new v(this.fym));
        a f = IPCDynamicPageView.f(this.fyl);
        String str = this.sk;
        String str2 = this.bAj;
        Bundle bundle = this.fuf;
        f.doU = str;
        String str3 = "Token#" + System.nanoTime();
        f.fuc = str3;
        Parcelable bundle2 = new Bundle();
        bundle2.putString("id", str);
        bundle2.putString("appId", str2);
        if (bundle != null) {
            bundle2.putInt("scene", bundle.getInt("scene"));
            bundle2.putInt("widgetType", bundle.getInt("widget_type"));
            bundle2.putInt("serviceType", bundle.getInt("service_type"));
            bundle2.putInt("wxaPkgType", bundle.getInt("msg_pkg_type"));
            bundle2.putString("searchId", bundle.getString("search_id", ""));
            bundle2.putInt("pkgVersion", bundle.getInt("pkg_version"));
            bundle2.putString("preloadLaunchData", bundle.getString("preload_launch_data", ""));
            bundle2.putString("cache_key", bundle.getString("cache_key", ""));
        }
        s.i("MicroMsg.DynamicIPCJsBridge", " attach %s", new Object[]{str});
        f.a(i.aeT().sz(str), bundle2, c.class, new 1(f, str3, str, str2, bundle));
        IPCDynamicPageView.b(this.fyl, false);
    }
}
