package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.a;
import com.tencent.mm.plugin.appbrand.dynamic.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class IPCDynamicPageView$2 implements Runnable {
    final /* synthetic */ IPCDynamicPageView fyl;

    IPCDynamicPageView$2(IPCDynamicPageView iPCDynamicPageView) {
        this.fyl = iPCDynamicPageView;
    }

    public final void run() {
        String e = IPCDynamicPageView.e(this.fyl);
        if (bi.oW(e)) {
            x.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
            return;
        }
        IPCDynamicPageView.b(this.fyl, true);
        a f = IPCDynamicPageView.f(this.fyl);
        if (e == null || e.length() == 0) {
            x.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[]{Integer.valueOf(f.hashCode())});
        } else {
            x.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[]{Integer.valueOf(f.hashCode()), e});
            Parcelable bundle = new Bundle();
            bundle.putString("id", e);
            f.a(i.aeT().sz(e), bundle, b.class, new 2(f, e));
            j aeV = j.aeV();
            if (aeV.fuI.containsKey(e)) {
                aeV.fuI.remove(e);
            } else {
                com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[]{e});
            }
        }
        e aeR = e.aeR();
        if (bi.oW(e)) {
            x.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        } else {
            WeakReference weakReference = (WeakReference) aeR.fuG.remove(e);
            if (weakReference != null) {
                weakReference.get();
            }
        }
        this.fyl.cleanup();
        IPCDynamicPageView.a(this.fyl, null);
        IPCDynamicPageView.a(this.fyl, null);
        IPCDynamicPageView.a(this.fyl, null);
        IPCDynamicPageView.a(this.fyl, false);
        IPCDynamicPageView.d(this.fyl).adm();
    }
}
