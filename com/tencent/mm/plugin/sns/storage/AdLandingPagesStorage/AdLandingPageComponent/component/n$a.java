package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Looper;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import java.io.Serializable;

class n$a extends d implements Serializable {
    final /* synthetic */ n nDS;
    c nDV = new c(this);
    c nDW = new g(this);
    c nDX = new e(this);
    c nDY = new h(this);
    c nDZ = new i(this);
    c nEa = new f(this);
    c nEb = new b(this);
    c nEc = new a(this);
    c nEd = new d(this);

    protected n$a(n nVar, String str) {
        this.nDS = nVar;
        super(str, Looper.getMainLooper());
        a(this.nDW);
        a(this.nDV);
        a(this.nDX);
        a(this.nDY);
        a(this.nDZ);
        a(this.nEa);
        a(this.nEb);
        a(this.nEc);
        a(this.nEd);
        b(this.nEd);
        AdLandingPagesProxy.getInstance().addReportInfo(n.b(nVar).bPS, n.b(nVar).nyk, n.b(nVar).nyj);
    }
}
