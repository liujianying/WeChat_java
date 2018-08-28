package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class d implements a<Boolean, Boolean> {
    private b eAc = null;

    public final /* synthetic */ Object call(Object obj) {
        Boolean bool = (Boolean) obj;
        this.eAc = g.cBF();
        x.v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", new Object[]{bool});
        if (!com.tencent.d.b.a.cFN()) {
            x.w("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo not support soter");
            this.eAc.ct(g.w(Integer.valueOf(2), "not support soter"));
        } else if (bool.booleanValue()) {
            SharedPreferences chZ = ad.chZ();
            if (chZ != null) {
                x.i("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo old cpuId: %s, old uid: %s", new Object[]{chZ.getString("cpu_id", null), chZ.getString("uid", null)});
                if (bi.oW(chZ.getString("cpu_id", null)) || bi.oW(r0)) {
                    h cFE = com.tencent.d.a.a.cFE();
                    if (cFE != null) {
                        String str = cFE.onE;
                        String valueOf = String.valueOf(cFE.uid);
                        if (!(bi.oW(str) || bi.oW(valueOf))) {
                            com.tencent.mm.plugin.soter.c.b.eQ(str, valueOf);
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(true);
    }
}
