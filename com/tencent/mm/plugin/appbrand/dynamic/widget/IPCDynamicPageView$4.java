package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class IPCDynamicPageView$4 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ Bundle fuf;
    final /* synthetic */ IPCDynamicPageView fyl;
    final /* synthetic */ String sk;

    IPCDynamicPageView$4(IPCDynamicPageView iPCDynamicPageView, Bundle bundle, String str, String str2) {
        this.fyl = iPCDynamicPageView;
        this.fuf = bundle;
        this.sk = str;
        this.bAj = str2;
    }

    public final void run() {
        String str = "";
        if (this.fuf != null) {
            str = this.fuf.getString("cache_key", "");
        }
        x.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s, %s)", new Object[]{this.sk, this.bAj, str});
        s.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s, %s)", new Object[]{this.sk, this.bAj, str});
        IPCDynamicPageView.a(this.fyl, b.sJ(this.sk));
        if (IPCDynamicPageView.g(this.fyl) == null) {
            IPCDynamicPageView.a(this.fyl, new g());
        }
        IPCDynamicPageView.g(this.fyl).field_id = this.sk;
        IPCDynamicPageView.g(this.fyl).field_cacheKey = str;
        IPCDynamicPageView.g(this.fyl).field_appId = this.bAj;
        this.fyl.setId(this.sk);
        e aeR = e.aeR();
        String str2 = this.sk;
        IPCDynamicPageView iPCDynamicPageView = this.fyl;
        if (bi.oW(str2)) {
            x.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
        } else if (iPCDynamicPageView == null) {
            x.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
        } else {
            WeakReference weakReference = (WeakReference) aeR.fuG.put(str2, new WeakReference(iPCDynamicPageView));
            if (!(weakReference == null || weakReference.get() == null)) {
                x.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[]{str2});
            }
        }
        if (this.fuf != null) {
            this.fuf.putBundle("__env_args", IPCDynamicPageView.b(this.fyl, this.fuf));
        }
        IPCDynamicPageView.f(this.fyl);
        str = this.sk;
        str2 = this.bAj;
        Bundle bundle = this.fuf;
        Parcelable bundle2 = new Bundle();
        bundle2.putString("id", str);
        bundle2.putString("appId", str2);
        bundle2.putBundle("extData", bundle);
        f.a(i.aeT().sz(str), bundle2, a$a.class, null);
    }
}
