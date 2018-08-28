package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.model.ah;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

class g$1 extends ah {
    final /* synthetic */ g fqI;

    public g$1(g gVar) {
        this.fqI = gVar;
    }

    public final void transfer(int i) {
        if (gV(i)) {
            try {
                x.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                e aaW = e.aaW();
                if (aaW != null) {
                    a aaX = aaW.aaX();
                    e.aba();
                    aaX.fV("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[]{"WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"}));
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", new Object[]{e});
            }
        }
    }

    public final boolean gV(int i) {
        return i >= 637863936 && i <= 637863988;
    }

    public final String getTag() {
        return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
    }
}
