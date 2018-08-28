package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ar.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.File;

class d$1 extends c<cm> {
    final /* synthetic */ d kon;

    d$1(d dVar) {
        this.kon = dVar;
        this.sFo = cm.class.getName().hashCode();
    }

    private boolean a(cm cmVar) {
        if (cmVar instanceof cm) {
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
            au.HU();
            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(a.sQP, Integer.valueOf(0))).intValue();
            int i = g.AT().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i)});
            if (intValue != i) {
                au.HU();
                com.tencent.mm.model.c.DT().a(a.sQP, Integer.valueOf(i));
                r.Qp().ij(26);
                c aXb = c.aXb();
                x.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[]{e.duN + "ipcallCountryCodeConfig.cfg"});
                try {
                    File file = new File(e.duN + "ipcallCountryCodeConfig.cfg");
                    if (file.exists()) {
                        file.delete();
                    }
                    aXb.huc = false;
                    aXb.kok.clear();
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[]{e.getMessage()});
                }
                this.kon.fN(true);
            }
        }
        return false;
    }
}
