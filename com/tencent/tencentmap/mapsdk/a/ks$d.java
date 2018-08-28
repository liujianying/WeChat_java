package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ic.c;
import java.lang.ref.WeakReference;

class ks$d implements he {
    private final WeakReference<ks> a;

    public ks$d(ks ksVar) {
        this.a = new WeakReference(ksVar);
    }

    public void a(c cVar) {
        if (this.a != null && this.a.get() != null && cVar == c.c) {
            ks.g((ks) this.a.get());
            ks.h((ks) this.a.get());
        }
    }
}
