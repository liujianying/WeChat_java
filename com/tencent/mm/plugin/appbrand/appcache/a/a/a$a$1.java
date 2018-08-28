package com.tencent.mm.plugin.appbrand.appcache.a.a;

import com.tencent.mm.plugin.appbrand.appcache.base.b.a;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;

class a$a$1 implements a<m, k> {
    final /* synthetic */ b dEk;
    final /* synthetic */ a.a fiI;

    a$a$1(a.a aVar, b bVar) {
        this.fiI = aVar;
        this.dEk = bVar;
    }

    public final /* synthetic */ void a(String str, a.a aVar, Object obj) {
        b bVar = this.dEk;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(aVar == a.a.fio);
        bVar.v(objArr);
        x.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s onPkgUpdateResult, ret %s", new Object[]{str, aVar.name()});
    }

    public final void a(k kVar) {
    }
}
