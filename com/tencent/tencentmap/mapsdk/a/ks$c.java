package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

class ks$c implements id {
    private final WeakReference<ks> a;

    public ks$c(ks ksVar) {
        this.a = new WeakReference(ksVar);
    }

    public void a(ic icVar) {
        if (this.a != null && this.a.get() != null) {
            if (icVar != null) {
                ((ks) this.a.get()).a(icVar.j());
            }
            if (ks.f((ks) this.a.get()) != null) {
                ks.f((ks) this.a.get()).sendEmptyMessage(0);
            }
        }
    }
}
