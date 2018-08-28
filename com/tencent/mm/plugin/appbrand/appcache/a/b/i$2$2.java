package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.i.2;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class i$2$2 implements a<Void, Boolean> {
    final /* synthetic */ b fiG;
    final /* synthetic */ 2 fiX;

    i$2$2(2 2, b bVar) {
        this.fiX = 2;
        this.fiG = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool != null && bool.booleanValue()) {
            boolean a = f.a(((y) e.x(y.class)).q(this.fiX.fiV.field_appId, this.fiX.fiV.field_type, this.fiX.fiV.field_version), f.a.fiO);
            x.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "record(%s %d %d) download ok, decryptResult %b", new Object[]{this.fiX.fiV.field_appId, Integer.valueOf(this.fiX.fiV.field_type), Integer.valueOf(this.fiX.fiV.field_version), Boolean.valueOf(a)});
        }
        this.fiG.resume();
        return null;
    }
}
