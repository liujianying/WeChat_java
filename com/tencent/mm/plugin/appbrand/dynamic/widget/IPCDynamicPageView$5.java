package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;

class IPCDynamicPageView$5 implements Runnable {
    final /* synthetic */ IPCDynamicPageView fyl;

    IPCDynamicPageView$5(IPCDynamicPageView iPCDynamicPageView) {
        this.fyl = iPCDynamicPageView;
    }

    public final void run() {
        IPCDynamicPageView.f(this.fyl);
        String e = IPCDynamicPageView.e(this.fyl);
        Parcelable bundle = new Bundle();
        bundle.putString("id", e);
        f.a(i.aeT().sz(e), bundle, a$d.class, null);
    }
}
