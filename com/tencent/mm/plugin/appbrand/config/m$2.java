package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.m.a;
import com.tencent.mm.plugin.appbrand.config.m.b;
import com.tencent.mm.plugin.appbrand.config.m.c;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements b {
    final /* synthetic */ String frx;
    final /* synthetic */ c fry;

    m$2(c cVar, String str) {
        this.fry = cVar;
        this.frx = str;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.b bVar) {
        if (i == 0 && i2 == 0) {
            ze zeVar = (ze) bVar.dIE.dIL;
            if (zeVar.rFl == null || zeVar.rFl.size() == 0) {
                x.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                if (this.fry != null) {
                    this.fry.qR("");
                    return;
                }
                return;
            }
            cw cwVar = (cw) zeVar.rFl.get(0);
            x.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{cwVar.rcW, Integer.valueOf(cwVar.rcV)});
            if (!bi.oW(cwVar.rcW)) {
                a.A(this.frx, cwVar.hcE, cwVar.rcV);
                a.B(this.frx, cwVar.hcE, cwVar.rcV);
                a.h(this.frx, cwVar.hcE, cwVar.rcW);
                if (this.fry != null) {
                    this.fry.qR(cwVar.rcW);
                    return;
                }
                return;
            } else if (this.fry != null) {
                this.fry.qR("");
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.fry != null) {
            this.fry.qR("");
        }
    }
}
