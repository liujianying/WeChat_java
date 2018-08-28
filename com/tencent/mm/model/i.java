package com.tencent.mm.model;

import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import junit.framework.Assert;

public final class i {
    public static void gy(String str) {
        Assert.assertTrue(!bi.oW(str));
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(str);
        if (Yg != null && !bi.oW(Yg.field_username)) {
            Yg.setType(Yg.field_type | 2048);
            s.t(Yg);
            if (((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(str) == null && Yg.ckW()) {
                if (f.kJ(str)) {
                    ai aiVar;
                    if (((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq("officialaccounts") == null) {
                        aiVar = new ai("officialaccounts");
                        aiVar.clx();
                        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().d(aiVar);
                    }
                    aiVar = new ai(str);
                    aiVar.as(System.currentTimeMillis());
                    aiVar.ef("officialaccounts");
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().d(aiVar);
                } else if (f.kL(str) && !f.eZ(str)) {
                    ai aiVar2;
                    d kH = f.kH(str);
                    if (((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(kH.field_enterpriseFather) == null) {
                        aiVar2 = new ai(kH.field_enterpriseFather);
                        aiVar2.clx();
                        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().d(aiVar2);
                    }
                    aiVar2 = new ai(str);
                    aiVar2.as(System.currentTimeMillis());
                    aiVar2.ef(kH.Mg());
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().d(aiVar2);
                }
                x.i("MicroMsg.BizConversationLogic", "setPlacedTop username = " + str);
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yv(str);
        }
    }

    public static int a(String str, long j, a aVar) {
        x.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[]{Long.valueOf(j)});
        g.Em().H(new 1(str, j, aVar));
        return 0;
    }
}
