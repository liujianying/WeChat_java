package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.m.a;
import com.tencent.mm.plugin.appbrand.config.m.b;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class m$1 implements b {
    final /* synthetic */ String frx;

    m$1(String str) {
        this.frx = str;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.b bVar) {
        if (i == 0 && i2 == 0) {
            ze zeVar = (ze) bVar.dIE.dIL;
            if (zeVar.rFl == null || zeVar.rFl.size() == 0) {
                x.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                return;
            }
            x.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[]{Integer.valueOf(zeVar.rFl.size())});
            Iterator it = zeVar.rFl.iterator();
            while (it.hasNext()) {
                cw cwVar = (cw) it.next();
                x.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{cwVar.rcW, Integer.valueOf(cwVar.rcV)});
                if (!bi.oW(cwVar.rcW)) {
                    a.A(this.frx, cwVar.hcE, cwVar.rcV);
                    a.B(this.frx, cwVar.hcE, cwVar.rcV);
                    a.h(this.frx, cwVar.hcE, cwVar.rcW);
                }
            }
            return;
        }
        x.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
