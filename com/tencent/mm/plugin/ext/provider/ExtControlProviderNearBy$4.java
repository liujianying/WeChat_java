package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.g.a.jz;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderNearBy$4 implements a {
    final /* synthetic */ ExtControlProviderNearBy iKu;

    ExtControlProviderNearBy$4(ExtControlProviderNearBy extControlProviderNearBy) {
        this.iKu = extControlProviderNearBy;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!ExtControlProviderNearBy.g(this.iKu)) {
            ExtControlProviderNearBy.h(this.iKu);
            if (z) {
                jz jzVar = new jz();
                jzVar.bUe.bNI = ExtControlProviderNearBy.i(this.iKu);
                jzVar.bUe.bUg = f;
                jzVar.bUe.bSx = f2;
                jzVar.bUe.bUh = (int) d2;
                jzVar.bUe.bUi = i;
                jzVar.bUe.bUj = "";
                jzVar.bUe.bUk = "";
                if (com.tencent.mm.sdk.b.a.sFg.m(jzVar)) {
                    x.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                }
            } else {
                x.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                ExtControlProviderNearBy.f(this.iKu);
                ExtControlProviderNearBy.c(this.iKu).countDown();
            }
        }
        return false;
    }
}
