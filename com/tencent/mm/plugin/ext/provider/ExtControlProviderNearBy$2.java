package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.modelgeo.c;

class ExtControlProviderNearBy$2 implements Runnable {
    final /* synthetic */ ExtControlProviderNearBy iKu;

    ExtControlProviderNearBy$2(ExtControlProviderNearBy extControlProviderNearBy) {
        this.iKu = extControlProviderNearBy;
    }

    public final void run() {
        if (ExtControlProviderNearBy.a(this.iKu) == null) {
            ExtControlProviderNearBy.a(this.iKu, c.OB());
        }
        ExtControlProviderNearBy.a(this.iKu).a(ExtControlProviderNearBy.b(this.iKu), true);
    }
}
