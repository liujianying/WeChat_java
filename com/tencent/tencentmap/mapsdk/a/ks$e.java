package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

class ks$e implements hg {
    private final WeakReference<ks> a;

    public ks$e(ks ksVar) {
        this.a = new WeakReference(ksVar);
    }

    public void a() {
        ks ksVar = (ks) this.a.get();
        if (ksVar != null && ks.f(ksVar) != null) {
            ks.f(ksVar).sendEmptyMessage(1);
        }
    }
}
