package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.sdk.platformtools.x;

class WxaWidgetInitializer$1$1 implements e {
    final /* synthetic */ d fuX;
    final /* synthetic */ 1 fuY;

    WxaWidgetInitializer$1$1(1 1, d dVar) {
        this.fuY = 1;
        this.fuX = dVar;
    }

    public final void T(String str, boolean z) {
        boolean z2 = false;
        WxaWidgetContext wxaWidgetContext = null;
        x.d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[]{this.fuY.sk, Integer.valueOf(this.fuY.fen), Integer.valueOf(this.fuY.fuS), str, Boolean.valueOf(z)});
        s.i("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", this.fuY.sk, Integer.valueOf(this.fuY.fen), Integer.valueOf(this.fuY.fuS), str, Boolean.valueOf(z));
        if (z) {
            WxaPkgWrappingInfo b = a.b(this.fuY.sk, str, this.fuY.fuW, this.fuY.fen, 0);
            if (b != null) {
                wxaWidgetContext = WxaWidgetInitializer.a(this.fuY.sk, str, b, this.fuX);
            } else {
                z = false;
            }
        }
        if (this.fuY.fuV != null) {
            WxaWidgetInitializer.a aVar = this.fuY.fuV;
            String str2 = this.fuY.sk;
            if (z && wxaWidgetContext != null) {
                z2 = true;
            }
            aVar.a(str2, str, z2, wxaWidgetContext);
        }
    }
}
