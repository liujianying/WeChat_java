package com.tencent.mm.ac;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.az.a;

class z$10 implements a {
    final /* synthetic */ z dMY;

    z$10(z zVar) {
        this.dMY = zVar;
    }

    public final void a(ai aiVar, az azVar) {
        if (aiVar != null && !bi.oW(aiVar.field_username)) {
            String str = aiVar.field_username;
            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
            if (Yg != null && Yg.ckW() && !s.hr(str)) {
                d kA = z.MY().kA(str);
                if (kA.sKx == -1) {
                    x.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                } else if (kA.LZ()) {
                    if (kA.bG(false) == null) {
                        aiVar.ef(null);
                        x.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                    } else if (kA.bG(false).MB() == null) {
                        aiVar.ef(null);
                        x.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                    } else if (kA.Ma()) {
                        aiVar.ef(null);
                    } else {
                        aiVar.ef(bi.oV(kA.Mg()));
                        if (bi.oW(kA.Mg())) {
                            x.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[]{aiVar.field_username});
                        }
                    }
                } else if (kA.LV() || kA.LY() || s.hM(str)) {
                    aiVar.ef(null);
                } else {
                    aiVar.ef("officialaccounts");
                }
            }
        }
    }
}
